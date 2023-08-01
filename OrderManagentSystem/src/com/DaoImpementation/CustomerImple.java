package com.DaoImpementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.Connect.DBConnect;
import com.Dao.CustomerDao;
import com.Entity.Customer;

public class CustomerImple implements CustomerDao {

	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	static Scanner sc = new Scanner(System.in);

	public CustomerImple() {
		conn = DBConnect.getConnect();
		System.out.println("Connection is Done............");
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void AddCustomer(Customer c) {

		try {
			pst = conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			pst.setInt(1, c.getCid());
			pst.setString(2, c.getFname());
			pst.setString(3, c.getLname());
			pst.setLong(4, c.getMobno());
			pst.setString(5, c.getEamil());
			pst.setString(6, c.getAddress());

			int noOfRowsAdded = pst.executeUpdate();
			if (noOfRowsAdded > 0) {
				System.out.println("Customer Added Sucessfully.........");
			} else {
				System.out.println("Error......");
			}

		} catch (SQLException e) {

			System.out.println(e);

		}

	}

	@Override
	public void DeleteCustomer(int cid) {

		try {
			pst = conn.prepareStatement("delete from customer where customerID=?");
			pst.setInt(1, cid);
			int noOfRowsDeleted = pst.executeUpdate();
			if (noOfRowsDeleted > 0) {
				System.out.println("Customer Deleted Sucessfully...");
			} else {
				System.out.println("Error.......");
			}
		} catch (SQLException e) {

			System.out.println(e);
		}

	}

	@Override
	public void UpdateCustomer(int cid) {


		try {
			Customer c=new Customer();
			c=SearchCustomerById(cid);
//			String s="select * from customer";
//			rs=pst.executeQuery(s);
			
			if(c!=null)
			{
				System.out.println("........................Customer Old Details Are:...................");
				System.out.println(c);
				System.out.println("........................************************...................");
				System.out.println("Enter new Moblie Number");
				Long mno=sc.nextLong();
				pst=conn.prepareStatement("update customer set mobileNo=? where customerId=?");
				pst.setLong(1, mno);
				pst.setInt(2, cid);
				
				int noOfRowsUpdated=pst.executeUpdate();
				if(noOfRowsUpdated>0)
				{
					System.out.println("Updated Sucessfully.......");
				}
				else
				{
					System.out.println("Error...");
				}
				


			}
			else
			{
				System.out.println("Customer Does Not Exist");
			}
			
			
		} 
		catch (SQLException e) 
		{
			System.out.println(e); 
		}

	}

	@Override
	public void DisplayAllCustomer() {
		
		try {
			rs=st.executeQuery("Select * from Customer");
			System.out.println("-=-=----=-=--=-=---=-=-=-=-=-=-All Customer List=-=-=-=-=-=-=-=-==-=-=-=------=-=--=-=-=-=-=-");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong(4)+" "+rs.getString(5)+" "+rs.getNString(6)); 
			}
			System.out.println("==========---------------==============-----------===========------------=============---------"); 
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
			

	}

	@Override
	public Customer SearchCustomerById(int cid) {
		
		try {
			pst=conn.prepareStatement("select * from customer where customerid=?");
			pst.setInt(1, cid);
			
			rs=pst.executeQuery();
			if(rs.next())
			{
				Customer c=new Customer();
				c.setCid(rs.getInt(1));
				c.setFname(rs.getString(2));
				c.setLname(rs.getString(3));
				c.setMobno(rs.getLong(4));
				c.setEamil(rs.getString(5));
				c.setAddress(rs.getString(6));
				return c;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

}
