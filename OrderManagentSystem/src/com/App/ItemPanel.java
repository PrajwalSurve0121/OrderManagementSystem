package com.App;

import java.util.*;

import com.Dao.ItemDao;
import com.DaoImpementation.ItemImple;

public class ItemPanel {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int ch;
		
		do
		{
			System.out.println("-=-=-=--=-=-=-=-=-=-=Item Pannel=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("1. Add Item");
			System.out.println("2. Delete Item");
			System.out.println("3. Update Item");
			System.out.println("4. Display All Item");
			System.out.println("5. Search BY Item Id");
			System.out.println("6. Exit Item Pannel");
			
			ItemDao ite=new ItemImple();
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			int id;
			switch(ch)
			{
			case 1: ite.AddItem(null);
			break;
			case 2: ite.DeleteItem(ch);
			break;
			case 3:
				System.out.println("Enter id");
				id=sc.nextInt();
				ite.UpdateItem(id);
			break;
			case 4: ite.DisplayAllItem();
			break;
			case 5: 
				System.out.println("Enter id");
				id=sc.nextInt();
				System.out.println(ite.SearchItemById(id));
				
			break;
			case 6: Myapp.main(null);
			break;
			default :System.out.println("Incorrect Choice....");
			}
		}while(ch!=6);

		

	}

}
