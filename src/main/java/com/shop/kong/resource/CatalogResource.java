package com.shop.kong.resource;

import com.shop.kong.config.AppConfig;
import com.shop.kong.controller.CatalogController;
import com.shop.kong.entity.Catalog;
import com.shop.kong.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = CatalogResource.API_SOURCE_CATALOGS)
public class CatalogResource implements CatalogController {
    public static final String API_SOURCE_CATALOGS = AppConfig.API_SOURCE + "/catalogs";

    @Autowired
    private CatalogService catalogService;

    @Override
    @GetMapping
    public ResponseEntity<List<Catalog>> listCatalogs() {
        return ResponseEntity.ok(catalogService.listCatalogs());
    }
}
