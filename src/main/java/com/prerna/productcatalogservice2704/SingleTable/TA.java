package com.prerna.productcatalogservice2704.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("TA")
@Entity(name = "st_tas")
public class TA extends User {
    private Integer helpRequests;
}
