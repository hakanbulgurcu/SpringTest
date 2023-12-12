package com.hareket.web.services;

import com.hareket.web.model.Company;
import com.hareket.web.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company findById(Integer id) {
        return companyRepository.findById(id).get ();
    }

    public List<Company> findAll() {
        List<Company> list = new ArrayList<> ();
        companyRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Company save(Company company) {
        return companyRepository.save (company);
    }

    public void delete(Company company) {
        companyRepository.delete (company);
    }

    public void deleteById(Integer id) {
        companyRepository.deleteById (id);
    }

}
