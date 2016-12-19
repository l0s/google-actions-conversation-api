package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Describes the user that initiated this conversation.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#User">
 *      https://developers.google.com/actions/reference/conversation#User</a>
 * @author Carlos Macasaet
 */
public class User {

    @XmlAttribute(name="user_id")
    private String userId;
    private UserProfile profile;
    @XmlAttribute(name="access_token")
    private String accessToken;

    /**
     * A random string identifier for the Google user. It can be used to track a
     * user across multiple sessions and devices.
     * 
     * NOTE: Users can reset their user ID at any time. Do not use this field as
     * a key to store valuable information about the user, use account linking
     * instead.
     * 
     * @return A random string identifier for the Google user
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * NOTE: This object will only be available in the request after requesting and being granted user's consent to share.
     * 
     * @return Information about the user
     */
    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(final UserProfile profile) {
        this.profile = profile;
    }

    /**
     * A unique OAuth2 token that identifies the user in your system. Only
     * available if Account Linking configuration is defined in the Action
     * Package and the user links their account.
     * 
     * @return a unique OAuth2 token that identifies the user in your system
     */
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public String toString() {
        return "User [userId=" + getUserId() + ", profile=" + getProfile() + "]";
    }

}