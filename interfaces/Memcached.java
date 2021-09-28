package com.srccode.interfaces;

import net.spy.memcached.MemcachedClient;

public interface Memcached {
    void mCache(String key, String value);
}
