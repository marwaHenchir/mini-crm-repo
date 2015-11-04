package testStatisticServices;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.StatisticServicesRemote;
import entities.Task;
import entities.User;

public class TestGetTasksByUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/mini-crm/StatisticServices!services.interfaces.StatisticServicesRemote";
		StatisticServicesRemote proxy = (StatisticServicesRemote) context
				.lookup(jndiName);

		List<User> users = proxy.getTasksByUser();
		
		System.out.println("Liste des taches par utilisateur");
		for (User user : users) {
			System.out.println(user.getName() + "(" + user.getTasks().size() +")");
			for (Task task : user.getTasks()) {
				System.out.println("    " + task.getName());
			}
		}

	}

}
