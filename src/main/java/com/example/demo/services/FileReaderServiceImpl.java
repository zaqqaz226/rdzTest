package com.example.demo.services;

import com.example.demo.config.FilesPathConfig;
import com.example.demo.pojos.adress.AddressObject;
import com.example.demo.pojos.adress.AddressObjectsCollection;
import com.example.demo.pojos.hierarchy.HierarchyObject;
import com.example.demo.pojos.hierarchy.HierarchyObjectsCollection;
import com.example.demo.request.AddressListRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableConfigurationProperties(FilesPathConfig.class)
@RequiredArgsConstructor
@Slf4j
public class FileReaderServiceImpl implements FileReaderService {

  private final FilesPathConfig config;

  public List<String> getAddressListByIdsAndDate(AddressListRequest request) {
    log.info("Получили запрос {}", request);
    List<AddressObject> addressObjectList = readDataFromFiles();

    return addressObjectList.stream()
                            .filter(address -> request.getAddressIds().contains(address.getId())
                                               && request.getLocalDateRequest()
                                                         .isAfter(address.getStartLocalDate())
                                               && request.getLocalDateRequest()
                                                         .isBefore(address.getEndLocalDateAdr()))
                            .map(addressObject -> addressObject.getId() + ": "
                                                  + addressObject.getTypeName() + " "
                                                  + addressObject.getName())
                            .collect(Collectors.toList());
  }

  public List<String> getAllAddressByHierarchy(String typeName) {
    log.info("Ищем по типу адреса {}", typeName);
    List<AddressObject> addressObjectList = readDataFromFiles();
    List<String> listStrings = new ArrayList<>();

    var filteredAddresses = addressObjectList.stream()
                                             .filter(ad -> ad.getTypeName().equals(typeName))
                                             .collect(Collectors.toList());

    for (AddressObject addressObject : filteredAddresses) {
      StringBuilder fullAddress = new StringBuilder(addressObject.getTypeName() + " " + addressObject.getName());

      var parentId = getParentId(addressObject.getObjectId());

      while (!parentId.equals("0")) {
        String par = parentId;
        var address = addressObjectList.stream()
                                       .filter(ad -> ad.getObjectId().equals(par))
                                       .findFirst()
                                       .get();

        fullAddress.insert(0, address.getName() + ", ");
        parentId = getParentId(address.getObjectId());
      }

      fullAddress.insert(0, "AO ");
      listStrings.add(fullAddress.toString());
    }

    return listStrings;
  }

  private String getParentId(String id) {
    List<HierarchyObject> hierarchyObjectList = getHierarchyData();
    var entity = hierarchyObjectList.stream()
                                    .filter(h -> h.getObjectId().equals(id))
                                    .findFirst()
                                    .get();

    return entity.getParentObjectId();

  }

  private List<AddressObject> readDataFromFiles() {
    List<AddressObject> addressObjectsList = new ArrayList<>();
    try {
      File addressFile = new File(config.pathToAddrObj());
      JAXBContext jaxbContextAddress = JAXBContext.newInstance(AddressObjectsCollection.class);
      Unmarshaller jaxbUnmarshaller = jaxbContextAddress.createUnmarshaller();
      AddressObjectsCollection addressObjects
          = (AddressObjectsCollection) jaxbUnmarshaller.unmarshal(addressFile);
      addressObjectsList = addressObjects.getObjects();
    } catch (JAXBException e) {
      e.printStackTrace();
    }

    return addressObjectsList;
  }

  private List<HierarchyObject> getHierarchyData() {
    List<HierarchyObject> hierarchyObjectsList = new ArrayList<>();

    try {
      File hierarchyFile = new File(config.pathToHierarchy());
      JAXBContext jaxbContextHierarchy = JAXBContext.newInstance(HierarchyObjectsCollection.class);
      Unmarshaller jaxbUnmarshallerHierarchy = jaxbContextHierarchy.createUnmarshaller();
      HierarchyObjectsCollection hierarchyObjectsCollection
          = (HierarchyObjectsCollection) jaxbUnmarshallerHierarchy.unmarshal(hierarchyFile);
      hierarchyObjectsList = hierarchyObjectsCollection.getHierarchyObjects();
    } catch (JAXBException e) {
      e.printStackTrace();
    }

    return hierarchyObjectsList;
  }
}
