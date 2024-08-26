package com.example.demo.pojos.hierarchy;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@Getter
@XmlRootElement(name = "HIERARCHY")
public class HierarchyObject {
  @XmlAttribute(name = "ID")
  private String id;

  @XmlAttribute(name = "OBJECTID")
  private String objectId;

  @XmlAttribute(name = "PARENTOBJID")
  private String parentObjectId;

  @XmlAttribute(name = "CHANGEID")
  private String changeId;

  @XmlAttribute(name = "PREVID")
  private String prevId;

  @XmlAttribute(name = "NEXTID")
  private String nextId;

  @XmlAttribute(name = "UPDATEDATE")
  private int updateDate;

  @XmlAttribute(name = "STARTDATE")
  private int startDate;

  @XmlAttribute(name = "ENDDATE")
  private String endDate;

  @XmlAttribute(name = "ISACTIVE")
  private boolean isActive;

}
