package com.macasaet.google.conversation;

/**
 * The device object contains information about the device through which the conversation is taking place.
 * 
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#Device">
 *      https://developers.google.com/actions/reference/conversation#Device</a>
 * @author Carlos Macasaet
 */
public class Device {

    private Location location;

    /**
     * @return representation of the device location
     */
    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

}