package com.abinash.eCommerce.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@Getter
//@Setter
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private String createdBy;
    private String updatedBy;
}
