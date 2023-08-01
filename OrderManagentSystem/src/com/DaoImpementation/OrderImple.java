package com.DaoImpementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.Connect.DBConnect;
import com.Dao.CustomerDao;
import com.Dao.OrderDao;
import com.Entity.Customer;
import com.Entity.Order;

public class OrderImple implements OrderDao {

	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	Order o = new Order();

	static Scanner sc = new Scanner(System.in);

	public OrderImple() {
		conn = DBConnect.getConnect();
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void AddOrder(Order c) {

		System.out.println("Enter the Order id: ");
		o.setOrderid(sc.nextInt());
		System.out.println("Enter the Customer id: ");
		o.setCustid(sc.nextInt());
		System.out.println("Enter the Item id: ");
		o.setItemid(sc.nextInt());
		System.out.println("Enter the Quantity : ");
		o.setQuantity(sc.nextInt());
		System.out.println("Enter the Order Status : ");
		o.setOrderstatus(sc.next());
		System.out.println("Enter the Order payment status : ");
		o.setPaymentstatus(sc.next());

		try {
			st = conn.createStatement();
			float cost = 0;
			rs = st.executeQuery("select * from item");
			while (rs.next()) {
				int id = rs.getInt(1);
				if (o.getItemid() == id) {
					cost = rs.getFloat(3);
					System.out.println(cost);
				}
			}
			pst = conn.prepareStatement("insert into orderinfo values(?,?,?,?,?,?,?)");
			pst.setInt(1, o.getOrderid());
			pst.setInt(2, o.getCustid());
			pst.setInt(3, o.getItemid());
			pst.setInt(4, o.getQuantity());
			float Cost1 = o.getQuantity() * cost;
			pst.setFloat(5, Cost1);
			pst.setString(6, o.getOrderstatus());
			pst.setString(7, o.getPaymentstatus());

			int noOfRowsAdded = pst.executeUpdate();
			if (noOfRowsAdded > 0) {
				System.out.println("Order Added Sucessfully..........");
			} else {
				System.out.println("Error........");
			}
		} catch (SQLException e) {
			System.out.println(e);

		}

	}

	@Override
	public void DeleteOrder(int oid) {
		System.out.println("Enter order id to delete Order");
		oid = sc.nextInt();

		try {
			pst = conn.prepareStatement("delete from orderinfo where orderid=?");
			pst.setInt(1, oid);

			if (pst.executeUpdate() > 0) {
				System.out.println("Order Deleted Sucessfully.............");
			} else {
				System.out.println("Error.............");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	@Override
	public void UpdateOrder(int oid) {
		
		try {
			
			o=SearchOrderById(oid);
			if(o!=null)
			{
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-Display Old Order Details=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println(o);
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("Enter New Quantity");
				int quant=sc.nextInt();
				pst=conn.prepareStatement("update orderinfo set quantity=? where orderid=?");
				pst.setInt(2, quant);
				pst.setInt(1, oid);
				
				int noOfRowsUpdated=pst.executeUpdate();
				if(noOfRowsUpdated>0)
				{
					System.out.println("Rows Are Updated Sucessufully........");
				}
				else
				{
					System.out.println("Error......");
				}
				
			}
			else
			{
				System.out.println("Order Dose Not Exist...........");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	@Override
	public void DisplayAllOrder() {

		try {
			rs = st.executeQuery("select * from orderinfo");
			System.out.println(
					"==-=---=-=-=-=-=-=-=---=-=---=-==-=-=-Order List is Here==-=-=-=-=-=-=-=-=-=-=-=-=---=-=-=-=-=-");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
						+ rs.getFloat(5) + " " + rs.getString(6) + " " + rs.getString(7));
			}
			System.out.println(
					"==========---------------==============-----------===========------------=============---------");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public Order SearchOrderById(int oid) {
		try {
			if (o != null) {
				pst = conn.prepareStatement("select * from orderinfo where orderid=?");
				pst.setInt(1, oid);

				rs = pst.executeQuery();
				if (rs.next()) {
					o.setOrderid(rs.getInt(1));
					o.setCustid(rs.getInt(2));
					o.setItemid(rs.getInt(3));
					o.setQuantity(rs.getInt(4));
					o.setTotaolcost(rs.getFloat(5));
					o.setOrderstatus(rs.getNString(6));
					o.setPaymentstatus(rs.getString(7));
					return o;
				}
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

}
