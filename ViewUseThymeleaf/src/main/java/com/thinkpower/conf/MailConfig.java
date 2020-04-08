package com.thinkpower.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {
    @Value("${mail.host}")
    public String host;
   
    @Value("${mail.user.display_name}")
    public String userDisplayName;

    
}