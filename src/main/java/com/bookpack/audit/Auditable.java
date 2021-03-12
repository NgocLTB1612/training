package com.bookpack.audit;

import static javax.persistence.TemporalType.TIMESTAMP;



import java.util.Date;


import javax.persistence.*;


import org.springframework.data.annotation.CreatedBy;

import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.LastModifiedBy;

import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @Column(name = "created_by")
    @CreatedBy
    protected U createdBy;

    @Column(name = "created_date")
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;


    @Column(name = "last_modified_by")
    @LastModifiedBy
    protected U lastModifiedBy;


    @Column(name = "last_modified_date")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;



    public U getCreatedBy() {

        return createdBy;

    }



    public void setCreatedBy(U createdBy) {

        this.createdBy = createdBy;

    }



    public Date getCreatedDate() {

        return createdDate;

    }



    public void setCreatedDate(Date createdDate) {

        this.createdDate = createdDate;

    }



    public U getLastModifiedBy() {

        return lastModifiedBy;

    }



    public void setLastModifiedBy(U lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;

    }



    public Date getLastModifiedDate() {

        return lastModifiedDate;

    }



    public void setLastModifiedDate(Date lastModifiedDate) {

        this.lastModifiedDate = lastModifiedDate;

    }

}
