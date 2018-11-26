package com.zuulservice.getwayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreRequestLogFliter extends ZuulFilter{

    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFliter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，不同的过滤器允许返回相同的数字.
     * @return
     */
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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        PreRequestLogFliter.LOGGER.info(String.format("send %s request %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
