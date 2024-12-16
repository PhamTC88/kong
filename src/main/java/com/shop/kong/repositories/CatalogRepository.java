package com.shop.kong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.kong.entity.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, String> {
}
