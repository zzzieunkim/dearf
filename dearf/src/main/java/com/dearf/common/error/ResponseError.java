package com.dearf.common.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseError {
    private String field;
    private String message;

    public static ResponseError of(FieldError e) {
        return ResponseError.builder()
                .field(e.getField())
                .message(e.getDefaultMessage())
                .build();
    }

    public static List<ResponseError> of(List<ObjectError> errors) {
        List<ResponseError> responseErrors = new ArrayList<>();
        if (errors != null) {
            errors.stream().forEach((e) -> {
            	//errors.stream()을 호출하면 errors의 요소를 순차적으로 처리할 수 있는 스트림을 생성
                responseErrors.add(ResponseError.of((FieldError)e));
            });
        }
        return responseErrors;
    }

}
