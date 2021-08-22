package net.trollheim.security.ctf.rest;

import net.trollheim.security.ctf.dto.*;
import net.trollheim.security.ctf.service.FlagService;
import net.trollheim.security.ctf.service.SummissionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MainController {

    private final SummissionService summissionService;
    private final FlagService flagService;

    public MainController(SummissionService summissionService, FlagService flagService) {
        this.summissionService = summissionService;
        this.flagService = flagService;
    }

    @PostMapping(value = "/api/submit", consumes = "application/json")
    public Result register(@Validated @RequestBody SubmissionDto submissionDto) {
        return summissionService.submit(submissionDto);
    }


    @GetMapping( path = "/api/ranks")
    public RankDto getRank() {
        return flagService.getRanks();
    }

    @GetMapping("/api/flags")
    public List<FlagDetailsDto> getFlagsDetails() {
        return flagService.getActiveFlagsDetails();
    }

    @GetMapping("/api/flag/{number}")
    public FlagDetailsDto getFlagDetails(@PathVariable("number") Integer number) {
        return flagService.getFlagDetails(number);
    }

    @GetMapping("/api/score")
    public ScoreDto getUserScore() {
        return flagService.getUserScore();
    }
}
