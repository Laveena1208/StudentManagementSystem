import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class Hbadd
{
	public int insert(Student stu)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = null;
		Transaction t = null;		
		int i = 0;
		try 
		{
			for (int j = 0; j < stu.name.length(); j++){
				
			if (stu.name.matches("[a-zA-Z]+")&& (stu.name.length() >2) && (stu.rno >= 0) && (stu.marks1 > 0) && (stu.marks1 < 100) && (stu.marks2 > 0) && (stu.marks2 < 100) && (stu.marks3 > 0) && (stu.marks3 < 100))
			{
				s = sf.openSession();
				t = s.beginTransaction();
				s.save(stu);
				t.commit();
				s.close();
				i=1;
			}
			
			}

		   //NAME
		   /*for (int p = 0; p <stu.name.length();p++){
			if (Character.isWhitespace(stu.name.charAt(p)))
			{
				JOptionPane.showMessageDialog(null, "name should not contain space");
		   }}
			
			
			for(int l = 0; l<stu.name.length(); l++) {
			  char a = stu.name.charAt(l);
			  JOptionPane.showMessageDialog(null, "Name should not contain digits");
			}*/
			if(stu.name.equals("") || stu.name.equals(" ") || stu.name.equals("    "))
			{
				JOptionPane.showMessageDialog(null, "Name should not contain spaces");
			}
			if (stu.name.matches("\\d+"))
			{
				JOptionPane.showMessageDialog(null, "Name should not contain digits");
			}
			if (stu.name.length() < 2)
			{
				JOptionPane.showMessageDialog(null, "Name should contain more than 2 letters");
			}
			
			for(int k = 0; k<stu.name.length(); k++) {
			if (!Character.isDigit(stu.name.charAt(k))&& !Character.isLetter(stu.name.charAt(k))&& !Character.isWhitespace(stu.name.charAt(k))) 
			
			{JOptionPane.showMessageDialog(null, "Name should not contain special characters ");}}
			
			
			//ROLLNO
			if ((stu.rno <= 0))
			{
				JOptionPane.showMessageDialog(null, "Rollno should not be contain negative or Zero Value ");
			}
		
		
			//MARKS1
			if (stu.marks1 > 100)
			{
				JOptionPane.showMessageDialog(null, "Marks1 should not be more than 100");
			}
			if (stu.marks1 < 0)
			{
				JOptionPane.showMessageDialog(null, "Marks1 should not be less than 0");
			}
			
			
			
			//MARKS2
			if (stu.marks2 < 0)
			{
				JOptionPane.showMessageDialog(null, "Marks2 should not be less than 0");
			}
			if (stu.marks2 > 100)
			{
				JOptionPane.showMessageDialog(null, "Marks2 should not be more than 100");
			}
		
			
			
			//MARKS 3
			if (stu.marks3 < 0)
			{
				JOptionPane.showMessageDialog(null, "Marks3 should not be less than 0");
			}
			 if (stu.marks3 > 100)
			{
				JOptionPane.showMessageDialog(null, "Marks3 should not be more than 100");
			}
			
			
			
		}
	
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Already exists?");
				
		}
		
		
		
		return i;
	}
}