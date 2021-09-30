package com.srccode.clas;

import com.srccode.dto.TextMySQLDTO;
import com.srccode.interfaces.Memcached;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;

@Service
public class MemcachedImplementation implements Memcached {
    private static final Logger logger = LoggerFactory.getLogger(MemcachedImplementation.class);

    @Override
    public String mCache(String value) {
        try {
            ApplicationPropertiesSingleton  applicationProperties = new ApplicationPropertiesSingleton();
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress(applicationProperties.ip, Integer.parseInt(applicationProperties.port)));
            logger.info("Connection to server successfully");
            logger.info("set status " + memcachedClient.set("key", 60, value).isDone());
            logger.info("add status " + memcachedClient.add("key", 60, value).isDone());
            logger.info("get from cache " + memcachedClient.get("key"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
