package com.philomath.security.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example")
public class ConsulConfig {
    String name;
    String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}