package ru.gb.vkr.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    @Autowired
    private IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

    @Bean
    public ConfigurationBasedServerList configurationBasedServerList() {
        return new ConfigurationBasedServerList();
    }
}
