package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "files-path")
public record FilesPathConfig(
    String pathToAddrObj,
    String pathToHierarchy
) {
}
