package com.srccode.dto;

import com.srccode.clas.MemcachedImplementation;
import com.srccode.interfaces.Memcached;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.IOException;
import java.net.InetSocketAddress;

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
