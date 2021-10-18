package com.srccode.interfaces;

import java.io.IOException;

public interface Memcached {
    String mCache(String value) throws IOException;
}
