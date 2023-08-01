package com.Entity;

public class Item {

	private int itemid;
	private String itemname;
	private float cost;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int itemid, String itemname, float cost) {
		this.itemid = itemid;
		this.itemname = itemname;
		this.cost = cost;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", cost=" + cost + "]";
	}
	
	
	
}
