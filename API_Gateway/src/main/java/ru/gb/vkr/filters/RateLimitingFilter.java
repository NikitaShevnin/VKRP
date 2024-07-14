package ru.gb.vkr.filters;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RateLimitingFilter extends ZuulFilter {

    private static final RateLimiter rateLimiter = RateLimiter.create(100.0); // Ограничение 100 запросов в секунду

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // Логика ограничения скорости
        if (!rateLimiter.tryAcquire()) {
            // Если превышен лимит запросов, установить код ошибки 429 Too Many Requests
            ctx.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            ctx.setSendZuulResponse(false);
        }

        return null;
    }
}


