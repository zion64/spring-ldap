package com.zeiv.emp.domain;

// Generated 2014. 5. 4 오전 11:41:31 by Hibernate Tools 3.4.0.CR1

/**
 * Departments generated by hbm2java
 */
public class Departments implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 4783481547749377357L;
	private String	deptNo;
	private String	deptName;

	public Departments() {
	}

	public Departments(String deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
