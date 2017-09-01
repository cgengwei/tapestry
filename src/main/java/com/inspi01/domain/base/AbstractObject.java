/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package com.inspi01.domain.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * 所有实体类的基类
 *
 * @author XINEN
 */
@MappedSuperclass
//@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public abstract class AbstractObject implements Serializable {

    private static final long serialVersionUID = 8078550144051485413L;

    @Id
    @GeneratedValue(generator = "UUIDGen")
    @GenericGenerator(name = "UUIDGen", strategy = "uuid")
    @Column(name = "id", unique = true, length = 32, nullable = false)
    private String id = null;

    /**
     * default constructor
     */
    protected AbstractObject() {
        super();
    }

    /**
     * init the entity with id.
     *
     * @param id
     */
    protected AbstractObject(String id) {
        this();
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.jpa.domain.AbstractObject#getId()
     */
    public String getId() {

        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.jpa.domain.AbstractObject#setId(String)
     */
    public void setId(String id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.inspireso.framework.jpa.domain.AbstractObject#isNew()
     */
    @JsonIgnore
    public boolean isNew() {
        return StringUtils.isEmpty(getId());

    }

    /*
     * transfor the @see java.util.Date to @see org.joda.time.DateTime
     */
    public DateTime toDateTime(final Date date) {
        return null == date ? null : new DateTime(date);
    }

    /*
     * transfor the @see org.joda.time.DateTime to @see java.util.Date
     */
    public Date toDate(final DateTime datetime) {
        return null == datetime ? null : datetime.toDate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractObject)) {
            return false;
        }
        final AbstractObject that = (AbstractObject) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.toStringHelper().toString();

    }

    /**
     * 用于获取该对象的字符串表示形式，子类可通过重写此方法来更好地表述该对象。 使用方法为
     * {@code super.toStringHelper().add("propertyName", propertyValue);}
     */
    protected ToStringHelper toStringHelper() {
        return Objects.toStringHelper(this.getClass()).add("id", this.getId());

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

    /**
     * copy property from source;
     */
    protected void copy(final AbstractObject source) {
        this.id = source.id;
    }
}
