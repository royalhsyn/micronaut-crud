package com.example.filter;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

@Filter("/**")
@Slf4j
public class LoggingFilter implements HttpFilter {
    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
        log.info("Handling incoming request: {}, {}", request.getUri(), request.getMethodName());
        return chain.proceed(request);
    }
}
