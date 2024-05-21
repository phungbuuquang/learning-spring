package vn.unigap.common.response;
import org.springframework.http.HttpStatus;
import lombok.*;
import vn.unigap.common.errorcode.ErrorCode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private Integer errorCode;
    private Integer statusCode;
    private String message;
    private T object;

    public static <T> ApiResponse<T> success(HttpStatus status, T object) {
        return ApiResponse.<T>builder()
                .errorCode(ErrorCode.SUCCESS)
                .statusCode(status != null ? status.value() : HttpStatus.OK.value())
                .object(object)
                .build();
    }

    public static <T> ApiResponse<T> error(Integer errorCode, HttpStatus httpStatus, String message) {
        return ApiResponse.<T>builder()
                .errorCode(errorCode)
                .statusCode(httpStatus.value())
                .message(message)
                .build();
    }
}
