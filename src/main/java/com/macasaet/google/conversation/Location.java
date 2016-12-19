package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href="https://developers.google.com/actions/reference/conversation#Location">https://developers.google.com/actions/reference/conversation#Location</a>
 * @author Carlos Macasaet
 */
public class Location {

    private Coordinates coordinates;
    @XmlAttribute(name="formatted_address")
    private String formattedAddress;
    private String city;
    @XmlAttribute(name="zip_code")
    private String zipCode;

    /**
     * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
     *
     * @see <a href="https://developers.google.com/actions/reference/conversation#Location">https://developers.google.com/actions/reference/conversation#Location</a>
     * @author Carlos Macasaet
     */
    public static class Coordinates {

        private double latitude;
        private double longitude;

        /**
         * The device's latitude, in degrees. It must be in the range [-90.0,
         * +90.0]. Requires permission DEVICE_PRECISE_LOCATION.
         *
         * @return the device's latitude, in degrees
         */
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        /**
         * The device's longitude, in degrees. It must be in the range [-180.0,
         * +180.0]. Requires permission DEVICE_PRECISE_LOCATION.
         * 
         * @return the device's longitude, in degrees.
         */
        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

    }

    /**
     * Requires permission DEVICE_PRECISE_LOCATION.
     * 
     * @return the device's precise coordinates.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * The device's display address; for example
     * "1600 Amphitheatre Pkwy, Mountain View, CA 94043". Requires permission
     * DEVICE_PRECISE_LOCATION.
     *
     * @return the device's display address
     */
    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    /**
     * The city in which the device is located. Requires permission
     * DEVICE_PRECISE_LOCATION or DEVICE_COARSE_LOCATION.
     * 
     * @return the city in which the device is located
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The ZIP code in which the device is located. Requires permission
     * DEVICE_PRECISE_LOCATION or DEVICE_COARSE_LOCATION.
     * 
     * @return the ZIP code in which the device is located.
     */
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}