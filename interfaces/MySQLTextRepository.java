package com.srccode.interfaces;

import com.srccode.dto.TextMySQLDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLTextRepository extends CrudRepository<TextMySQLDTO, Integer> {
    TextMySQLDTO findBySrc(String src);
}
