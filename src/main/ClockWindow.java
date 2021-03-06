package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ClockWindow extends JFrame{
	JProgressBar progressBar;
	JLabel progressLabel;
	
	public ClockWindow() {
		super();
		
		//settings windows location and size
		Dimension screenSize;
		screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/4, screenSize.width/4);
		setLocation(screenSize.width-getWidth(), (int)(screenSize.height-getHeight()*1.1));
		setResizable(false);
	    setUndecorated(true);	//it does the job
	    
	    //main frame
	    DrawPanel mainFrame= new DrawPanel();
	    mainFrame.setBackground(Color.CYAN);
	    mainFrame.setLayout(new FlowLayout());
	    add(mainFrame);
	    
	}
	
	//returns an int between 0 and 144 representing the passed 10-minutes
	public static int getProgress() {
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.HOUR_OF_DAY)*6 + calendar.get(Calendar.MINUTE)/10;
		
	}
	
	//inner class to draw data
	class DrawPanel extends JPanel {
		@Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int widthUnit=getWidth()/14;
            int heightUnit= getHeight()/14;
            int toFill=getProgress();
            int count=0;
            	for(int j=1; j<=12; j++) {

                    for(int i=1; i<=12; i++) {
            		if(count<toFill) {
            			g.setColor(Color.RED);
            		}else {
            			g.setColor(Color.GREEN);
            		}
                    g.fillRect(widthUnit*i, heightUnit*j, widthUnit, heightUnit);

            		g.setColor(Color.BLACK);
                    g.drawRect(widthUnit*i, heightUnit*j, widthUnit, heightUnit);
                    
            		count++;
            	}
            	
            }
        }
		
	}
	
}
