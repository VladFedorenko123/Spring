package com.srccode.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class ApplicationProperties {
    @Value("${memcache.ip}")
    public String ip;
    @Value("${memcache.port}")
    private int port;
}
