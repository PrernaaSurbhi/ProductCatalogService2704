package com.prerna.productcatalogservice2704.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue(value = "Instuctors")
@Entity(name = "st_instuctors")
public class Instuctor extends User {
    private Double ratings;
}
