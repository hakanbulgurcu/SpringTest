package com.hareket.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CRMContactPerson
 *
 */
@Entity
@Table(name = "CRM_CONTACTPERSON", catalog = "HAREKET")
public class CRMContactPerson implements Serializable {
	
	private static final long serialVersionUID = -150177844621179242L;

	@Id
    @Column(name = "LOGICALREF", nullable = false, unique = true)
	private int logicalref;
	
    @Column(name = "CODE", columnDefinition = "NVARCHAR(10)", nullable = false, length = 10)    
	private String code;
    
    @Column(name = "NAME", columnDefinition = "NVARCHAR(100)", nullable = false, length = 100)    
	private String name;
    
    @Column(name = "TITLE", columnDefinition = "NVARCHAR(100)", nullable = false, length = 100)    
	private String title;

    @Column(name = "POSITION", columnDefinition = "NVARCHAR(100)", nullable = false, length = 100)    
	private String position;
    
    @Column(name = "ARPREF", columnDefinition = "INT", nullable = false)    
	private int arpRef;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANYREF", columnDefinition = "INT", nullable = false, referencedColumnName = "LOGICALREF")
    private Company company;
	
    @Column(name = "REGION", columnDefinition = "NVARCHAR(20)", nullable = false, length = 20)    
	private String region;

    @Column(name = "GENEXP", columnDefinition = "NVARCHAR(MAX)", nullable = false)    
	private String genExp;

    @Column(name = "STATUS", columnDefinition = "INT", nullable = false)    
	private int status;
	
	@Embedded
	private RecordInfo recordInfo;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getArpRef() {
		return arpRef;
	}

	public void setArpRef(int arpRef) {
		this.arpRef = arpRef;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RecordInfo getRecordInfo() {
		return recordInfo;
	}

	public void setRecordInfo(RecordInfo recordInfo) {
		this.recordInfo = recordInfo;
	}

	public String getGenExp() {
		return genExp;
	}

	public void setGenExp(String genExp) {
		this.genExp = genExp;
	}

	@Override
	public String toString() {
		return "CRMContactPerson [logicalref=" + logicalref + ", code=" + code + ", name=" + name + ", title=" + title
				+ ", position=" + position + ", arpRef=" + arpRef + ", company=" + company + ", region=" + region
				+ ", genExp=" + genExp + ", status=" + status + ", recordInfo=" + recordInfo + "]";
	}
	
}
