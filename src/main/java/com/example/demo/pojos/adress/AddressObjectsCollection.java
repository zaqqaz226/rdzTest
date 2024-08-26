package com.example.demo.pojos.adress;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "ADDRESSOBJECTS")
public class AddressObjectsCollection {
    private List<AddressObject> objects;

    @XmlElement(name = "OBJECT")
    public List<AddressObject> getObjects() {
      return objects;
    }

    public void setObjects(List<AddressObject> objects) {
      this.objects = objects;
    }

}
