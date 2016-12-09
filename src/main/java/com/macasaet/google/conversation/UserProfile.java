package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

public class UserProfile {

    @XmlAttribute(name="given_name")
    private String givenName;
    @XmlAttribute(name="family_name")
    private String familyName;
    @XmlAttribute(name="display_name")
    private String displayName;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}