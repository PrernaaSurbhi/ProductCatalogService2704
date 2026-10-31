package com.prerna.productcatalogservice2704.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "st_instuctors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instuctor extends User {
    private Double ratings;
}
