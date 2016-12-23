package com.macasaet.google.conversation;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Specification of the profile or device permissions that are needed to fulfill an intent.
 *
 * <p>Copyright &copy; 2016 Carlos Macasaet.</p>
 *
 * @author Carlos Macasaet
 */
public class PermissionValueSpec {

    @XmlAttribute(name="opt_context")
    private String optContext;
    private List<String> permissions = new LinkedList<>();

    /**
     * This provides TTS explaining why the agent needs to request permission.
     *
     * @return explanation of why permission is needed
     */
    public String getOptContext() {
        return optContext;
    }

    /**
     * This provides TTS explaining why the agent needs to request permission.
     *
     * @param optContext explanation of why permission is needed
     */
    public void setOptContext(String optContext) {
        this.optContext = optContext;
    }

    /**
     * The permissions that are needed to fulfill the intent. e.g. "NAME",
     * "DEVICE_PRECISE_LOCATION", "DEVICE_COARSE_LOCATION"
     *
     * @return permissions needed to fulfill the intent
     */
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     *            permissions needed to fulfill the intent (e.g. "NAME",
     *            "DEVICE_PRECISE_LOCATION", "DEVICE_COARSE_LOCATION")
     */
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

}