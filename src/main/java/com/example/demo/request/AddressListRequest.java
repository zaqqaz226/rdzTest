package com.example.demo.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class AddressListRequest {
  private List<String> addressIds;
  private String date;

  public LocalDate getLocalDateRequest() {
    return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
  }
}
