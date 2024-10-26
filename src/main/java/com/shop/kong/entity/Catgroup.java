package com.shop.kong.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Catgroup")
public class Catgroup implements Serializable {
    @Id
    @Column(name = "catgroup_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID catgroupId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
