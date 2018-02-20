package com.ecogle.MyDatabaseProject;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App{

	private static final String P_U = "mydbproject";


	
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(P_U);
    	EntityManager em = emf.createEntityManager();
    	Tools wrench = new Tools();
    	wrench.setToolName("Wrench");
    	Tools hammer = new Tools();
    	hammer.setToolName("Hammer");
    	Tools driver = new Tools();
    	driver.setToolName("Driver");
    	
    	List<Tools> toolBox = new ArrayList<>();
    	toolBox.add(wrench);
    	toolBox.add(hammer);
    	toolBox.add(driver);
    	
    	
 
    	em.getTransaction().begin();
    	Person person = new Person.Builder().emailAddress("eco@gmail.com").firstName("Erik").lastName("Ogle").mInit("C").build();
    	person.setTools(toolBox);
    	em.persist(person);
    	em.getTransaction().commit();
    	
    	TypedQuery<Person>people = em.createQuery("select o from Person o", Person.class);
    	people.getResultList().forEach(System.out::println);
        em.close();
        //showMenu();
        
    }
    
    public static void showMenu(){
    	print("1.  Add Tools");
    	print("2.  Add People");
    	print("3. (Q)uit");
    	
    	Scanner in = new Scanner(System.in);
    	
    	
    }
    
    public static void print(String s){
    	System.out.println(s);
    }
}
