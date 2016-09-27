package com.gesac.pojo;

public class Employee {
	private int eid;
	private String enumber,ename,ejob,edepart,etele,ephone,email;
	public Employee(int eid, String enumber, String ename, String ejob, String edepart, String etele, String ephone,
			String email) {
		super();
		this.eid = eid;
		this.enumber = enumber;
		this.ename = ename;
		this.ejob = ejob;
		this.edepart = edepart;
		this.etele = etele;
		this.ephone = ephone;
		this.email = email;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEnumber() {
		return enumber;
	}
	public void setEnumber(String enumber) {
		this.enumber = enumber;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEjob() {
		return ejob;
	}
	public void setEjob(String ejob) {
		this.ejob = ejob;
	}
	public String getEdepart() {
		return edepart;
	}
	public void setEdepart(String edepart) {
		this.edepart = edepart;
	}
	public String getEtele() {
		return etele;
	}
	public void setEtele(String etele) {
		this.etele = etele;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
