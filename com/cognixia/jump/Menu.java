package com.cognixia.jump;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.conigxia.jump.dao.EMSDaoImplementation;
import com.conigxia.jump.dao.Employee;

public class Menu {
	EMSDaoImplementation helper = new EMSDaoImplementation();
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
@Test
public void tests() {
		Employee sample = helper.getEmployee(1);
		assertEquals("john", sample.getFname());
		assertEquals("smith", sample.getLname());
		
		sample = helper.getEmployee(2);
		assertEquals("walker", sample.getLname());
		assertEquals("mary@gmail.com", sample.getEmail());
	
		sample = helper.getEmployee(3);
		assertEquals("kevthedev@yahoo.com", sample.getEmail());
		
		
}
	
	public void genMenu() {
		Scanner in = new Scanner(System.in);
		int selection=0;
		do {
		System.out.println("Welcome to the employee management system\n"+
							"----------------------------------------\n"+
							"Enter a number from this list:\n");
		System.out.println("1. List all employees.\n" +
							"2. Get employee information.\n" +
							"3. Add employee.\n"+
							"4. Remove employee.\n"+
							"5. Update employee.\n"+
							"0. Exit program.\n");
		 selection = in.nextInt();
		
		 
			 
		 
		 switch(selection) {
		 		case 0:
		 			System.out.println("Bye!");
		 			break;
			 case 1:
				 List<Employee> employees = new ArrayList<Employee>();
				 employees = helper.getAll();
				 Iterator i = employees.iterator();
				 while(i.hasNext()) {
					 ((Employee) i.next()).printEmployee();
				 }
				 break;
			 case 2:
				 System.out.println("Enter employee ID:\n");
				 int employee_id = in.nextInt();
				 Employee emp = helper.getEmployee(employee_id);
				 emp.printEmployee();
				 
				 break;
			 case 3:
				 
				 String fname, lname, email;
				 in.nextLine();
				 
				 System.out.println("First name: ");
				 fname = in.nextLine();
				 System.out.println("Last name: ");
				 lname = in.nextLine();
				 System.out.println("Email: ");
				 email = in.nextLine();
				 Employee newbie = new Employee(fname, lname, email);
				 helper.addEmployee(newbie);
				 System.out.println("You Added 1 employee!");
				 
				 break;
			 case 4:
				 int employee_id1;
				 System.out.println("Enter employee id to delete:");
				 employee_id1 = in.nextInt();
				 helper.deleteEmployee(employee_id1);
				 System.out.println("You have deleted 1 employee");
				 break;
			 case 5:
				 int employee_id11;
				 String newinfo;
				 int option;
				 System.out.println("Enter employee_id to update: ");
				 employee_id11 = in.nextInt();
				 System.out.println("Do you want to update first name(1), last name(2), or email(3)");
				 option = in.nextInt();
				 
				
				 in.nextLine();
				 System.out.println("What do you want to update to:");
				 newinfo = in.nextLine();
				 //quote(newinfo);
				 //System.out.println(newinfo);
				 
				 helper.updateEmployee(employee_id11, option, newinfo);
				 
				 System.out.println("you have updated 1 employee");
				 
				 break;
			default:
				System.out.println("Sorry thats not available try again.\n");
				break;				 
		 }
		 
		}
		 while(selection!=0) ;
		
		
		}		

}
