import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
	Container c;
	JButton btnadd, btnview, btnupdate, btndelete, btncharts;
	
	MainFrame()
	{
		c = getContentPane();
		c.setLayout(null);
		
		btnadd = new JButton("ADD");
		btnview = new JButton("VIEW");
		btnupdate = new JButton("UPDATE");
		btndelete = new JButton("DELETE");
		btncharts= new JButton("CHARTS");
		
		btnadd.setBounds(170,80,100,25);
		btnview.setBounds(300,80,100,25);
		btnupdate.setBounds(170,130,100,25);
		btndelete.setBounds(300,130,100,25);
		btncharts.setBounds(240,180,100,25);
		
		c.add(btnadd);
		c.add(btnview);
		c.add(btnupdate);
		c.add(btndelete);
		c.add(btncharts);
		
		ActionListener a1 = (ae)-> 
		{
			AddFrame a = new AddFrame();
			dispose();
		};
		btnadd.addActionListener(a1);
		
		ActionListener a2 = (ae)-> 
		{
			UpdateFrame a = new UpdateFrame();
			dispose();
		};
		btnupdate.addActionListener(a2);
		
		ActionListener a3 = (ae)-> 
		{
			DeleteFrame a = new DeleteFrame();
			dispose();
		};
		btndelete.addActionListener(a3);
		
		ActionListener a4 = (ae)-> 
		{
			ViewFrame a = new ViewFrame();
			dispose();
		};
		btnview.addActionListener(a4);
		
		ActionListener a5 = (ae)-> 
		{
			Charts a = new Charts();
			dispose();
		};
		btncharts.addActionListener(a5);
		
		setTitle("Student Management System");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}