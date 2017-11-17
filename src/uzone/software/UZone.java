package uzone.software;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import uzone.people.*;

public class UZone implements Serializable
{

	private static final long serialVersionUID = 3101792311875765490L;
	
	private static String uZoneName;
	private static ArrayList<Student> uZoneStudents = new ArrayList<>();
	private static ArrayList<Admin> uZoneAdmins = new ArrayList<>();
	
	
	public UZone()
	{
		
	}
	
	
	public String getName()
	{
		return uZoneName;
	}
	public void setName(String name)
	{
		uZoneName = name;
	}
	
	public ArrayList<Student> getStudents()
	{
		return uZoneStudents;
	}
	public void addStudent(Student student)
	{
		uZoneStudents.add(student);
	}
	public ArrayList<Admin> getAdmins()
	{
		return uZoneAdmins;
	}
	public void addAdmin(Admin admin)
	{
		uZoneAdmins.add(admin);
	}
	
	
	
	public void printStudents()
	{
		for(Student st: uZoneStudents)
		{
			System.out.println(st.getName());
		}
	}
	public void printAdmins()
	{
		for(Admin ad: uZoneAdmins)
		{
			System.out.println(ad.getName());
		}
	}
	
	
	
	public static void printAll()
	{		
		
		// List of Admins
		System.out.println("List of Administrators:");
		for(Admin ad: uZoneAdmins)
		{
			System.out.println(ad.getName());
		}
		System.out.println();
		
		// List of Students
		System.out.println("List of Students:");
		for(Student st: uZoneStudents)
		{
			System.out.println(st.getName());
		}
		System.out.println();
		
		
		// List of Tasks by Student
		for(Student stud: uZoneStudents)
		{
			System.out.println("The Tasks for Student " + stud.getName());
			if(stud.getTasks() != null)
			{
				for(Task t: stud.getTasks())
				{
					System.out.println(t.getDateDue() + ": " + t.getTitle() + " - " + t.getInfo());
				}
			}
			System.out.println();
		}
		System.out.println();

		// List of Events by Student
		for(Student stud: uZoneStudents)
		{
			System.out.println("The Events for Student " + stud.getName());
			if(stud.getEvents() != null)
			{
				for(Event e: stud.getEvents())
				{
					System.out.println(e.getDateOf() + ": " + e.getTitle() + " - " + e.getInfo());
				}	
			}
			System.out.println();
		}
		
	}
	
	public static String printAllInfo()
	{
		StringBuilder stringAll = new StringBuilder();
		
		// List of Students
		stringAll.append("List of Students:");
		for(Student st: uZoneStudents)
		{
			stringAll.append("\n"+st.getName());
		}
		stringAll.append("\n\n");
		
		// List of Admins
		stringAll.append("List of Administrators:");
		for(Admin ad: uZoneAdmins)
		{
			stringAll.append("\n"+ad.getName());
		}
		stringAll.append("\n\n");
		
		// List of Tasks by Student
		for(Student stud: uZoneStudents)
		{
			stringAll.append("The Tasks for Student " + stud.getName());
			if(stud.getTasks() != null)
			{
				for(Task t: stud.getTasks())
				{
					stringAll.append("\n" + t.getDateDue() + ": " + t.getTitle() + " - " + t.getInfo());
				}
				stringAll.append("\n");	
			}
		}
		// List of Events by Student
		for(Student stud: uZoneStudents)
		{
			stringAll.append("The Events for Student " + stud.getName());
			if(stud.getEvents() != null)
			{
				for(Event e: stud.getEvents())
				{
					stringAll.append("\n" + e.getDateOf() + ": " + e.getTitle() + " - " + e.getInfo());
				}
				stringAll.append("\n");	
			}
		}
		
		return stringAll.toString();
	}
	
		
	
	// Static - call it only on the class, not an instance
	public static void saveData(UZone zone)
	{
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut= null;

		try 
		{
			fileOut = new FileOutputStream( "UZone.ser" );
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(zone);
			objOut.close();
			fileOut.close();
	     }	
		
		catch(IOException i)
	    {
			i.printStackTrace();
	    }		
 	}

	public static UZone loadData()
	{	
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		UZone zone = null;
			
		try
		{
			fileIn = new FileInputStream( "UZone.ser" );
			objIn = new ObjectInputStream(fileIn);
			zone = (UZone) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}  
		
		return zone;
	}
	
	public static UZone load(FileInputStream fileIn)
	{	
		//FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		UZone zone = null;
			
		try
		{
			fileIn = new FileInputStream( "UZone.ser" );
			objIn = new ObjectInputStream(fileIn);
			zone = (UZone) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return zone;
	}
	
	public static void addTask(Student stu, Task tas)
	{
		for(Student s: uZoneStudents)
		{
			if(s.getNetID().equals(stu.getNetID()))
			{
				for(Task t: s.getTasks())
				{
					if(t.getTitle().equals(tas.getTitle()))
					{
						return;
					}
				}
				s.getTasks().add(tas);
			}
		}
	}
	
	public static void addEvent(Student stu, Event eve)
	{
		for(Student s: uZoneStudents)
		{
			if(s.getNetID().equals(stu.getNetID()))
			{
				for(Task t: s.getTasks())
				{
					if(t.getTitle().equals(eve.getTitle()))
					{
						return;
					}
				}
				s.getEvents().add(eve);
			}
		}
	}
	
	
	public static void removeTask(Student stu, Task tas)
	{
		for(Student s: uZoneStudents)
		{
			if(s.getNetID().equals(stu.getNetID()))
			{
				for(Task t: s.getTasks())
				{
					if(t.getTitle().equals(tas.getTitle()) && t.getInfo().equals(tas.getInfo()))
					{
						s.getTasks().remove(tas);
					}
				}
			}
		}
	}
	
	
	public static void removeEvent(Student stu, Event eve)
	{
		for(Student s: uZoneStudents)
		{
			if(s.getNetID().equals(stu.getNetID()))
			{
				for(Event e: s.getEvents())
				{
					if(e.getTitle().equals(eve.getTitle()) && e.getInfo().equals(eve.getInfo()))
					{
						s.getEvents().remove(eve);
					}
				}
			}
		}
	}
	

}
