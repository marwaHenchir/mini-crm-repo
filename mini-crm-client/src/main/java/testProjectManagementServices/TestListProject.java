package testProjectManagementServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import entities.Project;
import services.interfaces.ProjectManagementServicesRemote;

public class TestListProject {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/ProjectManagementServices!services.interfaces.ProjectManagementServicesRemote";
		ProjectManagementServicesRemote proxy = (ProjectManagementServicesRemote) context
				.lookup(jndiName);
		
		List<Project> projects = proxy.findAllProject();
		for (Project p : projects) {
			System.out.println(p.getName());
			
		}
	}

}
