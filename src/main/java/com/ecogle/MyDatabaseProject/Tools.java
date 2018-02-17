package com.ecogle.MyDatabaseProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TOOLS")
public class Tools {
	
	@Id
	@SequenceGenerator(name="t_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="t_seq")
	@Column(name="ID")
	private Long id;
	
	@Column(name="TOOL_NAME")
	private String toolName;
	
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getToolName() {
		return toolName;
	}


	public void setToolName(String toolName) {
		this.toolName = toolName;
	}


	
	
	
}
