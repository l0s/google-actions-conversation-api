package com.macasaet.google.conversation;

import javax.xml.bind.annotation.XmlElement;

/**
 * Specification describing the nature of the input needed from the user.
 * Specified in order to request the user's permission to access profile and
 * device information.
 *
 * <p>Copyright &copy; 2017 Carlos Macasaet.</p>
 *
 * @author Carlos Macasaet
 */
public class InputValueSpec {

    @XmlElement(name="permission_value_spec")
    private PermissionValueSpec permissionValueSpec;

    public InputValueSpec() {
    }

    public InputValueSpec(final PermissionValueSpec permissionValueSpec) {
        setPermissionValueSpec(permissionValueSpec);
    }

    public InputValueSpec(final String optContext, final String... permissions) {
        this(new PermissionValueSpec(optContext, permissions));
    }

    public PermissionValueSpec getPermissionValueSpec() {
        return permissionValueSpec;
    }

    public void setPermissionValueSpec(PermissionValueSpec permissionValueSpec) {
        this.permissionValueSpec = permissionValueSpec;
    }

}