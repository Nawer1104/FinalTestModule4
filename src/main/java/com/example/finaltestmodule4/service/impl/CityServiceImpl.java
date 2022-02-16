package com.example.finaltestmodule4.service.impl;

import com.example.finaltestmodule4.model.City;
import com.example.finaltestmodule4.repository.ICityRepository;
import com.example.finaltestmodule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    ICityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.getById(id);
    }
}
