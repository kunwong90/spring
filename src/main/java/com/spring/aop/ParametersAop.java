package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.stream.Stream;

@Component
@Aspect
public class ParametersAop {

    /**
     * 判断方法入参对象是否实现了序列化接口,如果未实现Serializable接口则报错
     * @param jp
     */
    @Before("execution(* com.spring.service..*.*(..))")
    public void isSerializableParam(JoinPoint jp) {
        Object[] args = jp.getArgs();
        if (args != null && args.length > 0) {
            Stream.of(args).forEach((object) -> {
                if (!(object instanceof Serializable)) {
                    throw new RuntimeException("入参必须实现序列化接口!");
                }
            });
        }
    }
}
