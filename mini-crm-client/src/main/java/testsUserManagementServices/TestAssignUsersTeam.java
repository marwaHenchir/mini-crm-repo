package testsUserManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementServicesRemote;


public class TestAssignUsersTeam {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/mini-crm/UserManagementServices!services.interfaces.UserManagementServicesRemote";
		UserManagementServicesRemote proxy = (UserManagementServicesRemote) context
				.lookup(jndiName);

		System.out.println(proxy.SetTeamLeaderById(1, 1));
		System.out.println(proxy.SetTeamLeaderById(2, 2));
		System.out.println(proxy.AffectUserToTeam(3, 1));
		System.out.println(proxy.AffectUserToTeam(4, 1));
		System.out.println(proxy.AffectUserToTeam(5, 2));
	}
}
