package com.srccode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "srctable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String src;
}

