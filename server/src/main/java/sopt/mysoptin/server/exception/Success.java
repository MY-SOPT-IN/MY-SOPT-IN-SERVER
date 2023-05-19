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

    /**
     * 201 CREATED
     */

    /**
     * 204 NO CONTENT
     */
    GET_RETROSPECT_NO_CONTENT_SUCCESS(HttpStatus.NO_CONTENT, "작성된 적이 없는 회고입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}