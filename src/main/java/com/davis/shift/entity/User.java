package com.davis.shift.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="user_")
@Where(clause="deleted_at is null")
public class User extends BaseEntity implements Serializable{
    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 100,unique = true)
    private String email;

    @Column(length = 100,nullable = false)
    private String password;

    @Column(length = 32)
    private String organizeId;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}