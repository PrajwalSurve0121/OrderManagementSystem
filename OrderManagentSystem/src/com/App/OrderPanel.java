package com.App;
import java.util.*;

import com.Dao.OrderDao;
import com.DaoImpementation.OrderImple;
public class OrderPanel {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {

		int ch;
		
		do
		{
			System.out.println("-=-=-=--=-=-=-=-=-=-=Order Pannel=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("1. Add Order");
			System.out.println("2. Delete Order");
			System.out.println("3. Update Order");
			System.out.println("4. Display All Order");
			System.out.println("5. Search BY Order Id");
			System.out.println("6. Exit Order Pannel");
			
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			int id;
			
			OrderDao or=new OrderImple();
			
			switch(ch)
			{
			case 1:or.AddOrder(null);
			break;
			case 2:or.DeleteOrder(ch);
			break;
			case 3:
				System.out.println("Enter Order id to Update Order");
				 id=sc.nextInt();
				or.UpdateOrder(id);
			break;
			case 4:or.DisplayAllOrder();
			break;
			case 5:System.out.println("Enter Order id to Display Order Details");
				 id=sc.nextInt();
				 System.out.println(or.SearchOrderById(id));
			break;	
			case 6:Myapp.main(null); 
			break;
			default :System.out.println("Incorrect Choice.........");
			}
		}while(ch!=6);

		

	}

}
