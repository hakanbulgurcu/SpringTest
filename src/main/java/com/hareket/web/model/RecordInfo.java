package com.hareket.web.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable 
@Access(AccessType.FIELD)
public class RecordInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CREATEDBY", columnDefinition = "INT", nullable = false, referencedColumnName = "LOGICALREF")
	private User createdBy;
	
    @Column(name = "CREATEDDATE", columnDefinition = "DATETIME", nullable = false)  
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MODIFIEDBY", columnDefinition = "INT", nullable = true, referencedColumnName = "LOGICALREF")
	private User modifiedBy;

    @Column(name = "MODIFIEDDATE", columnDefinition = "DATETIME", nullable = false)    
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modifiedDate;

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
