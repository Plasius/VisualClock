package main;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ClockTray {

	public static void main(String[] args) {

        try {
			//Check the SystemTray is supported
	        if (!SystemTray.isSupported()) {
	            System.out.println("SystemTray is not supported");
	            return;
	        }
	        
	        //load, scale image and create tray
	        BufferedImage trayIconImage = ImageIO.read(ClassLoader.getSystemResource("icon.png"));
	        int trayIconWidth = new TrayIcon(trayIconImage).getSize().width;
	        TrayIcon trayIcon = new TrayIcon(trayIconImage.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH));
	        final SystemTray tray = SystemTray.getSystemTray();

	        //set up
	        trayIcon.setToolTip("VisualClock");
            trayIcon.addActionListener(new WindowManagerListener());
            
            //menu
	        final PopupMenu popup = new PopupMenu();
	        
	        MenuItem openItem= new MenuItem("Toggle window");
	        openItem.addActionListener(new ActionListener  () {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						trayIcon.getActionListeners()[0].actionPerformed(e);
				}
	        	
	        });
	        popup.add(openItem);
	        
	        MenuItem exitItem = new MenuItem("Exit");
	        exitItem.addActionListener(new ExitListener());
	        popup.add(exitItem);
	        
	        trayIcon.setPopupMenu(popup);
	        
	        //show in the tray
            tray.add(trayIcon);
	        
        } catch (Exception e) {
            System.out.println("TrayIcon could not be added.");
        }
		
	}

}
