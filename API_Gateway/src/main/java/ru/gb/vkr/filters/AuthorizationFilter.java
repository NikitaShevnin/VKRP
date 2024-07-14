package ru.gb.vkr.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();

        // Логика авторизации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isUserAuthorized(authentication, ctx.getRequest())) {
            // Пользователь авторизован, продолжить обработку запроса
            return null;
        } else {
            // Если пользователь не авторизован, установить код ошибки 403 Forbidden
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
            ctx.setSendZuulResponse(false);
            return null;
        }
    }

    private boolean isUserAuthorized(Authentication authentication, HttpServletRequest request) {
        // Реализация логики проверки авторизации пользователя
        // Например, проверка наличия необходимых ролей или разрешений
        return true;
    }
}

