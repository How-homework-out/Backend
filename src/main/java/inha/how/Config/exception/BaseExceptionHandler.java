package inha.how.Config.exception;

import inha.how.Config.BaseResponse;
import inha.how.Config.BaseResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler({BaseException.class})
    protected BaseResponse handleBaseException(BaseException ex){
        return new BaseResponse(ex.getBaseResponseStatus());
    }
}
