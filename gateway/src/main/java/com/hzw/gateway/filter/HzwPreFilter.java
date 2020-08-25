package com.hzw.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: huangzuwang
 * @date: 2020-05-17 11:31
 * @description:
 */
@Slf4j
@RefreshScope
@Component
public class HzwPreFilter extends ZuulFilter {

    @Value("${my.name}")
    private String myName;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //越小越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //true执行run()，false不执行run()
        log.warn("Zuul HzwPreFilter > > > > > > > > shouldFilter()");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.warn("Zuul HzwPreFilter > > > > > > > > run()");

        log.warn("Zuul HzwPreFilter > > > > > > > > 配置刷新测试:" + myName);
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("Token");
        log.warn("Zuul HzwPreFilter > > > > > > > > Token:" + token);
        return null;
    }
}
