package uzone.software;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import uzone.software.*;
import uzone.people.*;
import uzone.software.UZoneGUI.MenuListener;

public class UZoneGUI extends JFrame
{
	private static final long serialVersionUID = -6063147849307827869L;
	
	
	private JMenuBar menuBar;
	
	private JMenu homeMenu;
	private JMenu loginMenu;
	private JMenu tasksMenu;
	private JMenu eventsMenu;
	private JMenu complaintsMenu;
	
	private Student currStudent = null;
	private ArrayList<Student> studentList;
	private ArrayList<Admin> adminList;

	// Home submenus
	private JMenuItem returnHome;
	private JMenuItem exit;
	// Login submenus
	private JMenuItem signin;
	private JMenuItem signup;
	private JMenuItem signout;
	// Task submenus
	private JMenuItem viewTasks;
	private JMenuItem addTask;
	private JMenuItem removeTask;
	// Event submenus
	private JMenuItem viewEvents;
	private JMenuItem addEvent;
	private JMenuItem removeEvent;
	// Complaint submenus
	private JMenuItem addComplaint;
	
	//private JMenuItem reset;
	
	// Frame
	private JFrame frame;
	
	
	
	private UZone uzone = new UZone();
			
	
		
		
	public UZoneGUI(String title)//, UZone zone)// ArrayList<Student> students)
	{
		super(title);
		
		try 
		{
			uzone = UZone.load(new FileInputStream("UZone.ser"));
		} 
		catch (IOException e) 
		{
			System.err.println("Didn't Load Properly");
		}
		/*
		try (ObjectInputStream inputstream = new ObjectInputStream(new FileInputStream("UZone.txt"))) 
		{
		    uzone = (UZone) inputstream.readObject();
		} 
		catch (IOException | ClassNotFoundException exp) 
		{
		    exp.printStackTrace();
		}
		*/
		
		adminList = new ArrayList<Admin>();
		for(int i = 0; i < uzone.getAdmins().size(); i++)
		{
			adminList.add(uzone.getAdmins().get(i));
		}
		studentList = new ArrayList<Student>();
		for(int i = 0; i < uzone.getStudents().size(); i++)
		{
			studentList.add(uzone.getStudents().get(i));
		}
		//System.out.println(studentList.size());
		
		setSize(500, 500);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Welcome to UZone!" +
				"<BR>Choose an action from the menu bar.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	
	public void buildGUI() 
	{
		menuBar = new JMenuBar();
		frame = new JFrame();
		
		homeMenu = new JMenu("Home");
		loginMenu = new JMenu("Login");
		tasksMenu = new JMenu("Tasks");
		eventsMenu = new JMenu("Events");
		complaintsMenu = new JMenu("Complaints");
		
		
		// Home
		returnHome = new JMenuItem("Go Home");
		exit = new JMenuItem("Exit");
		// Login
		signin = new JMenuItem("Sign In");
		signup = new JMenuItem("Sign Up");
		signout = new JMenuItem("Sign Out");
		// Tasks
		viewTasks = new JMenuItem("View Tasks");
		addTask = new JMenuItem("Add Task");
		removeTask = new JMenuItem("Remove Task");
		// Events
		viewEvents = new JMenuItem("View Events");
		addEvent = new JMenuItem("Add Event");
		removeEvent = new JMenuItem("Remove Event");
		// Complaints
		addComplaint = new JMenuItem("Make a Complaint");
		
		
		
		
		// Home Actions
		returnHome.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		// Login Actions
		signin.addActionListener(new MenuListener());
		signup.addActionListener(new MenuListener());
		signout.addActionListener(new MenuListener());
		// Task Actions
		viewTasks.addActionListener(new MenuListener());
		addTask.addActionListener(new MenuListener());
		removeTask.addActionListener(new MenuListener());
		// Event Actions
		viewEvents.addActionListener(new MenuListener());
		addEvent.addActionListener(new MenuListener());
		removeEvent.addActionListener(new MenuListener());
		// Complaint Actions
		addComplaint.addActionListener(new MenuListener());
		
	    
		// Add action to menus
		homeMenu.add(returnHome);
		homeMenu.add(exit);
		loginMenu.add(signin);
		loginMenu.add(signup);
		loginMenu.add(signout);
		tasksMenu.add(viewTasks);
		tasksMenu.add(addTask);
		tasksMenu.add(removeTask);
		eventsMenu.add(viewEvents);
		eventsMenu.add(addEvent);
		eventsMenu.add(removeEvent);
		complaintsMenu.add(addComplaint);
		
		// Add menus to menu bar
		menuBar.add(homeMenu);
		menuBar.add(loginMenu);
	    menuBar.add(tasksMenu);
	    menuBar.add(eventsMenu);
	    menuBar.add(complaintsMenu);
	
		setJMenuBar(menuBar);
	}
	
	public class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//JMenu tabMenu = (JMenu)(e.getSource());
			JMenuItem tabItem = (JMenuItem)(e.getSource());
			
			if(tabItem.equals(returnHome))
			{
				homeUZone();
			}
			else if(tabItem.equals(exit))
			{
				exitUZone();
			}
			else if(tabItem.equals(signin))
			{
				signinUZone();
			}
			else if(tabItem.equals(signup))
			{
				signupUZone();
			}
			else if(tabItem.equals(signout))
			{
				signoutUZone();
			}
			else if(tabItem.equals(viewTasks))
			{
				viewTasks();
			}
			else if(tabItem.equals(addTask))
			{
				addTasks();
			}
			else if(tabItem.equals(removeTask))
			{
				removeTasks();
			}
			else if(tabItem.equals(viewEvents))
			{
				viewEvents();
			}
			else if(tabItem.equals(addEvent))
			{
				addEvents();
			}
			else if(tabItem.equals(removeEvent))
			{
				removeEvents();
			}
			else if(tabItem.equals(addComplaint))
			{
				complaintUZone();
			}
			
		}
		
		/////////////////////////////////////		/////////////////////////////////////
		
		private void homeUZone()
		{
			
		}
		
		private void exitUZone()
		{
			/*
		    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("UZone.txt"))) 
		    {
		        os.writeObject(uzone);
		    } 
		    catch (IOException exp) 
		    {
		        exp.printStackTrace();
		    }
		    */
			
			System.exit(0);
		}
		
		/////////////////////////////////////		/////////////////////////////////////
		
		private void signinUZone()
		{
			if(currStudent != null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are already signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame sinframe = new JFrame();
			sinframe.setVisible(true);
			sinframe.setSize(400, 200);
			sinframe.setLocation(200, 200);
			sinframe.setTitle("Sign In");
			
			JPanel panel = new JPanel();
			GridLayout grid = new GridLayout(4,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel logLabel = new JLabel("Login to your account!");
			JLabel forgotLabel = new JLabel("Forgot Password?");
			panel.add(logLabel);
			panel.add(forgotLabel);
			
			JLabel net_email_Label = new JLabel("NetID/Email: ");
			JTextField net_email = new JTextField();
			panel.add(net_email_Label);
			panel.add(net_email);
			
			JLabel passwordLabel = new JLabel("Password: ");
			JTextField password = new JTextField();
			panel.add(passwordLabel);
			panel.add(password);
			

			// Buttons
			JButton log = new JButton("Login");
			JButton cancel = new JButton("Cancel");
			panel.add(log);
			panel.add(cancel);
			
			sinframe.add(panel);
			
			log.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Registration Process
			    	String sNetEmail = net_email.getText();
			    	String sPass = password.getText();
			    	userSignin(sinframe, sNetEmail, sPass);
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	sinframe.dispose();
			    }
			});
		}

		private void signupUZone()
		{
			if(currStudent != null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are already signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame supframe = new JFrame();
			supframe.setVisible(true);
			supframe.setSize(450, 250);
			supframe.setLocation(200, 200);
			supframe.setTitle("Sign Up");
			
			JPanel panel = new JPanel();
			GridLayout grid = new GridLayout(7,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel regLabel = new JLabel("Register an account!");
			JLabel spaceLabel = new JLabel("\n");
			panel.add(regLabel);
			panel.add(spaceLabel);
			
			JLabel nameLabel = new JLabel("Name: ");
			JTextField name = new JTextField();
			panel.add(nameLabel);
			panel.add(name);
			
			JLabel emailLabel = new JLabel("Email: ");
			JTextField email = new JTextField();
			panel.add(emailLabel);
			panel.add(email);
			
			JLabel netidLabel = new JLabel("NetID: ");
			JTextField netid = new JTextField();
			panel.add(netidLabel);
			panel.add(netid);
			
			JLabel passwordLabel = new JLabel("Password: ");
			JTextField password = new JTextField();
			panel.add(passwordLabel);
			panel.add(password);
			
			JLabel sqLabel = new JLabel("Security Question (Favorite Number): ");
			JTextField sq = new JTextField();
			panel.add(sqLabel);
			panel.add(sq);

			// Buttons
			JButton reg = new JButton("Register");
			JButton cancel = new JButton("Cancel");
			panel.add(reg);
			panel.add(cancel);
			
			supframe.add(panel);
			
			
			
			reg.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Registration Process
			    	String sname = name.getText();
			    	String semail = email.getText();
			    	String snetid = netid.getText();
			    	String spass = password.getText();
			    	String squestion = sq.getText();
			    	userSignup(supframe, sname, semail, snetid, spass, squestion);
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	supframe.dispose();
			    }
			});
		}
		
		private void signoutUZone()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame soutframe = new JFrame();
			soutframe.setVisible(true);
			soutframe.setSize(450, 125);
			soutframe.setLocation(200, 200);
			soutframe.setTitle("Sign Out");
			
			JPanel panel = new JPanel();
			GridLayout grid = new GridLayout(2,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel logoutLabel = new JLabel("Are you sure you want to sign out?");
			JLabel spaceLabel = new JLabel("\n");
			panel.add(logoutLabel);
			panel.add(spaceLabel);
			

			// Buttons
			JButton logout = new JButton("Sign Out");
			JButton cancel = new JButton("Cancel");
			panel.add(logout);
			panel.add(cancel);
			
			soutframe.add(panel);
			
			logout.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Sign Out Process
			    	currStudent = null;
					JOptionPane.showMessageDialog(null, 
							"You have signed out!", 
							"Success", 
							JOptionPane.PLAIN_MESSAGE);
					soutframe.dispose();
					
					return;
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	soutframe.dispose();
			    }
			});
		}
		
		/////////////////////////////////////		/////////////////////////////////////
		
		private void viewTasks()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			/*
			JFrame taskframe = new JFrame();
			taskframe.setVisible(true);
			taskframe.setSize(400, 200);
			taskframe.setLocation(200, 200);
			taskframe.setTitle("View Tasks");
			
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			//GridLayout grid = new GridLayout(4,2);
			//panel.setLayout(grid);
			*/
			
			JFrame taskFrame = new JFrame();
			
			StringBuilder stringTask = new StringBuilder();
			
			stringTask.append(currStudent.getName() + "'s Tasks:\n");
			if(currStudent.getTasks() != null)
			{
				for(int i = 0; i < currStudent.getTasks().size(); i++)
				{
					stringTask.append(currStudent.getTasks().get(i).getDateDue().get(Calendar.MONTH) + " "
							+ currStudent.getTasks().get(i).getDateDue().get(Calendar.DAY_OF_MONTH) + ", "
							+ currStudent.getTasks().get(i).getDateDue().get(Calendar.YEAR) + " @ "
							+ currStudent.getTasks().get(i).getDateDue().get(Calendar.HOUR_OF_DAY) + ":"
							+ currStudent.getTasks().get(i).getDateDue().get(Calendar.MINUTE)
							+ currStudent.getTasks().get(i).getAmPm() + " :\n"
							+ currStudent.getTasks().get(i).getTitle() + " - " + currStudent.getTasks().get(i).getInfo() + "\n");
				}
			}
			else
			{
				stringTask.append("No Tasks Added Yet");
			}
			
			
			JTextArea textArea = new JTextArea(30, 30);
			textArea.setEditable(false);
			textArea.setText(stringTask.toString());
			
			JScrollPane scrollPane = new JScrollPane(textArea);
			JOptionPane.showMessageDialog(taskFrame, scrollPane);
			
			//taskframe.add(panel);
		}
		
		private void addTasks()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame taskframe = new JFrame();
			taskframe.setVisible(true);
			taskframe.setSize(400, 200);
			taskframe.setLocation(200, 200);
			taskframe.setTitle("Add Task");
			
			JPanel panel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			GridLayout grid = new GridLayout(4,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel addtaskLabel = new JLabel("Add a Task!");
			JLabel emptyLabel = new JLabel("\n");
			//JLabel emptyLabel2 = new JLabel("\n");
			panel.add(addtaskLabel);
			panel.add(emptyLabel);
			
			JLabel taskTitleLabel = new JLabel("Task Title: ");
			JTextField taskTitle = new JTextField();
			JLabel taskInfoLabel = new JLabel("Task Info: ");
			JTextField taskInfo = new JTextField();
			//panel.add(compArea);
			//panel.add(emptyLabel2);
			panel.add(taskTitleLabel);
			panel.add(taskTitle);
			panel.add(taskInfoLabel);
			panel.add(taskInfo);
			

			// Buttons
			JButton gtask = new JButton("Make Task");
			JButton cancel = new JButton("Cancel");
			panel.add(gtask);
			panel.add(cancel);
			
			taskframe.add(panel);
			
			gtask.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Registration Process
			    	String sTaskTitle = taskTitle.getText();
			    	String sTaskInfo = taskInfo.getText();
			    	
			    	if(sTaskTitle != null)
			    	{
						if(sTaskTitle.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Task Title can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
			    	}
			    	if(sTaskInfo != null)
			    	{
						if(sTaskInfo.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Task Info can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
			    	}
			    	
			    	setDateTime(taskframe, sTaskTitle, sTaskInfo, "Task");
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	taskframe.dispose();
			    }
			});
		}
		
		private void removeTasks()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame taskframe = new JFrame();
			taskframe.setVisible(true);
			taskframe.setSize(400, 200);
			taskframe.setLocation(200, 200);
			taskframe.setTitle("Remove Task");
			
			JPanel panel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			GridLayout grid = new GridLayout(3,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel deleteTaskLabel = new JLabel("Remove a Task!");
			JLabel emptyLabel = new JLabel("\n");
			//JLabel emptyLabel2 = new JLabel("\n");
			panel.add(deleteTaskLabel);
			panel.add(emptyLabel);
			
			JLabel taskLabel = new JLabel("Task: ");
			JTextField task = new JTextField();
			//JLabel dateLabel = new JLabel("Date: ");
			//JTextField date = new JTextField();
			panel.add(taskLabel);
			panel.add(task);
			//panel.add(dateLabel);
			//panel.add(date);
			

			// Buttons
			JButton dtask = new JButton("Delete Task");
			JButton cancel = new JButton("Cancel");
			panel.add(dtask);
			panel.add(cancel);
			
			taskframe.add(panel);
			
			dtask.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Registration Process
			    	String sTask = task.getText();
			    	//String sDate = date.getText();
			    	
			    	if(sTask != null)
			    	{
						if(sTask.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Task can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else
						{
							for(int i = 0; i < currStudent.getTasks().size(); i++)
							{
								if(currStudent.getTasks().get(i).equals(sTask))
								{
									// remove Task
									JOptionPane.showMessageDialog(null, 
											currStudent.getName() + " has removed this Task!\n"
											+ currStudent.getTasks().get(i).getTitle(), 
											"Success",
											JOptionPane.PLAIN_MESSAGE);
									currStudent.getTasks().remove(currStudent.getTasks().get(i));
									taskframe.dispose();
								}
							}
							JOptionPane.showMessageDialog(null, 
									"Student doesn't have this Task", 
									"Error",
									JOptionPane.PLAIN_MESSAGE);
							return;
						}
			    	}
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	taskframe.dispose();
			    }
			});
		}

		/////////////////////////////////////		/////////////////////////////////////
		
		private void viewEvents()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame eventframe = new JFrame();
			eventframe.setVisible(true);
			eventframe.setSize(400, 200);
			eventframe.setLocation(200, 200);
			eventframe.setTitle("View Events");
			
			JPanel panel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			//GridLayout grid = new GridLayout(4,2);
			//panel.setLayout(grid);
			eventframe.add(panel);
		}

		private void addEvents()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame eventframe = new JFrame();
			eventframe.setVisible(true);
			eventframe.setSize(400, 200);
			eventframe.setLocation(200, 200);
			eventframe.setTitle("Add Event");
			
			JPanel panel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			GridLayout grid = new GridLayout(4,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel addeventLabel = new JLabel("Add an Event!");
			JLabel emptyLabel = new JLabel("\n");
			//JLabel emptyLabel2 = new JLabel("\n");
			panel.add(addeventLabel);
			panel.add(emptyLabel);
			
			JLabel eventTitleLabel = new JLabel("Event Title: ");
			JTextField eventTitle = new JTextField();
			JLabel eventInfoLabel = new JLabel("Event Info: ");
			JTextField eventInfo = new JTextField();
			//panel.add(compArea);
			//panel.add(emptyLabel2);
			panel.add(eventTitleLabel);
			panel.add(eventTitle);
			panel.add(eventInfoLabel);
			panel.add(eventInfo);
			

			// Buttons
			JButton gevent = new JButton("Make Event");
			JButton cancel = new JButton("Cancel");
			panel.add(gevent);
			panel.add(cancel);
			
			eventframe.add(panel);
			
			gevent.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Event Process
			    	String sEventTitle = eventTitle.getText();
			    	String sEventInfo = eventInfo.getText();
			    	
			    	if(sEventTitle != null)
			    	{
						if(sEventTitle.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Event Title can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
			    	}
			    	if(sEventInfo != null)
			    	{
						if(sEventInfo.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Event Info can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
			    	}
			    	
			    	setDateTime(eventframe, sEventTitle, sEventInfo, "Event");
					
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	eventframe.dispose();
			    }
			});
		}
		
		private void removeEvents()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame eventframe = new JFrame();
			eventframe.setVisible(true);
			eventframe.setSize(400, 200);
			eventframe.setLocation(200, 200);
			eventframe.setTitle("Delete Event");
			
			JPanel panel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			GridLayout grid = new GridLayout(3,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel deleteEventLabel = new JLabel("Delete an Event!");
			JLabel emptyLabel = new JLabel("\n");
			//JLabel emptyLabel2 = new JLabel("\n");
			panel.add(deleteEventLabel);
			panel.add(emptyLabel);
			
			JLabel eventLabel = new JLabel("Event Title: ");
			JTextField event = new JTextField();
			//JLabel dateLabel = new JLabel("Date: ");
			//JTextField date = new JTextField();
			panel.add(eventLabel);
			panel.add(event);
			//panel.add(dateLabel);
			//panel.add(date);
			

			// Buttons
			JButton devent = new JButton("Delete Event");
			JButton cancel = new JButton("Cancel");
			panel.add(devent);
			panel.add(cancel);
			
			eventframe.add(panel);
			
			devent.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Event Deletion
			    	String sEvent = event.getText();
			    	//String sDate = date.getText();
			    	
			    	if(sEvent != null)
			    	{
						if(sEvent.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Event can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else
						{
							// Delete Event
							for(int i = 0; i < currStudent.getEvents().size(); i++)
							{
								if(currStudent.getEvents().get(i).equals(sEvent))
								{
									// remove Event
									JOptionPane.showMessageDialog(null, 
											currStudent.getName() + " has removed this Event!\n"
											+ currStudent.getEvents().get(i).getTitle(), 
											"Success",
											JOptionPane.PLAIN_MESSAGE);
									currStudent.getEvents().remove(currStudent.getEvents().get(i));
									eventframe.dispose();
								}
							}
							JOptionPane.showMessageDialog(null, 
									"Student doesn't have this Event", 
									"Error",
									JOptionPane.PLAIN_MESSAGE);
							return;
							
						}
			    	}
			    	
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	eventframe.dispose();
			    }
			});
		}
		
		/////////////////////////////////////		/////////////////////////////////////
		
		private void complaintUZone()
		{
			if(currStudent == null)
			{
				JOptionPane.showMessageDialog(null, 
						"You are not signed in!", 
						"Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			JFrame compframe = new JFrame();
			compframe.setVisible(true);
			compframe.setSize(400, 200);
			compframe.setLocation(200, 200);
			compframe.setTitle("Complaints");
			
			JPanel panel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			GridLayout grid = new GridLayout(3,2);
			panel.setLayout(grid);
			
			// Text Field
			JLabel compLabel = new JLabel("File a Complaint!");
			JLabel emptyLabel = new JLabel("\n");
			JLabel emptyLabel2 = new JLabel("\n");
			panel.add(compLabel);
			panel.add(emptyLabel);
			
			JTextArea compArea = new JTextArea();
			panel.add(compArea);
			panel.add(emptyLabel2);
			

			// Buttons
			JButton file = new JButton("Submit");
			JButton cancel = new JButton("Cancel");
			panel.add(file);
			panel.add(cancel);
			
			compframe.add(panel);
			
			file.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Registration Process
			    	String sComplaint = compArea.getText();
			    	
			    	if(sComplaint != null)
			    	{
						if(sComplaint.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Complaint can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
			    	}
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	compframe.dispose();
			    }
			});
		}
		
		/////////////////////////////////////		/////////////////////////////////////
		
		private void userSignin(JFrame thisFrame, String email_net, String password)
		{
			if(email_net != null)
			{
				if(email_net.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please enter either your Email or NetID", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
				// Check if email or netid are in the system
				boolean isin = false;
				for(int i = 0; i < studentList.size(); i++)
				{
					if(studentList.get(i).getEmail().equals(email_net) || studentList.get(i).getNetID().equals(email_net))
					{
						isin = true;
						currStudent = studentList.get(i);
						break;
					}
				}
				if(isin == false)
				{
					// Not in the system
					JOptionPane.showMessageDialog(null, 
												"The Email or NetID you provided is not in our system", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
			if(password != null)
			{
				if(password.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please enter your Password", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
				
				if(currStudent.getPassword().equals(password))
				{
					JOptionPane.showMessageDialog(null, 
							"Correct!", 
							"Success", 
							JOptionPane.PLAIN_MESSAGE);
					thisFrame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
							"Your password doesn't match your NetID/Email!", 
							"Error", 
							JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		}
		
		private void userSignup(JFrame thisFrame, String name, String email, String netid, String pass, String sq)
		{
			int sqVal = 0;

			if(name != null)
			{
				if(name.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please enter your Name", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
			if(email != null)
			{
				if(email.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please enter an Email", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
				for(int i = 0; i < studentList.size(); i++)
				{
					if(studentList.get(i).getEmail().equals(email))
					{
						// Already has account
						JOptionPane.showMessageDialog(null, 
								"There already exists an account with this Email", 
								"Error", 
								JOptionPane.PLAIN_MESSAGE);
						return;
					}
				}
			}
			if(netid != null)
			{
				if(netid.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please enter your NetID", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
				for(int i = 0; i < studentList.size(); i++)
				{
					if(studentList.get(i).getNetID().equals(netid))
					{
						// Already has account
						JOptionPane.showMessageDialog(null, 
								"There already exists an account with this NetID", 
								"Error", 
								JOptionPane.PLAIN_MESSAGE);
						return;
					}
				}
			}
			if(pass != null)
			{
				if(pass.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please enter a Password", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
				else if(pass.length() < 6)
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Password must be at least 6 characters long", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
			}
			if(sq != null)
			{
				if(sq.trim().equals(""))
				{
					// Empty text input
					JOptionPane.showMessageDialog(null, 
												"Please answer the Security Question", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
					return;
				}
				else
				{
					try 
					{
					    sqVal = Integer.parseInt(sq);
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, 
								"This must be a number", 
								"Error", 
								JOptionPane.PLAIN_MESSAGE);
						return;
					}
				}
			}
			
			
			Student newStudent = new Student();
			newStudent.setName(name);
			newStudent.setEmail(email);
			newStudent.setNetID(netid);
			newStudent.setPassword(pass);
			newStudent.setSQ(sq);
			studentList.add(newStudent);
			uzone.addStudent(newStudent);
	
			// Implement Save
			/*
		    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("UZone.txt"))) 
		    {
		        os.writeObject(uzone);
		    } 
		    catch (IOException exp) 
		    {
		        exp.printStackTrace();
		    }
		    */
		    
			UZone.saveData(uzone);
			
			JOptionPane.showMessageDialog(null, 
					"Successfully Registered!", 
					"Success", 
					JOptionPane.PLAIN_MESSAGE);
			thisFrame.dispose();
			
			
		}
	
		private void setDateTime(JFrame thisFrame, String title, String info, String task_event)
		{
			JFrame dateFrame = new JFrame();
			dateFrame.setVisible(true);
			dateFrame.setSize(400, 200);
			dateFrame.setLocation(300, 250);
			dateFrame.setTitle("Date Info");
			
			JPanel datepanel = new JPanel();
			//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			GridLayout dategrid = new GridLayout(6,2);
			datepanel.setLayout(dategrid);
			
			JLabel dateLabel = new JLabel("Set the time!");
			JLabel dateSpace = new JLabel("\n");
			
			JLabel dateYearLabel = new JLabel("Year (YYYY) : ");
			JTextField dateYear = new JTextField();
			JLabel dateMonthLabel = new JLabel("Month (MM) : ");
			JTextField dateMonth = new JTextField();
			JLabel dateDayLabel = new JLabel("Day (DD) : ");
			JTextField dateDay = new JTextField();
			JLabel dateTimeLabel = new JLabel("Time (HH:mm[AM/PM]) : ");
			JTextField dateTime = new JTextField();
			
			
			datepanel.add(dateLabel);
			datepanel.add(dateSpace);
			
			datepanel.add(dateYearLabel);
			datepanel.add(dateYear);
			datepanel.add(dateMonthLabel);
			datepanel.add(dateMonth);
			datepanel.add(dateDayLabel);
			datepanel.add(dateDay);
			datepanel.add(dateTimeLabel);
			datepanel.add(dateTime);
			
			JButton complete = new JButton("Complete");
			JButton cancel = new JButton("Cancel");
			datepanel.add(complete);
			datepanel.add(cancel);
			
			dateFrame.add(datepanel);
			
			
			complete.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	// Complete Date Process
			    	String sYear = dateYear.getText();
			    	String sMonth = dateMonth.getText();
			    	String sDay = dateDay.getText();
			    	String sTime = dateTime.getText();
			    	
			    	int yearVal = 0;
			    	int monthVal = 0;
			    	int dayVal = 0;
			    	int hourVal = 0;
			    	int minVal = 0;
			    	String sAmPm = null;
			    	
			    	if(sYear != null)
			    	{
						if(sYear.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Year can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else if(sYear.length() != 4)
						{
							JOptionPane.showMessageDialog(null, 
									"Follow the format (YYYY)", 
									"Error", 
									JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else if(sYear.length() == 4)
						{
							try 
							{
							    yearVal = Integer.parseInt(sYear);
							}
							catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null, 
										"Year input must be 4 numbers", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							
							if(yearVal < 2017 || yearVal > 2050)
							{
								JOptionPane.showMessageDialog(null, 
										"Year must be between 2017 and 2050", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
						}
			    	}
			    	if(sMonth != null)
			    	{
						if(sMonth.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Month can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else if(sMonth.length() != 2)
						{
							JOptionPane.showMessageDialog(null, 
									"Follow the format (MM)", 
									"Error", 
									JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else if(sMonth.length() == 2)
						{
							try 
							{
							    monthVal = Integer.parseInt(sMonth);
							}
							catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null, 
										"Month input must be 2 numbers", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							
							if(monthVal < 1 || monthVal > 12)
							{
								JOptionPane.showMessageDialog(null, 
										"Month must be between 1 and 12", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
						}
			    	}
			    	if(sDay != null)
			    	{
						if(sDay.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Day can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
						if(sDay.length() != 2)
						{
							JOptionPane.showMessageDialog(null, 
									"Follow the format (DD)", 
									"Error", 
									JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else if(sDay.length() == 2)
						{
							try 
							{
							    dayVal = Integer.parseInt(sDay);
							}
							catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null, 
										"Day input must be 2 numbers", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							
							switch(monthVal)
							{
								case 1: case 3: case 5: case 7: case 8: case 10: case 12:
									if(dayVal < 1 || dayVal > 31)
									{		
										JOptionPane.showMessageDialog(null, 
												"Day must be between 1 and 31 for this month", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
										return;
									}
									break;
								case 4: case 6: case 9: case 11:
									if(dayVal < 1 || dayVal > 30)
									{		
										JOptionPane.showMessageDialog(null, 
												"Day must be between 1 and 30 for this month", 
												"Error", 
												JOptionPane.PLAIN_MESSAGE);
										return;
									}
									break;
								case 2:
									if(yearVal % 4 == 0)
									{
										if(dayVal < 1 || dayVal > 29)
										{		
											JOptionPane.showMessageDialog(null, 
													"Day must be between 1 and 29 for this month", 
													"Error", 
													JOptionPane.PLAIN_MESSAGE);
											return;
										}
									}
									else
									{
										if(dayVal < 1 || dayVal > 28)
										{		
											JOptionPane.showMessageDialog(null, 
													"Day must be between 1 and 28 for this month", 
													"Error", 
													JOptionPane.PLAIN_MESSAGE);
											return;
										}
									}
									break;
							}	
						}
			    	}
			    	if(sTime != null)
			    	{
						if(sTime.trim().equals(""))
						{
							// Empty text input
							JOptionPane.showMessageDialog(null, 
														"Time can't be empty!", 
														"Error", 
														JOptionPane.PLAIN_MESSAGE);
							return;
						}
						if(sTime.length() != 7)
						{
							JOptionPane.showMessageDialog(null, 
									"Follow the format (HH:mm[AM/PM])", 
									"Error", 
									JOptionPane.PLAIN_MESSAGE);
							return;
						}
						else if(sTime.length() == 7)
						{
							if(sTime.charAt(2) != ':')
							{
								JOptionPane.showMessageDialog(null, 
										"Follow the format (HH:mm[AM/PM])", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							try
							{
								hourVal = Integer.parseInt(sTime.substring(0, 2));
								minVal = Integer.parseInt(sTime.substring(3, 5));
								sAmPm = sTime.substring(5);
							}
							catch(NumberFormatException e)
							{
								JOptionPane.showMessageDialog(null, 
										"Follow the format (HH:mm[AM/PM])", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							
							if(hourVal < 0 || hourVal > 12)
							{
								JOptionPane.showMessageDialog(null, 
										"Hour must be between 1 and 12", 
										"Error", 
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							if(minVal < 0 || minVal > 59)
							{
								JOptionPane.showMessageDialog(null, 
										"Minute must be between 1 and 59", 
										"Error",
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
							if(!(sAmPm.equals("AM")) && !(sAmPm.equals("PM")))
							{
								JOptionPane.showMessageDialog(null, 
										"Must be AM or PM", 
										"Error",
										JOptionPane.PLAIN_MESSAGE);
								return;
							}
						}
						
			    	}
			    	
			    	// If Task or Event
			    	if(task_event.equals("Task"))
			    	{
			    		Task newTask = new Task();
			    		newTask.setTitle(title);
			    		newTask.setInfo(info);
			    		newTask.setDateDue(2017, 8, 31, 11, 59);
			    		newTask.setDateDue(yearVal, monthVal, dayVal, hourVal, minVal);
			    		newTask.setAmPm(sAmPm);
			    		//uzone.getStudents().get(2).getTasks().add(newTask);
			    		//System.out.println(title+"-"+info+" : "+monthVal+"/"+dayVal+"/"+yearVal+", "+hourVal+":"+minVal+sAmPm+"\n");
			    		//currStudent.getTasks().add(newTask);
			    		//currStudent.addTask(newTask);
			    	}
			    	else if(task_event.equals("Event"))
			    	{
			    		Event newEvent = new Event();
			    		newEvent.setTitle(title);
			    		newEvent.setInfo(info);
			    		newEvent.setDateOf(yearVal, monthVal, dayVal, hourVal, minVal);
			    		newEvent.setAmPm(sAmPm);
			    		//currStudent.addEvent(newEvent);
			    	}
					JOptionPane.showMessageDialog(null, 
							"Date Added!", 
							"Success", 
							JOptionPane.PLAIN_MESSAGE);
					dateFrame.dispose();
					thisFrame.dispose();
			    }
			});
			cancel.addActionListener(new ActionListener() 
			{	
			    public void actionPerformed(ActionEvent action) 
			    {
			    	dateFrame.dispose();
			    }
			});
			
		}
	}


}