import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ViewFrame extends JFrame
{
	
	
		ViewFrame()
		{
					JButton btnback = new JButton("BACK");
					JTextArea txt = new JTextArea();
					txt.setBounds(70,50,500,200);   
					btnback.setBounds(270,300,80,25);
					
					JPanel pContainer = new JPanel();
					pContainer.setBackground(new Color(255,102,102));
					pContainer.setLayout(null);
					pContainer.add(txt);
					
					pContainer.add(btnback);
					JScrollPane sp=new JScrollPane(pContainer);
					sp.setBounds(36, 37, 407, 79);
					add(sp);
					
					try
					{
						DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","LAVEENA");
						

						Statement stmt = con.createStatement();
						String sql ="Select * from addstudent";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next())
						{
							int rno=rs.getInt(1);
							String name = rs.getString (2);
							int marks1=rs.getInt(3);
							int marks2=rs.getInt(4);
							int marks3=rs.getInt(5);
							txt.append("Roll No :  "+ rno  + "\t" + "Name :  "+ name + "\t" + "Marks1 :  "+ marks1 + "\t" + "Marks2 :  "+ marks2 + "\t" + "Marks3 :  "+ marks3 + "\n");
							
						}
						rs.close();
						stmt.close();
					}	
					catch(SQLException e)
					{
						JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
					}
						
					ActionListener a4 = (ae)->
					{
						MainFrame a = new MainFrame();
						dispose();
					};
					btnback.addActionListener(a4);
					
					setTitle("Student Management System: ViewStudent");
					setSize(600, 400);
					setLocationRelativeTo(null);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setVisible(true);
					
		
	}		
	
}