package com.example.servingwebcontent.entity;


import java.util.List;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.idm.authorization.Permission;

/**
 * <p>This is a simple facade to obtain information from authenticated users. You should see usages of instances of this class when
 * rendering the home page (@code home.ftl).
 *
 * <p>Instances of this class are are added to models as attributes in order to make them available to templates.
 *
 * @author <a href="mailto:psilva@redhat.com">Pedro Igor</a>
 * @see org.keycloak.quickstart.springboot.web.ApplicationController
 */
public class User {

    private final KeycloakSecurityContext securityContext;

    public User(KeycloakSecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    /**
     * An example on how you can use the {@link AuthorizationContext} to check for permissions granted by Keycloak for a particular user.
     *
     * @param name the name of the resource
     * @return true if user has was granted with a permission for the given resource. Otherwise, false.
     */
    public boolean hasResourcePermission(String name) {
        return getAuthorizationContext().hasResourcePermission(name);
    }

    /**
     * An example on how you can use {@link KeycloakSecurityContext} to obtain information about user's identity.
     *
     * @return the user name
     */
    public String getName() {
        return securityContext.getIdToken().getPreferredUsername();
    }

    /**
     * An example on how you can use the {@link AuthorizationContext} to obtain all permissions granted for a particular user.
     *
     * @return
     */
    public List<Permission> getPermissions() {
        return getAuthorizationContext().getPermissions();
    }

    /**
     * Returns a {@link AuthorizationContext} instance holding all permissions granted for an user. The instance is build based on
     * the permissions returned by Keycloak. For this particular application, we use the Entitlement API to obtain permissions for every single
     * resource on the server.
     *
     * @return
     */
    private AuthorizationContext getAuthorizationContext() {
        return securityContext.getAuthorizationContext();
    }
}