package services.impl;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Client;
import entities.Project;
import entities.Task;
import entities.Tech;
import services.interfaces.ProjectManagementServicesLocal;
import services.interfaces.ProjectManagementServicesRemote;


@Stateless
public class ProjectManagementServices implements ProjectManagementServicesRemote, ProjectManagementServicesLocal {

   
	@PersistenceContext
	private EntityManager entityManager;
    public ProjectManagementServices() {
        
    }
   
    @Override
    public Boolean addClient (Client client){
    	Boolean b = false;
    	try {
			entityManager.persist(client);
			b=true;
		} catch (Exception e) {
			System.err.println("problem adding Client");
		}
		return b;
    }
    @Override
    public Boolean addProject (Project project){
    	Boolean b = false;
		try {
			entityManager.persist(project);
			b=true;
		} catch (Exception e) {
			System.err.println("problem adding Project");
		}
		return b;
    }
    
    @Override
    public Boolean addTaskToProjectById (Task task , int id){
    	Boolean b = false;
		try {
			Project project = entityManager.find(Project.class, id);
			task.setProject(project);
			entityManager.merge(task);
			b=true;
		} catch (Exception e) {
			System.err.println("problem adding Task to Project");
		}
		return b;
    }
   
    @Override
       public Boolean affectTaskToTechicianById (int idtask , int iduser){
    	Boolean b = false;
		try {
			Task task = entityManager.find(Task.class, idtask);
			Tech user = entityManager.find(Tech.class, iduser);
			task.setUser(user);
			entityManager.merge(task);
			b=true;
		} catch (Exception e) {
			System.err.println("problem adding Task to Project");
		}
		return b;
		
    }
    
    @Override
    public Boolean setTaskDoneById (int idtask){
 	Boolean b = false;
		try {
			Task task = entityManager.find(Task.class, idtask);
			
			task.setDone(true);
			entityManager.merge(task);
			b=true;
		} catch (Exception e) {
			System.err.println("problem setting Task done");
		}
		return b;
		
 }
    @SuppressWarnings("unchecked")
	@Override
    public List<Project> findAllProject() {
		String jpql = "select p from Project p";
		Query query = entityManager.createQuery(jpql);
		
		return query.getResultList();
	}
    
    @SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectByClientId(Integer id) {
		String jpql = "select p from Project p  where p.client.id=:idClient";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("idClient", id);
		return query.getResultList();
	}

    	
    	

}
