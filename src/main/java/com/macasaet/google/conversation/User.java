package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * 
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see https://developers.google.com/actions/reference/conversation#User
 * @author Carlos Macasaet
 */
public class User {

    @XmlAttribute(name="user_id")
    private String userId;
    private UserProfile profile;
    @XmlAttribute(name="access_token")
    private String accessToken;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(final UserProfile profile) {
        this.profile = profile;
    }

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