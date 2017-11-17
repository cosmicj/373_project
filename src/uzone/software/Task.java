package uzone.software;

import java.io.Serializable;
import java.util.Calendar;
//import java.util.Date;

public class Task implements Serializable
{

	private static final long serialVersionUID = -5456346877409662924L;
	
	private Calendar datedue = Calendar.getInstance();
	private String ampm;
	private String title;
	private String info;
	
	
	public Task()
	{
		
	}
	
	
	public Calendar getDateDue()
	{
		return this.datedue;
	}
	public void setDateDue(int year, int month, int day, int hour, int minute)
	{
		this.datedue.set(Calendar.YEAR, year); // Sets the year
		this.datedue.set(Calendar.MONTH, month); // Sets the month
		this.datedue.set(Calendar.DAY_OF_MONTH, day); // Sets the day
		this.datedue.set(Calendar.HOUR_OF_DAY, hour); // Sets the hour
		this.datedue.set(Calendar.MINUTE, minute); // Sets the minute
	}
	
	public String getAmPm()
	{
		return this.ampm;
	}
	public void setAmPm(String ap)
	{
		this.ampm = ap;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String t)
	{
		this.title = t;
	}
	
	public String getInfo()
	{
		return this.info;
	}
	public void setInfo(String i)
	{
		this.info = i;
	}
	
	

}
