package com.gesac.pojo;

public class Relation {
	private int rid;
	private int leader, staff;
	public Relation(int rid, int leader, int staff) {
		super();
		this.rid = rid;
		this.leader = leader;
		this.staff = staff;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getLeader() {
		return leader;
	}
	public void setLeader(int leader) {
		this.leader = leader;
	}
	public int getStaff() {
		return staff;
	}
	public void setStaff(int staff) {
		this.staff = staff;
	}
	
	

}
