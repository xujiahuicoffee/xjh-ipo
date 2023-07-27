package com.xjh.ipo.config;

import com.xjh.ipo.request.HelloWorldRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author xujiahui
 * @ClassName CityCheckAop
 * @description: AOP
 * @time 2023/7/27 17:09
 */
@Aspect
@Component
public class CityCheckAop {

    @Pointcut("@annotation(com.xjh.ipo.config.City)")
    public void annotation() {
    }

    @Pointcut("execution(* com.xjh.ipo.controller.*.say*(..))")
    public void execute() {

    }

    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = methodSignature.getParameterNames();
        for (String paramName : paramNames) {
            System.out.println("参数名称：" + paramName);
        }

        // 根据joinPoint获取参数，通过强转的形式转换为具体的类型
        HelloWorldRequest request = (HelloWorldRequest) joinPoint.getArgs()[0];
        // 通过反射获取Field，再获取Field上的City注解
        Class clazz = request.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            City city;
            for (Field field : fields) {
                if ((city = field.getAnnotation(City.class)) != null) {
                    System.out.println(city.provinve());
                }
            }
        }

        System.out.println(request.getCity());
    }

}
