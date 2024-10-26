package com.shop.kong.controller;

import com.shop.kong.entity.Catalog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatalogController {
    ResponseEntity<List<Catalog>> listCatalogs();
}
