package testsUserManagementServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserManagementServicesRemote;
import entities.Team;
import entities.TeamLeader;
import entities.Tech;
import entities.User;

public class TestAddUser {
	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		String jndiName = "/mini-crm/UserManagementServices!services.interfaces.UserManagementServicesRemote";
		UserManagementServicesRemote proxy = (UserManagementServicesRemote) context
				.lookup(jndiName);
		
		TeamLeader teamleader = new TeamLeader();
		teamleader.setLogin("teamleader");
		teamleader.setName("Krayem");
		teamleader.setPassword("55700006");
		
		TeamLeader teamleader1 = new TeamLeader();
		teamleader1.setLogin("teamleader1");
		teamleader1.setName("Sana");
		teamleader1.setPassword("55700006");
	
		
		Tech tech = new Tech();
		tech.setLogin("tech");
		tech.setName("Aymen");
		tech.setPassword("21744181");
		
		Tech tech2 = new Tech();
		tech2.setLogin("tech1");
		tech2.setName("Hamadi");
		tech2.setPassword("21744181");
		
		Tech tech3 = new Tech();
		tech3.setLogin("tech2");
		tech3.setName("Marwa");
		tech3.setPassword("21744181");
		
		
		Team team = new Team();
		team.setName("Team1");
		
		Team team2 = new Team();
		team2.setName("Team2");
		

		
		System.out.println(proxy.AddUser(teamleader));
		System.out.println(proxy.AddUser(teamleader1));
		System.out.println(proxy.AddUser(tech));
		System.out.println(proxy.AddUser(tech2));
		System.out.println(proxy.AddUser(tech3));
		
		System.out.println(proxy.AddTeam(team));
		System.out.println(proxy.AddTeam(team2));
	}
}
