import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
class Test extends Frame implements Runnable , ActionListener
{
	int delay;
	Button b[];
	Color bg;
	int hit;
	int achive;
	Dialog dnew,dlvlup;
	Button cancel;
	public void run()
	{
		try{
			int k;
			Random r = new Random();
			k=Math.abs(r.nextInt()%16);
			while(true)
			{
				b[k].setBackground(bg);
				Thread.sleep(100);
				b[k=Math.abs(r.nextInt()%16)].setBackground(Color.yellow);
				Thread.sleep(delay);
			}
		}
		catch(Exception e)
		{
			System.out.println("Hey! , sorry an Unexpected Bug Occured , Ping me to correct it");
		}
	}
	Test()
	{
		b= new Button[16];
		setLayout(new GridLayout(4,4,10,10));
		setVisible(true);
		setSize(400,400);
		setTitle("Student form");
		setFont(new Font("Times New Roman" ,3 ,24));
		for(int i=0;i<16;i++){
			b[i]=new Button(""+(i+1));
			b[i].addActionListener(this);
			add(b[i]);
		}
		bg = b[0].getBackground();
		delay = 700;
		hit=1;
		achive=10;
		cancel = new Button("Cancel");
		MenuBar mb= new MenuBar();
		
		Menu actn = new Menu("Action");
		Menu lvl = new Menu("Level");
		MenuItem restart = new MenuItem("Restart",new MenuShortcut('Z'));
		MenuItem select = new MenuItem("Select Level",new MenuShortcut('L'));
		MenuItem quit = new MenuItem("Quit",new MenuShortcut('Q'));
		quit.setFont(new Font("Times New Roman" ,2 ,10));
		select.setFont(new Font("Times New Roman" ,2 ,10));
		MenuItem n = new MenuItem("New",new MenuShortcut('N'));
		n.setFont(new Font("Times New Roman" ,2 ,10));
		actn.add(n);
		actn.add(restart);
		actn.add(new MenuItem("-"));
		actn.add(quit);
		lvl.add(select);
		mb.add(actn);
		mb.add(lvl);
		setMenuBar(mb);
		restart.addActionListener(this);
		quit.addActionListener(this);
		n.addActionListener(this);
		
		dnew = new Dialog(this);
		dnew.setTitle("New");
		dnew.setSize(300,300);
		dnew.setVisible(false);
		dnew.setLayout(null);
		dnew.add(cancel);
//		cancel.setBounds(250,260,100,50);
			
		Thread t = new Thread(this);
		t.start();
	}
	public void actionPerformed(ActionEvent ae)
	{
			
			
		try{
		if(ae.getActionCommand().equals("Restart"))
		{
			
			hit=1;
			achive=10;
			delay=700;
			return ;
		}
		if(ae.getActionCommand().equals("New"))
		{
			dnew.setVisible(true);
			cancel.setBounds(200,200,100,50);
			cancel.addActionListener(this);
			System.out.println("New");
			return ;
		}
		int k=0;
		k=Integer.parseInt(ae.getActionCommand());
		System.out.println(hit);
			if(b[k-1].getBackground() == Color.yellow){
				System.out.println("Caught");
				hit++;
			}
			else if(b[k-1].getBackground() == bg){
				System.out.println("Miss");
				b[k-1].setBackground(Color.red);
				Thread.sleep(100);
				b[k-1].setBackground(bg);
			}
		if(hit%achive == 0 && delay!=0 && achive!=1)  
		{
			dlvlup = new Dialog(this);
			Label l =new Label("You Seem to play well!");
			dlvlup.add(l);
			dlvlup.setVisible(true);
			delay-=100;
			hit++;
			achive--;
		}
	  }
	  catch(Exception e){}
	}
	public static void main(String[] ar)
	{
		new Test();
	}

}

