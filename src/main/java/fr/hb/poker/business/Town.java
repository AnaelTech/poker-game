package fr.hb.poker.business;


public class Town {

private Long id;
private String name;
private String zipCode;
private String codeInsee;
private Double latitude;
private Double longitude;
private static Long counter = 0L; // Variable de classe, le static


public Town(String name, String zipCode, String codeInsee, Double latitude, Double longitude) {
    id = ++counter;
    this.name = name;
    this.zipCode = zipCode;
    this.codeInsee = codeInsee;
    this.latitude = latitude;
    this.longitude = longitude;
  }

public Long getId(){
    return id;
  }

public void setId(Long id){
    this.id = id;
  }

public String getName(){
    return name;
  }

public void setName(String name){
    this.name = name;
  }

public String getZipCode(){
    return zipCode;
  }

public void setZipCode(String zipcode){
    this.zipCode = zipcode;
  }


public String getCodeInsee(){
    return codeInsee;
  }

public void setCodeInsee(String codeInsee){
    this.codeInsee = codeInsee;
  }

public Double getLatitude(){
    return latitude;
  }

public void setLatitude(Double latitude){
    this.latitude = latitude;
  }

  public Double getLongitude(){
    return longitude;
  }

  public void setLongitude(Double longitude){
    this.longitude = longitude;
  }


}
