package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlAttribute;

public class UserProfile {

    @XmlAttribute(name="given_name")
    private String givenName;
    @XmlAttribute(name="family_name")
    private String familyName;
    @XmlAttribute(name="display_name")
    private String displayName;
    
}