package com.srccode.clas;

import com.srccode.dto.TextMySQLDTO;
import com.srccode.interfaces.Memcached;
import com.srccode.interfaces.MySQLTextRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"sql"})
public class SpringMemcache implements Memcached {
    @Autowired
    private MySQLTextRepository mySQLTextRepository;

    @Override
    @Cacheable(value = "newString")
    public String mCache(String newString) {
        return newString;
    }
}
