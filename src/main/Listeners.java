package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ExitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
}

class WindowManagerListener implements ActionListener{
	ClockWindow instance= new ClockWindow();
	boolean shown;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(instance==null)
			instance= new ClockWindow();
		
		if(shown) {
			instance.setVisible(false);
			shown=false;
			
		}
		else {
			instance.setVisible(true);
			shown=true;
			
		}
		
	}
	
}