package com.fzu.meetsystem.aspect;

import com.fzu.meetsystem.tools.HttpTools;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
@Aspect
public class ControllerAspect {
    @Pointcut("execution( * com.fzu.meetsystem.controller.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Map<String,Object> getData(ProceedingJoinPoint jp){
        Log log = LogFactory.getLog(ControllerAspect.class);

        Map<String,Object> data = (Map<String, Object>) jp.getArgs()[0];
        HttpServletRequest httpReq = (HttpServletRequest) jp.getArgs()[1];

        if(data!=null)
            data= (Map<String, Object>) data.get("data");

        Object resp = null;
        try {
            resp = jp.proceed(new Object[]{data,httpReq,jp.getArgs()[2]});
        } catch (Throwable throwable) {
            log.error("Around失败");
            throwable.printStackTrace();
        }

        return HttpTools.buildSuccessResp(resp, httpReq.getRequestURI(),"success");
    }
}
