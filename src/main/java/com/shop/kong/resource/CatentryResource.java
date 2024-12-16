package com.shop.kong.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.kong.config.AppConfig;
import com.shop.kong.controller.CatentryController;
import com.shop.kong.entity.Catentry;
import com.shop.kong.service.CatentryService;

@RestController
@RequestMapping(path = CatentryResource.API_SOURCE_CATENTRIES)
public class CatentryResource implements CatentryController{
    public static final String API_SOURCE_CATENTRIES = AppConfig.API_SOURCE + "/catentries";

    @Autowired
    private CatentryService catentryService;

    @Override
    @GetMapping
    public ResponseEntity<List<Catentry>> listCatentry() {
        return ResponseEntity.ok(catentryService.listCatentry());
    }
}
