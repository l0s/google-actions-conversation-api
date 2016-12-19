package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Stores user's personal info. It's accessible only after user grants the
 * permission to the agent.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @see <a href=
 *      "https://developers.google.com/actions/reference/conversation#UserProfile">
 *      https://developers.google.com/actions/reference/conversation#UserProfile
 *      </a>
 * @author Carlos Macasaet
 */
public class UserProfile {

    @XmlAttribute(name="given_name")
    private String givenName;
    @XmlAttribute(name="family_name")
    private String familyName;
    @XmlAttribute(name="display_name")
    private String displayName;

    /**
     * The user's first name as specified in their Google account. Requires permission NAME.
     *
     * @return the user's first name as specified in their Google account
     */
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * The user's last name as specified in their Google account. Note that this
     * field could be empty. Requires permission NAME.
     * 
     * @return the user's last name as specified in their Google account
     */
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * The user's full name as specified in their Google account. Requires
     * permission NAME.
     *
     * @return the user's full name as specified in their Google account.
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return "UserProfile [displayName=" + getDisplayName() + "]";
    }

}