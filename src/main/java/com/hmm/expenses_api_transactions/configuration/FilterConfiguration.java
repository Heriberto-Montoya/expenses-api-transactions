package com.hmm.expenses_api_transactions.configuration;

import com.hmm.expenses_api_transactions.common.ratelimit.RateLimitingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
//    @Bean
//    public FilterRegistrationBean<RateLimitingFilter> rateLimitingFilter() {
//        FilterRegistrationBean<RateLimitingFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new RateLimitingFilter());
//        registrationBean.addUrlPatterns("/api/*"); // Register filter for API endpoints
//        return registrationBean;
//    }
}
