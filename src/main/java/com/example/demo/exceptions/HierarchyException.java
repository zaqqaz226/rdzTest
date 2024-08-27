package com.example.demo.exceptions;

import lombok.Getter;

@Getter
public class HierarchyException extends RuntimeException{
  private final String message;

  public HierarchyException(String message) {
    super(message);
    this.message = message;
  }
}
