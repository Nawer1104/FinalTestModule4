package com.example.finaltestmodule4.service.impl;

import com.example.finaltestmodule4.model.National;
import com.example.finaltestmodule4.repository.INationalRepository;
import com.example.finaltestmodule4.service.INationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalServiceImpl implements INationalService {
    @Autowired
    INationalRepository nationalRepository;

    @Override
    public List<National> findAll() {
        return nationalRepository.findAll();
    }
}
