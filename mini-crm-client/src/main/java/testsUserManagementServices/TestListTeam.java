package testsUserManagementServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementServicesRemote;
import entities.Team;
import entities.User;

public class TestListTeam {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/UserManagementServices!services.interfaces.UserManagementServicesRemote";
		UserManagementServicesRemote proxy = (UserManagementServicesRemote) context
				.lookup(jndiName);
		
//		List<Team> Teams = proxy.findAllTeams();
	//	for (Team t : Teams) {
		//	System.out.println(t.getId());
		//}
		
		List<User> user =proxy.findTechInTeamByTeamid(1);
		for (User u : user) {
			System.out.println(u.getName());
		}
		Team team = proxy.FindTechTeamByTechId(2);
			System.out.println(team.getId());
		}

	}
