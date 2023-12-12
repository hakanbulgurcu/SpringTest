package com.hareket.web.services;

import com.hareket.web.model.CRMContactPerson;
import com.hareket.web.repository.CRMContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.utilities.ConstantTag;

import java.util.ArrayList;
import java.util.List;

@Service
public class CRMContactPersonService {

    @Autowired
    CRMContactPersonRepository crmContactPersonRepository;

    public CRMContactPerson findById(Integer id) {
        return crmContactPersonRepository.findById(id).get ();
    }

    public List<CRMContactPerson> findAll() {
        List<CRMContactPerson> list = new ArrayList<> ();
        crmContactPersonRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public CRMContactPerson save(CRMContactPerson contactPerson) {
        return crmContactPersonRepository.save (contactPerson);
    }

    public void delete(CRMContactPerson contactPerson) {
        crmContactPersonRepository.delete (contactPerson);
    }

    public void deleteById(Integer id) {
        crmContactPersonRepository.deleteById (id);
    }
}
