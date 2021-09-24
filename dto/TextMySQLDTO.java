package com.srccode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "srctable")
public class TextMySQLDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String src;
}
