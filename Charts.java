import javax.swing.*;//jframe
import org.jfree.data.category.*;//deafaultcategortdataset
import org.jfree.chart.*;//chart factory
import org.jfree.chart.plot.*;//plot orentation
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class Charts  extends JFrame
{
	Container c;
	JButton btnback;
	
	Charts()
	{
		c = getContentPane();
		btnback = new JButton("BACK");
		btnback.setBounds(300,900,80,25);
		c.add(btnback);
		ActionListener a3 = (ae)->
		{
			MainFrame a = new MainFrame();
			dispose();
		};
		btnback.addActionListener(a3);
		
		
		
		try
		{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","");//"" enter password
				String sql = "select* from addstudent";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				//s1: prepare the data set
				DefaultCategoryDataset ds = new DefaultCategoryDataset();
				while(rs.next())
				{
					ds.addValue(rs.getInt(3), rs.getString(2),"Marks1");
					ds.addValue(rs.getInt(4), rs.getString(2),"Marks2");
					ds.addValue(rs.getInt(5), rs.getString(2),"Marks3");
				}
				//s2: design the chart
				JFreeChart ch = ChartFactory.createBarChart("Student Management System","Subject","Marks",ds,PlotOrientation.VERTICAL,true,true,false);
				
				//s3: display the chart
				ChartPanel cp = new ChartPanel(ch);
				setContentPane(cp);
				
				//s4: save the chart
				try
				{
					File f = new File("students.jpeg");
					ChartUtilities.saveChartAsJPEG(f,ch,700,400);
				}
				catch(IOException e)
				{
					//System.out.println(e);
				}
				setSize(400,400);
				setLocationRelativeTo(null);
				setTitle("Performamce of Students");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(), "issue" + e);
		}
		setTitle("Student Management System: Performance of Students");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

