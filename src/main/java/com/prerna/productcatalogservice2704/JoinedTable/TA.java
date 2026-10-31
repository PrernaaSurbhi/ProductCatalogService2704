package com.prerna.productcatalogservice2704.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name = "ta_id")
public class TA extends User {
    private Integer helpRequests;
}
