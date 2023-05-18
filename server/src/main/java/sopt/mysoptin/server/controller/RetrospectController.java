package sopt.mysoptin.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.mysoptin.server.service.RetrospectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retro")
public class RetrospectController {
    private final RetrospectService retrospectService;

    @GetMapping("/")
    public ApiResponseDto<RetroResponseDto> getOne(@RequestParam final String date) {

    }
}
