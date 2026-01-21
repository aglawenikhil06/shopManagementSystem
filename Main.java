package StudentManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		
		CRUDOperation obj=new CRUDOperation();
		String choice;
		System.out.println("-----------------------------------------------------");
		System.out.println("|          Welcom Student Management System         |");
		System.out.println("-----------------------------------------------------");
		
		do {
			
				System.out.println("Enter 1 for insert student data");
				System.out.println("Enter 2 for get specific student data");
				System.out.println("Enter 3 for update student data");
				System.out.println("Enter 4 for delete student data");
				System.out.println("Enter 5 for get All student record");
			    
				System.out.print("Enter your choice:");
				int ch=sc.nextInt();
			
				switch(ch) {
				
					case 1 : do {
								 System.out.println("---------------------------------------");
								 System.out.println("Enter student records");
								 System.out.println("---------------------------------------");
								 System.out.print("Id number:");
								 int id=sc.nextInt();
								 System.out.print("Enter student name:");
								 String name=sc.next();
								 System.out.print("enter city name:");
								 String city=sc.next();
						         obj.insertStudentData(id,name,city);
						         
						         System.out.println("---------------------------------------");
						         System.out.println("do you want to add more record(yes/no)");
						         choice=sc.next();
						         
							 }while(choice.equals("Yes") || choice.equals("yes"));
					
							 break;
					
					case 2: 
						    System.out.println("---------------------------------------");
							System.out.println("Get student Record by:");
							System.out.println("1. ID");
							System.out.println("2. Name");
							System.out.println("3. City");
							System.out.print("Enter choice: ");
							int c=sc.nextInt();
							
							obj.getSpecificData(c);
						    break;
						   
					case 3: 
							System.out.println("---------------------------------------");
							obj.getAllStudentData();
							System.out.println("---------------------------------------");
							System.out.print("Enter Student ID to update: ");
		                    int id = sc.nextInt();
		                    System.out.print("Enter New Name: ");
		                    String newName = sc.next();

		                    System.out.print("Enter New City: ");
		                    String newCity = sc.next();
						    obj.updateData(id,newName,newCity);
						    System.out.println("---------------------------------------");
						    System.out.println("After updating record");
						    obj.getAllStudentData();
							break;
						
					case 4: 
						    System.out.println("---------------------------------------");
						    obj.getAllStudentData();
						    System.out.println("---------------------------------------");
						    System.out.print("Enter the ID of the row you want to delete:");
						    int idDelete=sc.nextInt();
						    obj.deleteData(idDelete);
						    System.out.println("---------------------------------------");
						    System.out.println("After deleting");
						    obj.getAllStudentData();
							break;
							
					case 5: 
						    System.out.println("---------------------------------------");
							obj.getAllStudentData();
							break;
							
					default: System.out.println("Invalid choice");
							 break;
				
				}
				
				System.out.println("---------------------------------------");
				System.out.println("Do you want to continue operation(Yes/No)");
				choice=sc.next();
				System.out.println("---------------------------------------");
		}while(choice.equals("Yes") || choice.equals("yes"));

		
	}
}
