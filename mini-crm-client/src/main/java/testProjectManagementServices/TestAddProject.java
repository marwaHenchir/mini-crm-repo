package testProjectManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Client;
import entities.Project;
import services.interfaces.ProjectManagementServicesRemote;

public class TestAddProject {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();
		String jndiName = "/mini-crm/ProjectManagementServices!services.interfaces.ProjectManagementServicesRemote";
		ProjectManagementServicesRemote proxy = (ProjectManagementServicesRemote) context
				.lookup(jndiName);
		
		Project project = new Project();
		project.setName("projetX1");
		Client client = new Client();
		client.setId(1);
		client.setName("companyX");
		project.setClient(client);
		
		Client client1 = new Client();
		client1.setId(2);
		client1.setName("companyY");
		Project project1 = new Project();
		project1.setName("projetY1");
		project1.setClient(client1);
		
		System.out.println(proxy.addProject(project));
		System.out.println(proxy.addProject(project1));
		
	}

}
