package com.shop.kong.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Catalog")
public class Catalog implements Serializable {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID catalogId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "catalog")
    private List<Catentry> catentries;
}