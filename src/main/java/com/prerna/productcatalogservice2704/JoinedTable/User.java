package com.prerna.productcatalogservice2704.JoinedTable;

import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "jt_user")
@Inheritance(strategy =  InheritanceType.JOINED)
public class User {
    private String name;

    @Id
    private UUID id;
}
