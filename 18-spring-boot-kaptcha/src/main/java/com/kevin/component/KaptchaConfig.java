package com.kevin.component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/17
 */
@Configuration
public class KaptchaConfig {

    @Value("${kevin.kaptcha.border}")
    private String border;
    //@Value("${kevin.kaptcha.border.color}")
    private String color="red";
    @Value("${kevin.kaptcha.session.key}")
    private String key;
    @Value("${kevin.kaptcha.noise.color}")
    private String noiseColor;
    @Value("${kevin.kaptcha.image.width}")
    private String width;
    @Value("${kevin.kaptcha.image.height}")
    private String height;
    @Value("${kevin.kaptcha.textproducer.char.length}")
    private String charLength;
    @Value("${kevin.kaptcha.textproducer.char.space}")
    private String charSpace;
    @Value("${kevin.kaptcha.textproducer.font.color}")
    private String fontColor;
    @Value("${kevin.kaptcha.textproducer.font.size}")
    private String fontSize;
    @Value("${kevin.kaptcha.textproducer.font.names}")
    private String fontNames;

    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border",border);
        properties.setProperty("kaptcha.border.color",color);
        properties.setProperty("kaptcha.session.key",key);
        properties.setProperty("kaptcha.noise.color",noiseColor);
        properties.setProperty("kaptcha.image.width",width);
        properties.setProperty("kaptcha.image.height",height);
        properties.setProperty("kaptcha.textproducer.char.length",charLength);
        properties.setProperty("kaptcha.textproducer.char.space",charSpace);
        properties.setProperty("kaptcha.textproducer.font.color",fontColor);
        properties.setProperty("kaptcha.textproducer.font.size",fontSize);
        properties.setProperty("kaptcha.textproducer.font.names",fontNames);
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
