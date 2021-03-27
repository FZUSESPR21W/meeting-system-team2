package com.fzu.meetsystem.aspect;

import com.fzu.meetsystem.tools.HttpTools;
import nonapi.io.github.classgraph.utils.Join;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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


        HttpServletRequest httpReq = (HttpServletRequest) jp.getArgs()[1];

        Object resp = null;
        String msg="success";
        try {
            resp = jp.proceed(new Object[]{jp.getArgs()[0],httpReq,jp.getArgs()[2]});
        } catch (Throwable throwable) {
            log.error("Around失败");
            throwable.printStackTrace();
        }
        if(resp!=null){
            if(((Map)resp).get("_msg")!=null){
                msg= (String) ((Map)resp).get("_msg");
                ((Map)resp).remove("_msg");
            }
        }

        return HttpTools.buildSuccessResp(resp, httpReq.getRequestURI(),msg);
    }
}
