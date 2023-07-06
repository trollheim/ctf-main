package net.trollheim.security.ctf.service;


import net.trollheim.security.ctf.dto.Result;
import net.trollheim.security.ctf.dto.SubmissionDto;
import net.trollheim.security.ctf.model.AppUser;
import net.trollheim.security.ctf.model.Flag;
import net.trollheim.security.ctf.model.Submission;
import net.trollheim.security.ctf.repository.FlagRepository;
import net.trollheim.security.ctf.repository.SubmissionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SummissionService {

    private final SubmissionRepository submissionRepository;
    private final FlagRepository flagRepository;

    public SummissionService(SubmissionRepository submissionRepository, FlagRepository flagRepository) {
        this.submissionRepository = submissionRepository;
        this.flagRepository = flagRepository;
    }


    public Result submit(SubmissionDto submissionDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();


        Flag flag = flagRepository.findById(submissionDto.getFlag()).orElseThrow(()->new RuntimeException());

        //TODO check flag format

        if (flag.getEndDate().isBefore(LocalDateTime.now())){
            return Result.EXPIRED;
        }

        if (!flag.getCode().equalsIgnoreCase(submissionDto.getCode())){
            return Result.INVALID;

        }
        Submission submission = new Submission();
        submission.setAppUser(user);

        submission.setFlag(flag);
        submission.setSubmission(LocalDateTime.now());
        submissionRepository.save(submission);
        return Result.VALID;
    }

}
