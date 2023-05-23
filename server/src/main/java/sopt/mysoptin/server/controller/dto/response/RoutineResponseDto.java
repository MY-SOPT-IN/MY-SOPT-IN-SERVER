package sopt.mysoptin.server.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoutineResponseDto {
    private Long routineId;
    private String routineName;
    private String routineAt;

    public static RoutineResponseDto of(Long routineId, String routineName, String routineAt) {
        return new RoutineResponseDto(routineId, routineName, routineAt);
    }
}
