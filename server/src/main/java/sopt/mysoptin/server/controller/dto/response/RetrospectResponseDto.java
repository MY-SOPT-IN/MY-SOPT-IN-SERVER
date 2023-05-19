package sopt.mysoptin.server.controller.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RetrospectResponseDto {
    private Long retrospectId;
    private String descRoutine;
    private String descBest;
    private String descSelf;
    @JsonProperty("isPublic")
    private boolean isPublic;
    private String writtenDate;

    public static RetrospectResponseDto of(Long retrospectId, String descRoutine, String descBest, String descSelf, boolean isPublic, String writtenDate) {
        return new RetrospectResponseDto(retrospectId, descRoutine, descBest, descSelf, isPublic, writtenDate);
    }
}