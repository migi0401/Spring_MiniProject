package NetZero.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러입니다. 관리자에게 문의하세요."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "잘못된 입력값입니다."),

    // 2. 회원 관련 에러 (Member)
    // =======================================================
    // 상황: DB에 없는 ID로 조회/저장 하려고 할 때
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),

    // 상황: (추후 추가 가능) 이미 가입된 닉네임일 때
    DUPLICATE_USER(HttpStatus.BAD_REQUEST, "이미 존재하는 회원입니다."),

    // =======================================================
    // 3. 걸음 수 관련 에러 (Step)
    // =======================================================
    // 상황: 걸음 수가 음수로 들어오거나, 비정상적인 수치일 때
    INVALID_STEP_COUNT(HttpStatus.BAD_REQUEST, "걸음 수는 0 이상이어야 합니다."),

    // 상황: 미래 날짜의 걸음 수를 저장하려고 할 때 (유효성 검사)
    INVALID_STEP_DATE(HttpStatus.BAD_REQUEST, "미래의 걸음 수는 저장할 수 없습니다."),

    // =======================================================
    // 4. 쿠폰 & 포인트 관련 에러 (Coupon & Point)
    // =======================================================
    // 상황: 쿠폰 살 돈이 부족할 때 (가장 중요! ⭐)
    NOT_ENOUGH_POINT(HttpStatus.BAD_REQUEST, "포인트가 부족합니다."),

    // 상황: 존재하지 않는 쿠폰을 조회하려고 할 때
    COUPON_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 쿠폰입니다."),

    // 상황: 이미 사용한 쿠폰을 또 쓰려고 할 때
    ALREADY_USED_COUPON(HttpStatus.BAD_REQUEST, "이미 사용된 쿠폰입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
