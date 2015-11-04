package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Team;
import entities.TeamLeader;
import entities.Tech;
import entities.User;
import services.interfaces.UserManagementServicesLocal;
import services.interfaces.UserManagementServicesRemote;

/**
 * Session Bean implementation class UserManagementServices
 */
@Stateless
public class UserManagementServices implements UserManagementServicesRemote, UserManagementServicesLocal {
	
	@PersistenceContext
	private EntityManager entityManager;

    public UserManagementServices() {
    	

    }
    @Override
    public Boolean AddUser (User user){
    	Boolean b = false;
		try {
			entityManager.persist(user);
			b=true;
		} catch (Exception e) {
			System.err.println("problem adding User");
		}
		return b;
    }
    @Override
	public User FindUserById(Integer id){
    	return entityManager.find(User.class, id);
    }
	@Override
	public Boolean DeleteUser(User user){
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(user));
			b = true;
		} catch (Exception e) {
			System.err.println("problem DELETING user");
		}
		return b;
	}
	@Override
	public Boolean UpdateUser(User user){
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(user));
			b = true;
		} catch (Exception e) {
			System.err.println("problem UPDATING user");
		}
		return b;
	}
	@Override
	public User login(String login, String password) {
		User userLoggedIn = null;
		String jpql = "select u From User u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			userLoggedIn = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("you are not authorized");
		}
		return userLoggedIn;
	}
	
	
	
	@Override
	public Boolean AffectUserToTeam (Integer userid, Integer teamid) {
		Boolean b = false;
		try{
			User techFound = entityManager.find(User.class, userid);
			Team teamFound = entityManager.find(Team.class, teamid);
				techFound.setTeam(teamFound);
				entityManager.persist(techFound);
				
				b=true;
		}catch(Exception e){}
		
		
		return b;
	}
	
	@Override
	public Boolean SetTeamLeaderById(Integer userid, Integer teamid){
		Boolean b = false;
		try {
			TeamLeader teamLeaderFound = entityManager.find(TeamLeader.class, userid);
			Team teamFound = entityManager.find(Team.class, teamid);
			
				teamFound.setTeamLeader(teamLeaderFound);
				teamLeaderFound.setTeam(teamFound);
				entityManager.merge(teamFound);
				b=true;
			
	} catch (Exception e) {	
	}
	return b;
}
	@Override
	public Boolean SetTeamLeaderByName(String Name, Integer teamid){
		Boolean b=false;
	try {
		TeamLeader teamLeaderFound = entityManager.find(TeamLeader.class, Name);
		SetTeamLeaderById(teamLeaderFound.getId(), teamid);
		b=true;
} catch (Exception e) {	
	b=false;
}
	return b;
}
	@Override
	public List<User> findTechInTeamByTeamid (Integer teamid) {
		Team teamFound = entityManager.find(Team.class, teamid);		
		return teamFound.getUsers();
	}
	@Override
	public Integer FindTechTeamByTechId(Integer techid){
		Tech techFound = entityManager.find(Tech.class, techid);
		return techFound.getTeam().getId();
	}
	@Override
	public Boolean AddTeam(Team team) {
		Boolean b = false;
		try {
			entityManager.persist(team);
			b=true;
		} catch (Exception e) {
			System.err.println("problem adding Team");
		}
		return b;
	}
}