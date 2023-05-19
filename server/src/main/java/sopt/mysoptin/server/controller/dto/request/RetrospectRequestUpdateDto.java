package sopt.mysoptin.server.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RetrospectRequestUpdateDto {
    private Long retrospectId;
    @JsonProperty("isPublic")
    private boolean isPublic;
    private String descRoutine;
    private String descBest;
    private String descSelf;
    private String writtenDate;
}
