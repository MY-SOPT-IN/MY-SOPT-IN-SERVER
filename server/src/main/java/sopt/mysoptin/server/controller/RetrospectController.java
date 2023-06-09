package sopt.mysoptin.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.mysoptin.server.common.dto.ApiResponse;
import sopt.mysoptin.server.controller.dto.request.RetrospectRequestCreateDto;
import sopt.mysoptin.server.controller.dto.request.RetrospectRequestUpdateDto;
import sopt.mysoptin.server.controller.dto.response.RetrospectResponseDto;
import sopt.mysoptin.server.exception.Success;
import sopt.mysoptin.server.service.RetrospectService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retro")
@Slf4j
public class RetrospectController {
    private final RetrospectService retrospectService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<RetrospectResponseDto> create(@RequestBody final RetrospectRequestCreateDto requestCreateDto) {
        log.info(Boolean.toString(requestCreateDto.isPublic()));
        return ApiResponse.success(Success.POST_RETROSPECT_SUCCESS, retrospectService.createRetrospect(requestCreateDto));
    }

    @PutMapping("/{retroId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<RetrospectResponseDto> update(@PathVariable("retroId") Long retroId, @RequestBody final RetrospectRequestUpdateDto requestUpdateDto) {
        return ApiResponse.success(Success.UPDATE_RETROSPECT_SUCCESS, retrospectService.updateRetrospect(retroId, requestUpdateDto));
    }
  
  
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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<RetrospectResponseDto>> getMonthList(@RequestParam final int month) {
        return ApiResponse.success(Success.GET_RETROSPECT_LIST_SUCCESS, retrospectService.getMonthList(month));
    }

}
