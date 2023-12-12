package com.hareket.web.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "S_MESSAGES", catalog = "HAREKET")
public class Message implements Serializable {

    @Id
    @Column(name = "LOGICALREF", columnDefinition = "INT", nullable = false, unique = true)
    private int logicalref;

    @Column(name = "APPREF", columnDefinition = "INT", nullable = false)
    private int appRef = 9;

    @Column(name = "ID", columnDefinition = "INT", nullable = false)
    private int id = 0;

    @Column(name = "TEXTID", columnDefinition = "NVARCHAR(150)", nullable = false)
    private String textId;

    @Column(name = "TR", columnDefinition = "NVARCHAR(MAX)", nullable = false)
    private String turkish;

    @Column(name = "EN", columnDefinition = "NVARCHAR(MAX)", nullable = false)
    private String english;


    public int getLogicalref() {
        return logicalref;
    }

    public void setLogicalref(int logicalref) {
        this.logicalref = logicalref;
    }

    public int getAppRef() {
        return appRef;
    }

    public void setAppRef(int appRef) {
        this.appRef = appRef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId;
    }

    public String getTurkish() {
        return turkish;
    }

    public void setTurkish(String turkish) {
        this.turkish = turkish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
