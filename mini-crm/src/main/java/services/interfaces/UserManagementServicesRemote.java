package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Team;
import entities.User;

@Remote
public interface UserManagementServicesRemote {

	Boolean AddUser(User user);
	Boolean UpdateUser(User user);
	Boolean DeleteUser(User user);
	User FindUserById(Integer id);
	User login(String login, String password);
	
	Boolean SetTeamLeaderById(Integer userid, Integer teamid);
	Boolean AffectUserToTeam (Integer userid, Integer teamid);
	
	List<User> findTechInTeamByTeamid(Integer teamid);
	Team FindTechTeamByTechId(Integer techid);
	
	Boolean AddTeam(Team team);
	List<Team> findAllTeams();
}
