package com.user.student.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Student extends User implements Serializable {

	private String name;
	private String lastname;
	private String email;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long telefone) {
		super(telefone);
		// TODO Auto-generated constructor stub
	}

	public Student(long telefone, String name, String lastname, String email) {
		super(telefone);
		this.name = name;
		this.lastname = lastname;
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
