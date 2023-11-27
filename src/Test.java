import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/college";
		String upass="abc123";
		String uname="root";
		int roll,a;
		String name;
		Scanner sc= new Scanner(System.in);
		boolean l=true;
		
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url, uname, upass);
		
		Statement st=con.createStatement();
		
		while(l)
		{
			System.out.println("\nWELCOME TO COLLEGE MANAGEMENT SYSTEM");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Show");
			System.out.println("0.EXIT");
			System.out.println("Enter Your Choice : ");
			int c = Integer.parseInt(sc.nextLine());
			
			switch(c)
			{
			case 1:
				System.out.println("Enter roll number : ");
				roll=Integer.parseInt(sc.nextLine());
				System.out.println("Enter Name : ");
				name=sc.nextLine();
				
				
				String q="insert into stud_tbl values(" +roll+",'"+name+"')";
				a=st.executeUpdate(q);//
				if(a>0)
					System.out.println("data inserted");
				else
					System.out.println("not inserted");
				break;
			case 2:
				System.out.println("Enter the student roll number : ");
				roll=Integer.parseInt(sc.nextLine());
				q="SELECT name  FROM stud_tbl";
				ResultSet rs1=st.executeQuery(q);
				
				while(rs1.next())
				{
					System.out.println(rs1.getInt(1)+" "+rs1.getString(2));
				}
				
				
				q="UPDATE stud_tbl SET name='sakura' WHERE roll=888";
				a=st.executeUpdate(q);
				if(a>0)
					System.out.println("data deleted");
				else
					System.out.println("data not deleted");
				break;
			case 3:
				System.out.println("Enter roll :");
				roll=Integer.parseInt(sc.nextLine());
				q="delete from stud_tbl where roll="+roll;
				a=st.executeUpdate(q);
				if(a>0)
					System.out.println("data deleted");
				else
					System.out.println("data not deleted");
				break;
				
			case 4:
				q="SELECT * FROM stud_tbl";
				ResultSet rs=st.executeQuery(q);
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
				}
				
				break;
				
			
			}
			
		}
		
		

	}

}
