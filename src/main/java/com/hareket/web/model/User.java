package com.hareket.web.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "USERS", catalog = "HAREKET")
public class User implements Serializable {
	

	@Id
    @Column(name = "LOGICALREF", nullable = false, unique = true)
	private int logicalref;

    @Column(name = "CODE", columnDefinition = "VARCHAR(20)", nullable = false, length = 20, unique = true)    
    private String code;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(10)", nullable = false, length = 10)    
    private String password;

    @Column(name = "NAME", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)        
    private String name;    

    @Column(name = "DEPARTMENTREF", columnDefinition = "INT", nullable = false)    
    private int departmentRef;

    @Column(name = "TYP", columnDefinition = "INT", nullable = false)    
    private int typ;

    @Column(name = "STATUS", columnDefinition = "INT", nullable = false)    
    private int status;

    @Column(name = "AUTHCODE", columnDefinition = "INT", nullable = false)    
    private int authCode;

    @Column(name = "EMAIL", columnDefinition = "NVARCHAR(50)", nullable = true, length = 50)    
    private String email;
  
    @Column(name = "JGUARNR", columnDefinition = "INT", nullable = false)    
    private int jguarNr;

    @Column(name = "GROUPS", columnDefinition = "NVARCHAR(250)", nullable = false)        
    private String groups;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MANAGERREF", columnDefinition = "INT", nullable = false, referencedColumnName = "LOGICALREF")
    private User manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANYREF", columnDefinition = "INT", nullable = false, referencedColumnName = "LOGICALREF")
    private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="REGIONREF", columnDefinition = "INT", nullable = false, referencedColumnName = "LOGICALREF")
	private Region region;

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLogicalref() {
		return logicalref;
	}

	public void setLogicalref(int logicalref) {
		this.logicalref = logicalref;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAuthCode() {
		return authCode;
	}

	public void setAuthCode(int authCode) {
		this.authCode = authCode;
	}

	public int getJguarNr() {
		return jguarNr;
	}

	public void setJguarNr(int jguarNr) {
		this.jguarNr = jguarNr;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public int getDepartmentRef() {
		return departmentRef;
	}

	public void setDepartmentRef(int departmentRef) {
		this.departmentRef = departmentRef;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
