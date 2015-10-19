package services.impl;

import javax.ejb.Stateless;
import services.interfaces.ProjectManagementServicesLocal;
import services.interfaces.ProjectManagementServicesRemote;

/**
 * Session Bean implementation class ProjectManagementServices
 */
@Stateless
public class ProjectManagementServices implements ProjectManagementServicesRemote, ProjectManagementServicesLocal {

    /**
     * Default constructor. 
     */
    public ProjectManagementServices() {
        // TODO Auto-generated constructor stub
    }

}
