package sopt.mysoptin.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.mysoptin.server.common.dto.ApiResponse;
import sopt.mysoptin.server.controller.dto.response.RetrospectResponseDto;
import sopt.mysoptin.server.exception.Success;
import sopt.mysoptin.server.service.RetrospectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retro")
public class RetrospectController {
    private final RetrospectService retrospectService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<RetrospectResponseDto> getOne(@RequestParam final String date){
        RetrospectResponseDto data = retrospectService.getOne(date);
        if (data == null) {
            return ApiResponse.success(Success.GET_RETROSPECT_NO_CONTENT_SUCCESS);
        } else {
            return ApiResponse.success(Success.GET_RETROSPECT_SUCCESS, data);
        }

    }
}
