package com.prerna.productcatalogservice2704.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_mentors")
@PrimaryKeyJoinColumn(name = "mentor_id")
public class Mentor extends User {
    private String company;
}
