package testsUserManagementServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.interfaces.UserManagementServicesRemote;
import entities.Team;

public class TestListTeam {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/UserManagementServices!services.interfaces.UserManagementServicesRemote";
		UserManagementServicesRemote proxy = (UserManagementServicesRemote) context
				.lookup(jndiName);
		
		List<Team> Teams = proxy.findAllTeams();
		for (Team t : Teams) {
			System.out.println(t.getId());
		}
		
		

	}

}
