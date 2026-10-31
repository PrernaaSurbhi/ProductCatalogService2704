package com.prerna.productcatalogservice2704.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "msc_tas")
public class TA  extends User{
    private Integer helpRequests;
}
