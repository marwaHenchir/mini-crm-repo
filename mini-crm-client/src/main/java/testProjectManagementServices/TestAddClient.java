package testProjectManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.ProjectManagementServicesRemote;

import entities.Client;


public class TestAddClient {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/ProjectManagementServices!services.interfaces.ProjectManagementServicesRemote";
		ProjectManagementServicesRemote proxy = (ProjectManagementServicesRemote) context
				.lookup(jndiName);
		
		Client client = new Client();
		client.setName("companyX");
		Client client1 = new Client();
		client1.setName("companyY");
		
		
		System.out.println(proxy.addClient(client));
		System.out.println(proxy.addClient(client1));
		

	}

}
