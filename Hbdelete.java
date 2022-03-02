/*import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
 class Hbdelete
 {
	 public  int delete(Student stu)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = null;
		Transaction t = null;
		int i = 0;
		try
		{
			s = sf.openSession();
			System.out.println("connected");
			t = s.beginTransaction();
			//Console c = System.console();
			//int rno = Integer.parseInt(c.readLine("enter rno to be deleted"));
			stu = (Student)s.get(Student.class, txtrno);
			if(stu != null)
			{
				s.delete(stu);
				t.commit();
				i = 1;
				
			}
			else
			{
				i = 0;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			t.rollback();
		}
		finally
		{
			s.close();
			System.out.println("closed");
			
		}
		return i;
	}
 }*/