package testsUserManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementServicesRemote;
import entities.TeamLeader;
import entities.Tech;
import entities.User;

public class TestAddUser {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/mini-crm/UserManagementServices!services.interfaces.UserManagementServicesRemote";
		UserManagementServicesRemote proxy = (UserManagementServicesRemote) context
				.lookup(jndiName);

		User user = new User();
		user.setName("Karim");
		user.setLogin("Karim");
		user.setPassword("123456");
		user.setType(3);

		TeamLeader teamleader = new TeamLeader();
		teamleader.setLogin("teamleader");
		teamleader.setName("Krayem");
		teamleader.setPassword("55700006");
		teamleader.setType(1);
		
		Tech tech = new Tech();
		tech.setLogin("tech");
		tech.setName("Aymen");
		tech.setPassword("21744181");
		tech.setType(2);

		System.out.println(proxy.AddUser(user));
		System.out.println(proxy.AddUser(teamleader));
		System.out.println(proxy.AddUser(tech));
	}
}
