package com.smart.module.car.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 百度智能AI
 * @author znz
 */
@Data
@ConfigurationProperties(prefix = "bai-du")
public class BaiDuProperties {

    private String appId;
    private String apiKey;
    private String accessKeySecret;

}
