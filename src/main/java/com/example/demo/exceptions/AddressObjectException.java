package com.example.demo.exceptions;

import lombok.Getter;

@Getter
public class AddressObjectException extends RuntimeException{
  private final String message;

  public AddressObjectException(String message) {
    super(message);
    this.message = message;
  }
}
