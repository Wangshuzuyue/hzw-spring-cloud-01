package com.hzw.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: huangzuwang
 * @date: 2020-05-17 11:31
 * @description:
 */
@Slf4j
@Component
public class HzwPre2Filter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //越小越先执行
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //true执行run()，false不执行run()
        log.warn("Zuul HzwPre2Filter > > > > > > > > shouldFilter()");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.warn("Zuul HzwPre2Filter > > > > > > > > run()");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("Token");
        log.warn("Zuul HzwPre2Filter > > > > > > > > Token:" + token);
        return null;
    }
}
