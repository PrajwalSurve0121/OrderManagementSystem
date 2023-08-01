package com.Dao;

import com.Entity.Order;

public interface OrderDao {
	
	public void AddOrder(Order c);
	public void DeleteOrder(int oid);
	public void UpdateOrder(int oid);
	public void DisplayAllOrder();
	public Order SearchOrderById(int oid);
	
}
