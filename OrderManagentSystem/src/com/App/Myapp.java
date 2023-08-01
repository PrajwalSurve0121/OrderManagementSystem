package com.App;
import java.util.*;
public class Myapp {
	
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {


		int ch;
		
		do
		{
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=");
			System.out.println("........................Order Management System..............................");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=");
			
			System.out.println("1. Item Pannel");
			System.out.println("2. Customer Pannel");
			System.out.println("3. Order Pannel");
			System.out.println("4. Exit");
			
			System.out.println("Enter Your Choice");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1: ItemPanel.main(null);
			break;
			case 2: CustomerPanel.main(null);
			break;
			case 3: OrderPanel.main(null);
			break;
			case 4: System.exit(0);
			break;
			default :System.out.println("Wrong Choice"); 
			}
			
			

		}while(ch!=4);

	}

}
