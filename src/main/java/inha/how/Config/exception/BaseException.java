package inha.how.Config.exception;

import inha.how.Config.BaseResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException{
    private final BaseResponseStatus baseResponseStatus;
}
