package com.springBoot;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Employees")
@EntityListeners(AuditingEntityListener.class)
public class employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //too doo 
	private int id;
	@GeneratedValue(strategy = GenerationType.AUTO) //too doo 
	private int age;
	@NotBlank
	private String name;
	@NotBlank
	private String gental;
	@NotBlank
	private String description;
	@NotBlank
	private String expertise;
	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGental() {
		return gental;
	}
	public void setGental(String gental) {
		this.gental = gental;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String  getExpertise() {
		// TODO Auto-generated method stub
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

}
