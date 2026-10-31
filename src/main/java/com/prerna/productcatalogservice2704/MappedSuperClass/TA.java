package com.prerna.productcatalogservice2704.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "tbc_tas")
public class TA  extends User{
    private Integer helpRequests;
}
