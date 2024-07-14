package ru.gb.vkr.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();
    }

    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        return new ConfigurationBasedServerList(config);
    }
}

