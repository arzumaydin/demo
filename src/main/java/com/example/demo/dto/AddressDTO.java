package com.example.demo.dto;

public class AddressDTO {
    private int id;
    private String street;
    private String streetName;
    private String buildingNumber;
    private String city;
    private String zipcode;
    private String country;
    private String county_code;
    private float latitude;
    private float longitude;

    public AddressDTO() {}

    public AddressDTO(int id, String street, String streetName, String buildingNumber, String city, String zipcode,
                      String country, String county_code, float latitude, float longitude) {
        this.id = id;
        this.street = street;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.county_code = county_code;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty_code() {
        return county_code;
    }

    public void setCounty_code(String county_code) {
        this.county_code = county_code;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
