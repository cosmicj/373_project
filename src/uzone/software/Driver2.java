package uzone.software;


import java.util.ArrayList;

import uzone.people.*;
import uzone.software.*;

public class Driver2 
{
	// Created by Justin Loera, Grayson Fleming, and Tommy Salanski
	
	public static void main(String[] args) 
	{
		
		UZoneGUI newGUI;
		UZone zone = new UZone();
		ArrayList<Student> studentList = new ArrayList<>();

		// Create People	//
	    
		// Set Admins
		Admin a1 = new Admin();
		Admin a2 = new Admin();
		Admin a3 = new Admin();
		
		// Set Students
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();

		
		// Initialize	//
		a1.setName("Justin");
		a1.setEmail("justin@gmail.com");
		a1.setNetID("justinloera");
		a1.setPassword("21savage");
		a1.setSQ("25");
		
		a2.setName("Grayson");
		a2.setEmail("grayson@gmail.com");
		a2.setNetID("grf7");
		a2.setPassword("trackstar");
		a2.setSQ("50");
		
		a3.setName("Tommy");
		a3.setEmail("tommy@gmail.com");
		a3.setNetID("tsalanski");
		a3.setPassword("imasenior");
		a3.setSQ("75");
		
		s1.setName("John");
		s1.setEmail("john@gmail.com");
		s1.setNetID("johnny123");
		s1.setPassword("appleseed");
		s1.setSQ("1");
		
		s2.setName("Bob");
		s2.setEmail("bob@gmail.com");
		s2.setNetID("bobby123");
		s2.setPassword("orangejuice");
		s2.setSQ("2");
		
		s3.setName("Jim");
		s3.setEmail("jim@gmail.com");
		s3.setNetID("jimmy123");
		s3.setPassword("slimjim");
		s3.setSQ("3");
		
        
        

    
		
		// Add all existing students
        //studentList.add(s1);
        
        zone.getAdmins().add(a1);
        zone.getAdmins().add(a2);
        zone.getAdmins().add(a3);
		
        zone.getStudents().add(s1);
        zone.getStudents().add(s2);
        zone.getStudents().add(s3);
      

		// Generate GUI
        
        newGUI = new UZoneGUI("UZone");//, zone);
         
         
	}

	

}
