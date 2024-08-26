package com.example.demo.services;

import com.example.demo.request.AddressListRequest;

import java.util.List;

public interface FileReaderService {
  List<String> getAddressListByIdsAndDate(AddressListRequest request);
  List<String> getAllAddressByHierarchy(String typeName);

}
