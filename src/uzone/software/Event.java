package uzone.software;

import java.io.Serializable;
import java.util.Calendar;
//import java.util.Date;

public class Event implements Serializable
{

	private static final long serialVersionUID = 6444866651950999537L;

	private Calendar dateof;
	private String ampm;
	private String title;
	private String info;
	
	
	public Event()
	{
		
	}
	
	public Calendar getDateOf()
	{
		return this.dateof;
	}
	public void setDateOf(int year, int month, int day, int hour, int minute)
	{
		this.dateof.set(Calendar.YEAR, year); // Sets the year
		this.dateof.set(Calendar.MONTH, month); // Sets the month
		this.dateof.set(Calendar.DAY_OF_MONTH, day); // Sets the day
		this.dateof.set(Calendar.HOUR_OF_DAY, hour); // Sets the hour
		this.dateof.set(Calendar.MINUTE, minute); // Sets the minute
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
