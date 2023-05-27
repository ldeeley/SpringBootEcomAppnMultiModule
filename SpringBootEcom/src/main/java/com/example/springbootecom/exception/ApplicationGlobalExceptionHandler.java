package com.example.springbootecom.exception;

import com.example.springbootecom.dto.ErrorDTO;
import com.example.springbootecom.dto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDTO> errorDTOList=new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error->errorDTOList.add(new ErrorDTO(error.getDefaultMessage())));
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST);
        serviceResponse.setErrorDTOList(errorDTOList);
        return serviceResponse;
    }

    //AlbumNotFoundException
    @ExceptionHandler(AlbumNotFoundException.class)
    public ServiceResponse<?> albumNotFoundException(AlbumNotFoundException exception){
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDTO> errorDTOList=new ArrayList<>();
        errorDTOList.add(new ErrorDTO(exception.getMessage()));
        serviceResponse.setStatus(HttpStatus.BAD_REQUEST);
        serviceResponse.setErrorDTOList(errorDTOList);
        return serviceResponse;
    }

    //AlbumServiceBusinessException
    @ExceptionHandler(AlbumServiceBusinessException.class)
    public ServiceResponse<?> albumNotFoundException(AlbumServiceBusinessException exception){
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDTO> errorDTOList=new ArrayList<>();
        errorDTOList.add(new ErrorDTO(exception.getMessage()));
        serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        serviceResponse.setErrorDTOList(errorDTOList);
        return serviceResponse;
    }
}


