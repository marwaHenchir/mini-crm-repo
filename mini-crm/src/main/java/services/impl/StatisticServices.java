package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Project;
import entities.Task;
import entities.Team;
import entities.Tech;
import entities.User;
import services.interfaces.StatisticServicesLocal;
import services.interfaces.StatisticServicesRemote;

/**
 * Session Bean implementation class StatisticServices
 */
@Stateless
@LocalBean
public class StatisticServices implements StatisticServicesRemote, StatisticServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	
    public StatisticServices() {
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
	@Override
	public ArrayList<List<Task>> getCompleteIncompleteTasks(Integer id) {
		ArrayList<List<Task>> result = new ArrayList<List<Task>>();
		String jpql = "select t from Task t where t.project.id=:projectId and t.done:= true";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("projectId", id);
		result.add(query.getResultList());
		
		String jpql2 = "select t from Task t where t.project.id=:projectId and t.done:= false";
		Query query2 = entityManager.createQuery(jpql2);
		query2.setParameter("projectId", id);
		result.add(query2.getResultList());
		return result;
	}

    @SuppressWarnings("unchecked")
	@Override
	public ArrayList<List<Task>> getTaskEffort(Integer id) {
    	ArrayList<List<Task>> result = new ArrayList<List<Task>>();
		String jpql = "select t from Task t where t.project.id=:projectId and t.done= false";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("projectId", id);
		result.add(query.getResultList());
		
		String jpql2 = "select t from Task t where t.project.id=:projectId and t.done= true";
		Query query2 = entityManager.createQuery(jpql2);
		query2.setParameter("projectId", id);
		result.add(query2.getResultList());
		return result;
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<User> getTasksByUser() {
		return entityManager.createQuery("select u from User u")
				.getResultList();
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectStatus() {
		return entityManager.createQuery("select p from Project p")
				.getResultList();
	}

}
