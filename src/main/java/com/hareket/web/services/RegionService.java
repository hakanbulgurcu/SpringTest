package com.hareket.web.services;

import com.hareket.web.model.Region;
import com.hareket.web.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    public Region findById(Integer id) {
        return regionRepository.findById(id).get ();
    }

    public List<Region> findAll() {
        List<Region> list = new ArrayList<> ();
        regionRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Region save(Region region) {
        return regionRepository.save (region);
    }

    public void delete(Region region) {
        regionRepository.delete (region);
    }

    public void deleteById(Integer id) {
        regionRepository.deleteById (id);
    }

}
