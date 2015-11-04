package testStatisticServices;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Task;
import services.interfaces.StatisticServicesRemote;


public class TestGetCompleteIncompleteTasks {

	public static void main(String[] args) throws NamingException {
		
		Context context = new InitialContext();
		String jndiName = "/mini-crm/StatisticServices!services.interfaces.StatisticServicesRemote";
		StatisticServicesRemote proxy = (StatisticServicesRemote) context
				.lookup(jndiName);

		ArrayList<List<Task>> list = proxy.getCompleteIncompleteTasks(0);
		
		List<Task> l = list.get(0);
		System.out.println("Complete Tasks ("+ l.size() + ")");
		for (Task t : l) {
			System.out.println(t.getName());
		}
		
		List<Task> l1 = list.get(1);
		System.out.println("Incomplete Tasks ("+ l.size()+ ")");
		for (Task t : l1) {
			System.out.println(t.getName());
		}

	}

}
