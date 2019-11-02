package com.yadu.example.demo.config;

import com.yadu.example.demo.until.SnowFlakeWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author 2019年4月12日13:51:18
 * 雪花算法配置
 */
@Configuration
public class SnowFlakeConfig {

    @Bean
    @Scope("singleton")
    public SnowFlakeWorker getIdWorker() {
        return new SnowFlakeWorker(0, 0);
    }
}
