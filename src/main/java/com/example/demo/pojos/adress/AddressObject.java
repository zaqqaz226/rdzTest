package com.example.demo.pojos.adress;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@XmlRootElement(name = "OBJECT")
public class AddressObject {
  @XmlAttribute(name = "ID")
  private String id;

  @XmlAttribute(name = "OBJECTID")
  private String objectId;

  @XmlAttribute(name = "OBJECTGUID")
  private String objectGuid;

  @XmlAttribute(name = "CHANGEID")
  private String changeIdAddr;

  @XmlAttribute(name = "NAME")
  private String name;

  @XmlAttribute(name = "TYPENAME")
  private String typeName;

  @XmlAttribute(name = "LEVEL")
  private int level;

  @XmlAttribute(name = "OPERTYPEID")
  private int operTypeId;

  @XmlAttribute(name = "PREVID")
  private int prevId;

  @XmlAttribute(name = "NEXTID")
  private int nextId;

  @XmlAttribute(name = "UPDATEDATE")
  private String updateDate;

  @XmlAttribute(name = "STARTDATE")
  private String startDate;

  @XmlAttribute(name = "ENDDATE")
  private String endDateAdr;

  @XmlAttribute(name = "ISACTUAL")
  private boolean isActual;

  @XmlAttribute(name = "ISACTIVE")
  private boolean isActive;

  public LocalDate getStartLocalDate() {
    return LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public LocalDate getEndLocalDateAdr() {
    return LocalDate.parse(endDateAdr, DateTimeFormatter.ISO_LOCAL_DATE);
  }
}
