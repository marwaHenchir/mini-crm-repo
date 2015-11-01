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
	Boolean AddUserTeam (Integer userId, Integer userType, Tech tech,Integer teamid);
}
