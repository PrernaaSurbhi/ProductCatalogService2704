package com.prerna.productcatalogservice2704.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "tbc_mentors")
public class Mentor extends User{
    private String company;
}
