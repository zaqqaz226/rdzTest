package com.example.demo.pojos.hierarchy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ITEMS")
public class HierarchyObjectsCollection {
    private List<HierarchyObject> objects;

    @XmlElement(name = "ITEM")
    public List<HierarchyObject> getHierarchyObjects() {
      return objects;
    }

    public void setHierarchyObjects(List<HierarchyObject> objects) {
      this.objects = objects;
    }

}
