package com.hareket.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the S_REGIONS database table.
 * 
 */
@Entity
@Table(name="S_REGIONS", catalog = "HAREKET")
public class Region implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOGICALREF", columnDefinition = "INT", unique = true, nullable = false)
	private int logicalref;

	@Column(name = "CODE", columnDefinition = "NVARCHAR(25)", nullable = false)
	private String code;

	@Column(name = "DESCRIPTION", columnDefinition = "NVARCHAR(100)", nullable = false)
	private String description;

	@Column(name = "STATUS", columnDefinition = "INT", nullable = false)
	private int status;

	public Region() {
		
	}

	public int getLogicalref() {
		return this.logicalref;
	}

	public void setLogicalref(int logicalref) {
		this.logicalref = logicalref;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}