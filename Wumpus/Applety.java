import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.applet.*;
/*
 <applet code = Applety
*/
public class Applety extends Applet implements WindowListener
{
	Button a[][];
		init()
		{
			a = new Button[4][4];
			//setBackground(Color.gray);
			setForeground(Color.green);
			setLayout(null);
			setSize(500,500);
			setVisible(true);
			setTitle("Wumpus");
// FIXME: Graphics is not Working
// TODO: Get Solution from Sir.
		 // UNCOMMENT : repairs
		//	for(int i=100;i<500;i+=100)
		//		for(int j=100;j<500;j+=100)
		//			g.fillRect(100,100,50,50);
		}
		public void windowActivated(WindowEvent we){}
		public void windowDeactivated(WindowEvent we){}
		public void windowIconified(WindowEvent we){}
		public void windowDeiconified(WindowEvent we){}
		public void windowOpened(WindowEvent we){}
// FIXME: Window not closing 
// TODO: Get Solution from Sir.
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);		
		}

		public void windowClosed(WindowEvent we)
		{
			System.exit(0);		
		}
		public void paint (Graphics g)
		{
			Graphics g = getGraphics();
		// g.setColor(Color.yellow);
				
		g.drawString("This is a String",100,100);
g.fillRect(200,200,50,50);
		}
//  Main : 
		public static void main(String arg[])
		{
				Wumpus w=new Wumpus();
				w.test();
		}

}

/*
TODO : 
   Dimension d = getSize();
   FontMetrics 
   Threads
   DB
   ChoiceContols and awts;
   Event Handles
   RMI
   UDP
   TCP
*/
