package com.prerna.productcatalogservice2704.MappedSuperClass;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "tbc_user")
@MappedSuperclass
public abstract class User {
    private String name;

    @Id
    private UUID id;
}
