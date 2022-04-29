package com.arodriguezbravo.nttdata.bootcamp.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 9)
	private String name;
	
	private String firstName;
	
	@Column(nullable = false, length = 9)
	private String lastName;
	
	@Column(nullable = false, length = 9, unique = true)
	private String dni;
	
	
	private Date createAt;

	
	public Cliente(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public Cliente() {
		
	}
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName + ", dni="
				+ dni + ", createAt=" + createAt + "]";
	}

	
	
	

}
