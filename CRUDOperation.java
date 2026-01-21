package StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperation {
	

	public void insertStudentData(int id, String name, String city) throws ClassNotFoundException, SQLException  {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/studentManagementSystem";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		
		// write SQL query
		String sql = "INSERT INTO student(id, name, city) VALUES (?, ?, ?)";
		 
	    PreparedStatement ps = connection.prepareStatement(sql);
	    ps.setInt(1, id);
	    ps.setString(2, name);
	    ps.setString(3, city);
	    
	    //execute query
	    ps.executeUpdate();
	    System.out.println("Data Inserted Sucessfully......");
	    //close connection
	    connection.close();
	}
	
	public void getSpecificData(int choice) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		String sql="";
		
		String url="jdbc:mysql://localhost:3306/studentManagementSystem";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement ps;
		
        switch (choice) {

		        case 1:
		            System.out.print("Enter Student ID: ");
		            int id = sc.nextInt();
		            sql = "SELECT * FROM student WHERE id = ?";
		            ps = connection.prepareStatement(sql);
		            ps.setInt(1, id);
		            break;
		
		        case 2:
		            System.out.print("Enter Student Name: ");
		            String name = sc.next();
		            sql = "SELECT * FROM student WHERE name = ?";
		            ps = connection.prepareStatement(sql);
		            ps.setString(1, name);
		            break;
		
		        case 3:
		            System.out.print("Enter City: ");
		            String city = sc.next();
		            sql = "SELECT * FROM student WHERE city = ?";
		            ps = connection.prepareStatement(sql);
		            ps.setString(1, city);
		            break;
		
		        default:
		            System.out.println("Invalid choice");
		            return;
        	}
        
        ResultSet rs = ps.executeQuery();

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name") + " " +
                rs.getString("city")
            );
        }

        if (!found) {
            System.out.println("No record found.");
        }
		
	}
	
	public void updateData(int id,String name,String city) throws SQLException {
		String url="jdbc:mysql://localhost:3306/studentManagementSystem";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
        
		String sql = "UPDATE student SET name = ?, city = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, name); // 1st ?
        ps.setString(2, city); // 2nd ?
        ps.setInt(3, id);     // 3rd ?
        ps.executeUpdate();
		System.out.println("Data Updated Sucessfully.....");
		connection.close();
	}
	
	public void deleteData(int idDelete) throws SQLException {
	
		String url="jdbc:mysql://localhost:3306/studentManagementSystem";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
        
		String sql="DELETE FROM student WHERE id = ?";
//		Statement statement = connection.createStatement();
//		statement.executeUpdate(sql);
		PreparedStatement ps=connection.prepareStatement(sql);
		ps.setInt(1, idDelete);
		ps.execute();
		System.out.println(idDelete+" deleted from database sucessfuly....");
		connection.close();
	}
	
	public void getAllStudentData() throws SQLException {
		String url="jdbc:mysql://localhost:3306/studentManagementSystem";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		
		String sql="SELECT * FROM student";
		Statement statment=connection.createStatement();
		ResultSet rs=statment.executeQuery(sql);
		
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString(2);
			String city=rs.getString(3);
			
			System.out.println(id+ " "+ name+" "+city);
		}
	}

}
