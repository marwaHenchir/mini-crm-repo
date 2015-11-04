package testProjectManagementServices;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.ProjectManagementServicesRemote;
import entities.Client;
import entities.Project;
import entities.Task;

public class TestAddTaskToProject {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/ProjectManagementServices!services.interfaces.ProjectManagementServicesRemote";
		ProjectManagementServicesRemote proxy = (ProjectManagementServicesRemote) context
				.lookup(jndiName);
		
		Task task1 = new Task();
		task1.setName("task 1");
		
		task1.setStart_date(new Date(15, 10, 10));
		Task task2 = new Task();
		task2.setName("task 2");
		task2.setStart_date(new Date(15, 10, 20));
		Task task3 = new Task();
		task3.setName("task 3");
		task3.setStart_date(new Date(15, 10, 28));
		
		
		
		System.out.println(proxy.addTaskToProjectById(task1, 1));
		System.out.println(proxy.addTaskToProjectById(task2, 1));
		System.out.println(proxy.addTaskToProjectById(task3, 1));
	}

}
