package com.lcwd.electronic.store.exceptions;

import com.lcwd.electronic.store.helper.ApiResponseMessage;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {



    // handler resources not found exception


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resurceNotFoundException(ResourceNotFoundException e) {

        ApiResponseMessage build = ApiResponseMessage.builder().message(e.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);
    }


}
