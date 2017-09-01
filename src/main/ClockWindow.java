package main;

import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ClockWindow extends JFrame{
	/* uncomment for testing purposes, also shows usage example
	public static void main(String[] args) {
		JFrame frame= new ClockWindow();
		frame.setVisible(true);
		
		
	}*/
	
	
	JProgressBar progressBar;
	JLabel progressLabel;
	
	public ClockWindow() {
		super();
		setSize(25, 175);	//might change it later to ratios
		setLocation(MouseInfo.getPointerInfo().getLocation().x-15, MouseInfo.getPointerInfo().getLocation().y-200);	//display on above mouse
	    setUndecorated(true);	//we dont need title
	    setLayout(new FlowLayout());	//it does the job
	    
	    //initializing the elements
		progressBar = new JProgressBar(0, 24);
		progressBar.setOrientation(JProgressBar.VERTICAL);
		progressBar.setString("");
		progressBar.setValue(getProgress());
		progressBar.setStringPainted(true);
		add(progressBar);
		
		progressLabel=new JLabel();
		progressLabel.setText(getProgress()*100/24+"%");
		add(progressLabel);
	}
	
	//returns an int between 0 and 24 representing the current hour
	public static int getProgress() {
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.HOUR_OF_DAY);
		
	}
}
