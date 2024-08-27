package com.example.demo.rest;

import com.example.demo.exceptions.AddressObjectException;
import com.example.demo.exceptions.HierarchyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(AddressObjectException.class)
  public ResponseEntity<String> addressExceptionHandler(Throwable throwable) {
    log.error(throwable.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
  }

  @ExceptionHandler(HierarchyException.class)
  public ResponseEntity<String> hierarchyExceptionHandler(Throwable throwable) {
    log.error(throwable.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
  }

}
