package sopt.mysoptin.server.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
public enum Success {

    /**
     * 200 OK
     */
    GET_RETROSPECT_LIST_SUCCESS(HttpStatus.OK, "회고 전체 조회에 성공했습니다."),
    GET_RETROSPECT_SUCCESS(HttpStatus.OK, "회고 단일 조회에 성공했습니다."),
    GET_ROUTINE_LIST_SUCCESS(HttpStatus.OK, "해당 일자 루틴 목록 조회 성공"),


    UPDATE_RETROSPECT_SUCCESS(HttpStatus.OK, "정회고 수정을 성공했습니다."),

    /**
     * 201 CREATED
     */
    POST_RETROSPECT_SUCCESS(HttpStatus.CREATED, "회고 생성 성공"),


    /**
     * 204 NO CONTENT
     */
    GET_RETROSPECT_NO_CONTENT_SUCCESS(HttpStatus.NO_CONTENT, "작성된 적이 없는 회고입니다."),
    GET_ROUTINE_NO_CONTENT_SUCCESS(HttpStatus.NO_CONTENT, "루틴이 존재하지 않습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}