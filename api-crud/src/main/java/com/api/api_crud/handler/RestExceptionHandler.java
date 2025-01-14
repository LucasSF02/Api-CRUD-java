package com.api.api_crud.handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.api.api_crud.helper.ConversorData;
import com.api.api_crud.model.ErrorResponse;
import com.api.api_crud.model.exception.ResourceBadRequestException;
import com.api.api_crud.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {

        var dataHora = ConversorData.converterDataParaDataEHora(new Date());
        var resposta = new ErrorResponse(dataHora, 404, "Not Found", ex.getMessage());
        return new ResponseEntity<>(resposta, HttpStatus.NOT_FOUND);

    }

        @ExceptionHandler(ResourceBadRequestException.class)
        public ResponseEntity<ErrorResponse> handlerResourceBadRequestException(ResourceBadRequestException ex) {

            var dataHora = ConversorData.converterDataParaDataEHora(new Date());
            var resposta = new ErrorResponse(dataHora, 400, "Bad Request", ex.getMessage());
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);

        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handlerException(Exception ex) {

            var dataHora = ConversorData.converterDataParaDataEHora(new Date());
            var resposta = new ErrorResponse(dataHora, 500, "Internal Server Error", ex.getMessage());
            return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
