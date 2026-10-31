package com.prerna.productcatalogservice2704.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "msc_instuctors")
public class Instuctor extends User {
    private Double ratings;
}
