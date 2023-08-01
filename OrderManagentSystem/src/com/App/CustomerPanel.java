package com.App;
import java.util.*;

import com.Dao.CustomerDao;
import com.DaoImpementation.CustomerImple;
import com.Entity.Customer;
public class CustomerPanel {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		int ch;
		
		do
		{
			System.out.println("-=-=-=--=-=-=-=-=-=-=Customer Pannel=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer");
			System.out.println("4. Display All Customer");
			System.out.println("5. Search BY Customer Id");
			System.out.println("6. Exit Customer Pannel");
			CustomerDao cd=new CustomerImple();
			Customer c=new Customer();
			
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("Enter Customer Id");
				 	c.setCid(sc.nextInt());
				 	System.out.println("Enter Customer First Name");
				 	c.setFname(sc.next());
				 	System.out.println("Enter Customer Last Name");
				 	c.setLname(sc.next());
				 	System.out.println("Enter Customer Mobile Number");
				 	c.setMobno(sc.nextLong());
				 	System.out.println("Enter Customer Email ");
				 	c.setEamil(sc.next());
				 	System.out.println("Enter Customer Address");
				 	c.setAddress(sc.next());
				 	cd.AddCustomer(c);
				 	break;
			case 2:System.out.println("Enter Customer Id to Delete Customer");
			 		int id=sc.nextInt();
			 		cd.DeleteCustomer(id);
			 		break;
			case 3:System.out.println("Enter Customer Id to Update Mobile Number");
				 	int cid=sc.nextInt();
				 	cd.UpdateCustomer(cid);
				 	break;
			case 4: cd.DisplayAllCustomer();
					break;
			case 5: System.out.println("Enter Customer Id to be Displayed");
					id=sc.nextInt();
					c=cd.SearchCustomerById(id);
					System.out.println("-----------------------------------------------------");
					if(c!=null)
					{
						System.out.println(c);
					}
					else
					{
						System.out.println("No customer with this id exists.........");
					}
					System.out.println("-----------------------------------------------------");
					break;
			case 6: Myapp.main(null);
			break;
			default : System.out.println("Incorrect Choice..."); 
			}
		}while(ch!=6);

		

	}

}
