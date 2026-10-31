package com.prerna.productcatalogservice2704.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "tbc_instuctors")
public class Instuctor extends User{
    private Double ratings;
}
