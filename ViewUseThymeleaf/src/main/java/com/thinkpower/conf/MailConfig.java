package com.thinkpower.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import springfox.documentation.spring.web.PropertySourcedMapping;



@Configuration
@PropertySource("classpath:mail2.properties")
public class MailConfig {
    @Value("${mail.host.port}")
    public String host;
   
    @Value("${mail.user.display_name}")
    public String userDisplayName;

    public String getHost() {
    	return host;
    }
    
}