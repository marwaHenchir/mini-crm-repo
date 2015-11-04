package testProjectManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Task;

import entities.User;
import services.interfaces.ProjectManagementServicesRemote;

public class TestAffectTechToTask {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/ProjectManagementServices!services.interfaces.ProjectManagementServicesRemote";
		ProjectManagementServicesRemote proxy = (ProjectManagementServicesRemote) context
				.lookup(jndiName);
		
	
		
		
		System.out.println(proxy.affectTaskToTechicianById(1, 2));

	}

}
