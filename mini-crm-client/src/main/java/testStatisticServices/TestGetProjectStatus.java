package testStatisticServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StatisticServicesRemote;
import entities.Project;
import entities.Task;
import entities.User;

public class TestGetProjectStatus {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/StatisticServices!services.interfaces.StatisticServicesRemote";
		StatisticServicesRemote proxy = (StatisticServicesRemote) context
				.lookup(jndiName);

		List<Project> projects = proxy.getProjectStatus();
		
		System.out.println("Les status des project");
		for (Project project : projects) {
			System.out.print(project.getName());
			Boolean verif = true;
			for (Task task : project.getTasks()) {
				if (! task.getDone()) {
					verif = false;
				}
			}
			if (verif) {
				System.out.println("Complete");
			} else {
				System.out.println("Progress");
			}
			
		}
	}

}
