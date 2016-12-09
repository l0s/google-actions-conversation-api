package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

public class Location {

    private Coordinates coordinates;
    @XmlAttribute(name="formatted_address")
    private String formattedAddress;
    private String city;
    @XmlAttribute(name="zip_code")
    private String zipCode;

    public static class Coordinates {

        private double latitude;
        private double longitude;
        
        public double getLatitude() {
            return latitude;
        }
        
        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
        
        public double getLongitude() {
            return longitude;
        }
        
        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}