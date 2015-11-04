package services.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import entities.Project;
import entities.Task;
import entities.User;

@Remote
public interface StatisticServicesRemote {
	ArrayList<List<Task>> getCompleteIncompleteTasks(Integer id);
	ArrayList<List<Task>> getTaskEffort (Integer id);
	List<User> getTasksByUser ();
	List<Project> getProjectStatus();
}
