package com.hareket.web.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "S_COMPANIES", catalog = "HAREKET")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOGICALREF")
	private int logicalref;
    
    @Column(name = "CODE", columnDefinition = "NVARCHAR(50)", nullable = false, length = 50)    
	private String code;
    
    @Column(name = "DESCRIPTION", columnDefinition = "NVARCHAR(150)", nullable = false, length = 150)    
	private String description;
    
    @Column(name = "STATUS", columnDefinition = "INT", nullable = false) 
	private int status;

	public int getLogicalref() {
		return logicalref;
	}

	public void setLogicalref(int logicalref) {
		this.logicalref = logicalref;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
