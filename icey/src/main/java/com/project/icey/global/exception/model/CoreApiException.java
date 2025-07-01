package com.project.icey.global.exception.model;

import com.project.icey.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CoreApiException extends RuntimeException {

    private final ErrorCode errorCode;

    // 기존 메시지 기반 생성자
    public CoreApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    // 원인 예외 포함 생성자
    public CoreApiException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);  // 부모에 cause 전달
        this.errorCode = errorCode;
    }
}
