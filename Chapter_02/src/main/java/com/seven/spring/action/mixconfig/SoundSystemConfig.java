package com.seven.spring.action.mixconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayerConfig.class) //将两个配置类结合在一起
@ImportResource("classpath:META-INF/mixconfig/cd-config.xml") //将配置文件和配置类结合在一起
public class SoundSystemConfig {

}
