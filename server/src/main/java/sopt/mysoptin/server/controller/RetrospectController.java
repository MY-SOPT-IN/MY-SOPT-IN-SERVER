package sopt.mysoptin.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retro")
public class RetrospectController {
    private final RetrospectService retrospectService;

    @GetMapping("/")
    public ApiResponseDto<RetroResponseDto> getOne(@RequestParam final String date) {

    }
}
