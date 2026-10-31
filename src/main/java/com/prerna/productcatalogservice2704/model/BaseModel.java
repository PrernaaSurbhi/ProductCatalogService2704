package com.prerna.productcatalogservice2704.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

// we are making this class as abstract , since we don't want to create object of this class .
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Date createdAt; //store data in epoch format-> HW
    private Date lastUpdatedAt;
    private State state;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public State getState() {
        return state;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public void setState(State state) {
        this.state = state;
    }
}
