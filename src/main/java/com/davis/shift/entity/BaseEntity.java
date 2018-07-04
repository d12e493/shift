package com.davis.shift.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable{
    @Id
    @GenericGenerator(name = "gen_id", strategy = "com.davis.shift.util.IdGenerator")
    @GeneratedValue(generator = "gen_id")
    @Column(length = 32)
    private String id;

    @Column(name="status")
    private int status;

    @Column(name="created_user_id",length = 32)
    @JsonIgnore
    private String createdUserId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Calendar createdAt;

    @Column(name="updated_user_id",length = 32)
    @JsonIgnore
    private String updatedUserId;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Calendar updatedAt;

    @JsonIgnore
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deletedAt;
}
