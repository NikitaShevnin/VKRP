package ru.gb.vkr.filters;

import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Component
public class AuthenticationFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        // Логика аутентификации
        if (isUserAuthenticated(request)) {
            // Установить аутентифицированного пользователя в контексте безопасности
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(request));
        } else {
            // Если пользователь не прошел аутентификацию, установить код ошибки 401 Unauthorized
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setSendZuulResponse(false);
        }

        return null;
    }

    private boolean isUserAuthenticated(HttpServletRequest request) {
        // Реализация логики проверки аутентификации пользователя
        // Например, проверка наличия JWT-токена в заголовках запроса
        return true;
    }

    private Authentication getAuthentication(HttpServletRequest request) {
        // Реализация логики получения аутентифицированного пользователя
        // Например, декодирование и проверка JWT-токена
        return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
    }
}
