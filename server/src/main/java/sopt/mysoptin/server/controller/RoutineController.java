package sopt.mysoptin.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.mysoptin.server.common.dto.ApiResponse;
import sopt.mysoptin.server.exception.Success;
import sopt.mysoptin.server.exception.Error;
import sopt.mysoptin.server.service.RoutineService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/routine")
@Slf4j
public class RoutineController {
    private final RoutineService routineService;

    @DeleteMapping("/{routineId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteOne(@PathVariable("routineId") Long routineId) {
        boolean chk = routineService.deleteOne(routineId);
        if (chk)
            return ApiResponse.success(Success.DELETE_ROUTINE_SUCCESS);
        else
            return ApiResponse.error(Error.NOT_FOUND_ROUTINE_EXCEPTION);
    }
}
