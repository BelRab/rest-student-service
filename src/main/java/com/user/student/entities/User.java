package com.user.student.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // TABLE 'USER' AND TABLE 'STUDENT'
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // JE VAIS VOIR ÇA APRÉS , SI JE PEUX CHANGER VERS IDENTITY
	@Column // TO DELETE HIBERNATE SEQUENCE I MUST ADD STRATEGY TO IDENTITY
	private int id;
	@Column
	private long telefone;

	public User() {
	}

	public User(long telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the telefone
	 */
	public long getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
}
