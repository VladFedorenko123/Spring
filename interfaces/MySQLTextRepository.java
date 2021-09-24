package com.srccode.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.srccode.dto.TextMySQLDTO;

@Repository
public interface MySQLTextRepository extends CrudRepository<TextMySQLDTO, Integer> {
    TextMySQLDTO findBySrc(String src);
}
