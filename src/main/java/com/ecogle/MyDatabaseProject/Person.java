package com.ecogle.MyDatabaseProject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PEOPLE")
public class Person {
	
	

	@Id
	@SequenceGenerator(name="p_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="p_seq")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name = "MIDDLE_INIT")
	private String mInitial;
	
	@Column(name="PRIMARY_EMAIL")
	private String primaryEmail;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "PEOPLE_FK")
	private List<Tools> tools;
	
	public List<Tools> getTools() {
		return tools;
	}
	public void setTools(List<Tools> tools) {
		this.tools = tools;
	}

	
	
	public Person(Builder b){
		this.firstName = b.fName;
		this.lastName = b.lName;
		this.mInitial = b.mInit;
		this.primaryEmail = b.email;
	}
	public Person(){
		
	}
	public static class Builder{
		private String fName;
		private String lName;
		private String mInit;
		private String email;
		
		public Builder firstName(String s){
			this.fName = s;
			return this;
		}
		public Builder lastName(String s){
			this.lName = s;
			return this;
		}
		public Builder mInit(String s){
			this.mInit = s;
			return this;
		}
		public Builder emailAddress(String s){
			this.email = s;
			return this;
		}
		public Person build(){
			return new Person(this);
		}
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

	public String getmInitial() {
		return mInitial;
	}

	public void setmInitial(String mInitial) {
		this.mInitial = mInitial;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString(){
		return this.firstName + " " + this.lastName + "  " + this.primaryEmail;
	}

	
}
