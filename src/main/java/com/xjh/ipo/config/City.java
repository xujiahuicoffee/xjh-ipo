package com.xjh.ipo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xujiahui
 * @ClassName City
 * @description: 自定义注解
 * @time 2023/7/27 16:51
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface City {
    String provinve() default "浙江";
}
