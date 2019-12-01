package zuul.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 * pre：路由之前
 * routing：路由之时
 * post： 路由之后
 * error：发送错误调用
 * filterOrder：过滤的顺序
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 *
 * 过程分析：在请求到达时，会首先交给zuulServlet，（service方法处理）其中zuulServlet中包含zuulRunner对象，该对象中初始化了RequestContext,而ReuqesrContext中
 * 则是包含了请求信息，他们被所有的zuulFilter共享，有了这些filter,
 * 他们会首先执行“pre”类型的过滤器，
 * 然后再执行“roouter”类型的过滤器，
 * 最后执行“post”类型的过滤器
 * 如果在执行这些过滤器的过程中发生错误，会转为执行error过滤器，执行完这些过滤器之后，再将结果返回给客户端
 */
@Component
public class ZulFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ZulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        if(request.getParameter("token") == null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
    }
}
