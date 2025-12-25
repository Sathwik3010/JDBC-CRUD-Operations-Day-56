package com.codegnan.model;

public class Teacher {

    private int tno;          // maps to TNO (AUTO_INCREMENT)
    private String tname;     // maps to TNAME
    private double tsal;   // maps to TSAL
    private String taddr;  // maps to TADDR
	public Teacher(int tno, String tname, double tsal, String taddr) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tsal = tsal;
		this.taddr = taddr;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public double getTsal() {
		return tsal;
	}
	public void setTsal(double tsal) {
		this.tsal = tsal;
	}
	public String getTaddr() {
		return taddr;
	}
	public void setTaddr(String taddr) {
		this.taddr = taddr;
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", tsal=" + tsal + ", taddr=" + taddr + "]";
	}

    
}
