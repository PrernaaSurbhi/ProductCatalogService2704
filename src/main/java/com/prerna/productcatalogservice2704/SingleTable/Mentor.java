package com.prerna.productcatalogservice2704.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue(value = "Mentors")
@Entity(name = "st_mentors")
public class Mentor extends User {
    private String company;
}
