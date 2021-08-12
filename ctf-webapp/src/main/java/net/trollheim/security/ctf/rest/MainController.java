package net.trollheim.security.ctf.rest;

import net.trollheim.security.ctf.dto.*;
import net.trollheim.security.ctf.service.FlagService;
import net.trollheim.security.ctf.service.SummissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MainController {

    private final SummissionService summissionService;
    private final FlagService flagService;

    public MainController(SummissionService summissionService, FlagService flagService) {
        this.summissionService = summissionService;
        this.flagService = flagService;
    }

    @PostMapping(value = "/api/submit", consumes = "application/json")
    public Result register(@RequestBody SubmissionDto submissionDto) {
        return summissionService.submit(submissionDto);
    }


    @GetMapping( path = "/api/ranks")
    public RankDto getRank() {
        return flagService.getRanks();
    }

    @GetMapping("/api/flag")
    public FlagDetailsDto getFlagDetails() {
        return flagService.getActiveFlagDetails();
    }

    @GetMapping("/api/score")
    public ScoreDto getUserScore() {
        return flagService.getUserScore();
    }
}
