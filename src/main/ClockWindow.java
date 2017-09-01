package main;

import javax.swing.JFrame;

public class ClockWindow extends JFrame{
	public static void main(String[] args) {
		JFrame frame= new ClockWindow("WOW");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public ClockWindow(String name) {
		super(name);
		
	}
}
