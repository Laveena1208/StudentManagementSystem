import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class UpdateFrame extends JFrame
{
	Container c;
	JLabel lblrno, lblname, lblsub1, lblsub2, lblsub3;
	JTextField txtrno, txtname, txtsub1, txtsub2, txtsub3;
	JButton btnsave, btnback;
	
	UpdateFrame()
	{
		c = getContentPane();
		c.setFont(new Font("Verdana", Font.PLAIN, 15));
        c.setBackground(new Color(255,102,102));
		c.setLayout(null);
		
		lblrno   = new JLabel("Enter Rollno: ");
		txtrno   = new JTextField(22);
		lblname = new JLabel("Enter Name: ");
		txtname = new JTextField(20);
		lblsub1 = new JLabel("Enter Subject marks 1: ");
		txtsub1 = new JTextField(20);
		lblsub2 = new JLabel("Enter Subject marks 2: ");
		txtsub2 = new JTextField(20);
		lblsub3 = new JLabel("Enter Subject marks 3 ");
		txtsub3 = new JTextField(20);
		btnsave = new JButton("SAVE");
		btnback = new JButton("BACK");
		
		lblrno.setBounds(170,80,130,25);
		txtrno.setBounds(300,80,130,25);
		lblname.setBounds(170,130,130,25);
		txtname.setBounds(300,130,130,25);
		lblsub1.setBounds(170,180,130,25);
		txtsub1.setBounds(300,180,130,25);
		lblsub2.setBounds(170,230,130,25);
		txtsub2.setBounds(300,230,130,25);
		lblsub3.setBounds(170,280,130,25);
		txtsub3.setBounds(300,280,130,25);
		btnsave.setBounds(210,330,80,25);
		btnback.setBounds(300,330,80,25);
		
		
		
		c.add(lblrno);
		c.add(txtrno);
		c.add(lblname);
		c.add(txtname);
		c.add(lblsub1);
		c.add(txtsub1);
		c.add(lblsub2);
		c.add(txtsub2);
		c.add(lblsub3);
		c.add(txtsub3);
		c.add(btnsave);
		c.add(btnback);
		
		
		ActionListener a2 = (ae)->
		{
			MainFrame a = new MainFrame();
			dispose();
		};
		btnback.addActionListener(a2);
		
		ActionListener a3 = (ae)->
		{
			try{
			Student stu =  new Student();
			stu.setRno(Integer.parseInt(txtrno.getText()));
			stu.setName(txtname.getText());
			stu.setMarks1(Integer.parseInt(txtsub1.getText()));
			stu.setMarks2(Integer.parseInt(txtsub2.getText()));
			stu.setMarks3(Integer.parseInt(txtsub3.getText()));
			

			Hbupdate hu = new Hbupdate();
			int i = hu.update(stu);
			if( i == 1)
			{
				JOptionPane.showMessageDialog(this, "Record updated");
				clear();
			}
			/*else if(i == 0)
			{
				JOptionPane.showMessageDialog(this, "Record doesnot exist");
				clear();
			}*/
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this,"Rollno and Marks should only contain integer values not Alphabets, not spaces, not special characters");
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Record doesnot exist");
			}
		};
		btnsave.addActionListener(a3);
		
		setTitle("Student Management System: UpdateStudent");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void clear()
	{
		txtrno.setText("");
		txtname.setText("");
		txtsub1.setText("");
		txtsub2.setText("");
		txtsub3.setText("");
	}
}
	
	