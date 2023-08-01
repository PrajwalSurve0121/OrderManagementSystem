package com.Dao;

import com.Entity.Item;

public interface ItemDao {
	
	public Item AddItem(Item i);
	public int DeleteItem(int id);
	public void UpdateItem(int id);
	public void DisplayAllItem();
	public Item SearchItemById(int id);
	
}
