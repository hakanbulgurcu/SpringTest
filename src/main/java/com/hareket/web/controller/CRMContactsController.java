package com.hareket.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.hareket.web.model.CRMContactPerson;
import com.hareket.web.services.CRMContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("session")
@Controller("contactsBean")
public class CRMContactsController {

	@Autowired
	private CRMContactPersonService contactPersonService;

	private CRMContactPerson selectedContact = new CRMContactPerson ();
	
    private List<CRMContactPerson> contactList = new ArrayList<CRMContactPerson>();
    private List<CRMContactPerson> filteredContacts = new ArrayList<CRMContactPerson>();
    
    @PostConstruct
    public void init() {
    		contactList = contactPersonService.findAll ();
    }
    
	public CRMContactPerson getSelectedContact() {
		return selectedContact;
	}

	public void setSelectedContact(CRMContactPerson selectedContact) {
		this.selectedContact = selectedContact;
	}

	public List<CRMContactPerson> getContactList() {
		return contactList;
	}

	public void setContactList(List<CRMContactPerson> contactList) {
		this.contactList = contactList;
	}

	public List<CRMContactPerson> getFilteredContacts() {
		return filteredContacts;
	}

	public void setFilteredContacts(List<CRMContactPerson> filteredContacts) {
		this.filteredContacts = filteredContacts;
	}
    
}