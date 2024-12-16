package com.shop.kong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.kong.entity.Catentry;

@Repository
public interface CatentryRepository extends JpaRepository<Catentry, String>{

}
