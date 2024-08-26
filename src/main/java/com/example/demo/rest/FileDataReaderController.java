package com.example.demo.rest;

import com.example.demo.request.AddressListRequest;
import com.example.demo.services.FileReaderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class FileDataReaderController {

  private final FileReaderServiceImpl service;

  @PostMapping("addresses/")
  public List<String> getAddressesByIdAndDate(@RequestBody AddressListRequest request) {
    return service.getAddressListByIdsAndDate(request);
  }

  @GetMapping("addresses-hierarchy/")
  public List<String> getAllAddressByHierarchy(@RequestParam String typeName) {
    return service.getAllAddressByHierarchy(typeName);
  }

}
