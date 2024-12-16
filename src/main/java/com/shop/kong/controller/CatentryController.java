package com.shop.kong.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shop.kong.entity.Catentry;

public interface CatentryController {
    ResponseEntity<List<Catentry>> listCatentry();
}
