package com.shopping.homeListing.validations;

import com.shopping.homeListing.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ItemValidation {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> validateRequest(MethodArgumentNotValidException invalidReq){
        Map<String,String> errorMap = new HashMap<>();

        invalidReq.getBindingResult().getFieldErrors().forEach((e) -> {
            errorMap.put(e.getField(),e.getDefaultMessage());
        });

        return errorMap;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> itemNotFound(ItemNotFoundException notFound){
        Map<String,String> errorMap = new HashMap<>();

        errorMap.put("ITEM_NOT_FOUND",notFound.getMessage());
        return errorMap;
    }
}
