package com.shop.kong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.kong.entity.Catentry;
import com.shop.kong.repositories.CatentryRepository;

@Service
public class CatentryServiceImpl implements CatentryService {

    @Autowired
    private CatentryRepository catentryRepository;

    @Override
    public List<Catentry> listCatentry() {
        return catentryRepository.findAll();
    }
}
