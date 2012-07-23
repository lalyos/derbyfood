package com.acme.lunch.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.acme.lunch.domain.Address;
import com.acme.lunch.domain.Employee;
import com.acme.lunch.domain.Department;
import com.acme.lunch.domain.Food;
import com.acme.lunch.domain.Restaurant;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			//test.createEmployees();
		    //test.createFoods();
		    //test.createRestaurant();
		    
            Address addr1 = new Address("Address-1", "Budapest", "Hungary", "1082");
            Restaurant rest1 = new Restaurant();
            rest1.setName("REST-1");
            rest1.setAddress(addr1);

            manager.persist(rest1);
            manager.persist(addr1);


		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		//test.listEmployees();
		//test.listFoods();
		test.listRestaurants();

		System.out.println(".. done");
	}




	private void listRestaurants() {
        List<Restaurant> resultList = manager.createQuery("Select a From Restaurant a", Restaurant.class).getResultList();
        System.out.println("num of Restaurant:" + resultList.size());
        for (Restaurant next : resultList) {
            System.out.println("next Restaurant: " + next);
        }
        
    }
    private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("java");
			manager.persist(department);

			manager.persist(new Employee("Jakab Gipsz",department));
			manager.persist(new Employee("Captain Nemo",department));

		}
	}

	   private void createFoods() {
	        int numOfFoods = manager.createQuery("Select a From Food a", Employee.class).getResultList().size();
	        if (numOfFoods == 0) {
                manager.persist(new Food("pacal", 450, 700));
                manager.persist(new Food("palacsinta", 250, 200));
                manager.persist(new Food("marhanyelv", 600, 1200));

	        }
	    }

	   private void createRestaurant() {
        int numOfEntities = manager.createQuery("Select a From Restaurant a", Restaurant.class).getResultList().size();
        if (numOfEntities == 0) {

            Address addr = new Address("Futo utca 55", "Budapest", "Hungary", "1082");
            manager.persist(addr);
            Restaurant resti = new Restaurant("Torok", addr);
            manager.persist(resti);
        }
	   }

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}


	   private void listFoods() {
	        List<Food> resultList = manager.createQuery("Select a From Food a", Food.class).getResultList();
	        System.out.println("num of foods:" + resultList.size());
	        for (Food next : resultList) {
	            System.out.println("next food: " + next);
	        }
	    }

}
