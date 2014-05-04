package com.zeiv.emp.domain;

import java.util.Date;


// Generated 2014. 5. 4 오전 12:17:16 by Hibernate Tools 4.0.0

/**
 * EmployeesAllAttrView generated by hbm2java
 */
public class EmployeesAllAttrView implements java.io.Serializable {
	private static final long	serialVersionUID	= 2390500838402398499L;

	private int		empNo;
	private String	firstName;
	private String	lastName;
	private String	gender;
	private Date	hireDate;
	private Date	birthDate;
	private String	deptNo;
	private Date	deptFromDate;
	private Date	deptToDate;
	private String	title;
	private Date	titleFromDate;
	private Date	titleToDate;

	public EmployeesAllAttrView() {
	}

	public EmployeesAllAttrView(int empNo, String firstName, String lastName, String gender, Date hireDate, Date birthDate,
			String deptNo, Date deptFromDate, Date deptToDate, String title, Date titleFromDate) {
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
		this.birthDate = birthDate;
		this.deptNo = deptNo;
		this.deptFromDate = deptFromDate;
		this.deptToDate = deptToDate;
		this.title = title;
		this.titleFromDate = titleFromDate;
	}

	public EmployeesAllAttrView(int empNo, String firstName, String lastName, String gender, Date hireDate, Date birthDate,
			String deptNo, Date deptFromDate, Date deptToDate, String title, Date titleFromDate, Date titleToDate) {
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
		this.birthDate = birthDate;
		this.deptNo = deptNo;
		this.deptFromDate = deptFromDate;
		this.deptToDate = deptToDate;
		this.title = title;
		this.titleFromDate = titleFromDate;
		this.titleToDate = titleToDate;
	}

	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public Date getDeptFromDate() {
		return this.deptFromDate;
	}

	public void setDeptFromDate(Date deptFromDate) {
		this.deptFromDate = deptFromDate;
	}

	public Date getDeptToDate() {
		return this.deptToDate;
	}

	public void setDeptToDate(Date deptToDate) {
		this.deptToDate = deptToDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTitleFromDate() {
		return this.titleFromDate;
	}

	public void setTitleFromDate(Date titleFromDate) {
		this.titleFromDate = titleFromDate;
	}

	public Date getTitleToDate() {
		return this.titleToDate;
	}

	public void setTitleToDate(Date titleToDate) {
		this.titleToDate = titleToDate;
	}
}
