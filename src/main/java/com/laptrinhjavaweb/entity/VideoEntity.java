package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class VideoEntity extends BaseEntity{
    @Column
    private String title;
    @Column
    private String link;
}
