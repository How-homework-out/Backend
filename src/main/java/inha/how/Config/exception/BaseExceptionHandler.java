package inha.how.Config.exception;

import inha.how.Config.BaseResponse;
import inha.how.Config.BaseResponseStatus;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    protected BaseResponse handleBaseException(BaseException ex){
        return new BaseResponse(ex.getBaseResponseStatus());
    }

}
