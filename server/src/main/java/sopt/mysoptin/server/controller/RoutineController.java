package sopt.mysoptin.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.mysoptin.server.common.dto.ApiResponse;
import sopt.mysoptin.server.controller.dto.response.RoutineResponseDto;
import sopt.mysoptin.server.exception.Success;
import sopt.mysoptin.server.service.RoutineService;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/routine")
public class RoutineController {

    private final RoutineService routineService;

    @GetMapping("/{targetDate}")
    public ApiResponse getRoutinesOfDate(@PathVariable("targetDate") String targetDate) {
        List<RoutineResponseDto> result = routineService.getAllRoutineOf(targetDate);
        if (result.isEmpty()) {
            return ApiResponse.success(Success.GET_ROUTINE_NO_CONTENT_SUCCESS, Collections.emptyList());
        }
        return ApiResponse.success(Success.GET_ROUTINE_LIST_SUCCESS, result);
    }
}
