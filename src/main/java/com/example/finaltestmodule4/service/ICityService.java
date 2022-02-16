package com.example.finaltestmodule4.service;

import com.example.finaltestmodule4.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    void save(City city);
    void delete(Long id);
    City findById(Long id);
}
