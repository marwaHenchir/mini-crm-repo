package services.impl;

import javax.ejb.Stateless;
import services.interfaces.UserManagementServicesLocal;
import services.interfaces.UserManagementServicesRemote;

/**
 * Session Bean implementation class UserManagementServices
 */
@Stateless
public class UserManagementServices implements UserManagementServicesRemote, UserManagementServicesLocal {

    /**
     * Default constructor. 
     */
    public UserManagementServices() {
        // TODO Auto-generated constructor stub
    }

}
