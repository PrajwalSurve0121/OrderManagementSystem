package com.DaoImpementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.Connect.DBConnect;
import com.Dao.ItemDao;
import com.Entity.Item;

public class ItemImple implements ItemDao {
	
	Connection con=null;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	static Scanner sc=new Scanner(System.in);
	Item it=new Item();
	
	
	public ItemImple()
	{
		con=DBConnect.getConnect();
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public Item AddItem(Item i) {
		
		System.out.println("Enter Item ID");
		it.setItemid(sc.nextInt());
		System.out.println("Enter Item Name");
		it.setItemname(sc.next());
		System.out.println("Enter Item Cost");
		it.setCost(sc.nextFloat());
		
		try {
			pst=con.prepareStatement("insert into item value(?,?,?)");
			pst.setInt(1, it.getItemid());
			pst.setString(2, it.getItemname());
			pst.setFloat(3, it.getCost());
			
			int noRowAdded=pst.executeUpdate();
			if(noRowAdded>0)
			{
				System.out.println("Item Added Sucessfully");
			}
			else
			{
				System.out.println("Error......");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int DeleteItem(int id) {
		System.out.println("Enter Item Id to to Delete item");
		id=sc.nextInt();
		try {
			pst=con.prepareStatement("delete from item where itemid=?");
			pst.setInt(1, id);
			
			int noOfRowsDeleted=pst.executeUpdate();
			if(noOfRowsDeleted>0)
			{
				System.out.println("Item Deleted Sucessfully.......");
			}
			else
			{
				System.out.println("Error....");
			}
		} catch (SQLException e) {

			System.out.println(e);	
		}
		return id;
	}

	@Override
	public void UpdateItem(int id) {
		
		try {
			Item it=new Item();
			it=SearchItemById(id);
//			System.out.println(it.getItemid());
			if(it!=null)
			{
				System.out.println("........................Item Old Details Are:...................");
				System.out.println(it);
				System.out.println("........................************************...................");
				
				System.out.println("Enter new Item Cost");
				float cost=sc.nextFloat();
				pst=con.prepareStatement("update item set cost=? where itemid=?");
				pst.setFloat(1, cost);
				pst.setInt(2, id);
				int noOfRowUpdated=pst.executeUpdate();
				if(noOfRowUpdated>0)
				{
					System.out.println("Item Updated Sucessfully.....");
				}
				else
				{
					System.out.println("Error.....");
				}
			}
			else
			{
				System.out.println("Item Does Not Exist");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void DisplayAllItem() {
		
		try {
			rs=st.executeQuery("select * from item");
			System.out.println("==-=---=-=-=-=-=-=-=---=-=---=-==-=-=-Item List is Here==-=-=-=-=-=-=-=-=-=-=-=-=---=-=-=-=-=-");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
			}
			System.out.println("==========---------------==============-----------===========------------=============---------"); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	
	}

	@Override
	public Item SearchItemById(int id) {
		
		try
		{
			if(it!=null)
			{
				pst=con.prepareStatement("select * from item where itemid=?");
				pst.setInt(1, id);
				
				rs=pst.executeQuery();
				if(rs.next())
				{
					it.setItemid(rs.getInt(1));
					it.setItemname(rs.getString(2));
					it.setCost(rs.getFloat(3));
					return it;
					
				}
			}
			else
			{
				System.out.println("No Item with this id exists.........");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}

	

}
