package com.hareket.web.repository;

import com.hareket.web.model.CRMContactPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRMContactPersonRepository extends CrudRepository<CRMContactPerson, Integer> {

}
