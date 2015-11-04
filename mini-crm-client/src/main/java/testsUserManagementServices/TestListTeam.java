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
		
		System.out.println("---------------");
		List<Team> Teams = proxy.findAllTeams();
		for (Team t : Teams) {
		System.out.println(t.getName());
		
		}
		System.out.println("---------------");
		List<User> user =proxy.findTechInTeamByTeamid(1);
		for (User u : user) {
			System.out.println(u.getName());
		
		}
		System.out.println("---------------");
		
		List<User> user1 =proxy.findTechInTeamByTeamid(2);
		for (User u : user1) {
			System.out.println(u.getName());
		
		}
		System.out.println("---------------");
		Team team = proxy.FindTechTeamByTechId(3);
			System.out.println(team.getName());
			System.out.println("////////////");	
	}

	}
