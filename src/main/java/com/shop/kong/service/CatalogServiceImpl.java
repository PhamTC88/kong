package com.shop.kong.service;

import com.shop.kong.entity.Catalog;
import com.shop.kong.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public List<Catalog> listCatalogs() {
        List<Catalog> listCatalogs = catalogRepository.findAll();
        return listCatalogs;
    }
}
