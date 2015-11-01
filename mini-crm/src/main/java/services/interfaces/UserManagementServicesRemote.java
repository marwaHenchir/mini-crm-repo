package services.interfaces;

import javax.ejb.Remote;

import entities.User;
import entities.Tech;

@Remote
public interface UserManagementServicesRemote {

	Boolean AddUser(User user);
	Boolean UpdateUser(User user);
	Boolean DeleteUser(User user);
	User FindUserById(Integer id);
	User login(String login, String password);
	Boolean AddUserTeamById (Integer userId, Integer userTypeh,Integer teamid);
	Boolean SetTeamLeaderById(Integer userid, Integer teamid);
}
