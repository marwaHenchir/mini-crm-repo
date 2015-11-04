package services.interfaces;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Project;
import entities.Task;

@Remote
public interface ProjectManagementServicesRemote {
	Boolean addClient (Client client);
	Boolean addProject (Project project);
	Boolean addTaskToProjectById (Task task , int id);
	Boolean affectTaskToTechicianById (int idtask , int iduser);
	Boolean setTaskDoneById (int idtask);
	List<Project> findAllProject();
}
