package com.srccode.clas;

import com.srccode.Application;
import com.srccode.interfaces.Memcached;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class MemcachedImplementation implements Memcached {
    private static final Logger logger = LoggerFactory.getLogger(MemcachedImplementation.class);

    public void mCache(String key, String value) {
        try {
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("localhost", 12345));
            logger.info("Connection to server successfully");
            logger.info("set status " + memcachedClient.set(key, 60, value).isDone());
            logger.info("add status " + memcachedClient.add(key, 60, value).isDone());
            logger.info("get from cache " + memcachedClient.get(key));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
