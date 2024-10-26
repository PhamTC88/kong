package com.shop.kong.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "Catalog")
public class Catalog {
    @Id
    @UuidGenerator
    @Column(name = "catalog_id")
    private String catalogId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
