package com.prerna.productcatalogservice2704.SingleTable;

import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "st_user")
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="user_type" ,discriminatorType = DiscriminatorType.STRING)
public class User {
    private String name;

    @Id
    private UUID id;
}
