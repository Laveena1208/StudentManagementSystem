import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteFrame extends JFrame
{
	Container c;
	JLabel lblrno;
	JTextField txtrno;
	JButton btnsave, btnback;
	
	DeleteFrame()
	{
		c = getContentPane();
		c.setFont(new Font("Verdana", Font.PLAIN, 15));
        c.setBackground(new Color(51,204,255));
		c.setLayout(null);
		
		lblrno   = new JLabel("Enter Rollno: ");
		txtrno   = new JTextField(22);
		btnsave = new JButton("SAVE");
		btnback = new JButton("BACK");
		
		lblrno.setBounds(170,80,130,25);
		txtrno.setBounds(300,80,130,25);
		btnsave.setBounds(210,150,80,25);
		btnback.setBounds(300,150,80,25);
		
		c.add(lblrno);
		c.add(txtrno);
		c.add(btnsave);
		c.add(btnback);
		
		ActionListener a3 = (ae)->
		{
			MainFrame a = new MainFrame();
			dispose();
		};
		btnback.addActionListener(a3);
		
		ActionListener a2 = (ae)->
		{
			try 
			{  
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "LAVEENA"); 
				
				String sql = "delete from addstudent where rno = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				int rno = Integer.parseInt(txtrno.getText());
				stmt.setInt(1,rno);
				long r = stmt.executeUpdate();
				if ( r==0)
					JOptionPane.showMessageDialog(this,"record does not exist");
						
				else
					JOptionPane.showMessageDialog(this,"record deleted");	
				con.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Rollno should not contain spaces aur Alphabets");
			
			}
			
		};
		btnsave.addActionListener(a2);
		
		setTitle("Student Management System: DeleteStudent");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
	
	