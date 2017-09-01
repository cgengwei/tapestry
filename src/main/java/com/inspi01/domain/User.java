/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package com.inspi01.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.inspi01.domain.base.AuditableObject;

/**
 * @author XINEN
 */
@Entity
@Table(name = "my_user")
public class User extends AuditableObject {

    private String name;

//    @Column(unique = true)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
