package com.srccode.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "srctable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String src;
}
