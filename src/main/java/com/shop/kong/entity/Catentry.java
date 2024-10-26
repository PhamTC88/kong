package com.shop.kong.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Catentry")
public class Catentry implements Serializable {
    @Id
    @Column(name = "catentry_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID catentryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    @OneToMany(mappedBy = "catentry")
    private List<Product> products;
}
