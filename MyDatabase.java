import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDatabase
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n Driver Registered Successfully.... ");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			System.out.println("\n Database Found Successfully");
			
			Statement st=con.createStatement();
			
			//st.executeUpdate("insert into mytab values(11,'xyz',110)");
			
			int a=12;
			String b="SVIT";
			int c=120;
			
			st.executeUpdate("insert into mytab values("+a+",'"+b+"',"+c+")");
			st.executeUpdate("delete from mytab where sid="+a);
			st.executeUpdate("update mytab set sag = 20 where sag = 40");
			
			/*ResultSet rs=st.executeQuery(" select * from mytab ");
			
			while(rs.next())
			{
				int id=rs.getInt("sid");
				String na=rs.getString(2);//table starts from 1 so when field name not known then start from 1 
				int age=rs.getInt(3);
				System.out.println("\n "+id+" , "+na+" , "+age);
			}
			rs.close();*/
			
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Database Error : "+e.getMessage());
		}
	}
}