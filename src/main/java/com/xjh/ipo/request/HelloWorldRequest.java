package com.xjh.ipo.request;

import com.xjh.ipo.config.City;
import lombok.Data;

/**
 * @author xujiahui
 * @ClassName HelloWorldRequest
 * @description: TODO
 * @time 2023/7/27 16:41
 */
@Data
public class HelloWorldRequest {

    @City(provinve = "江苏")
    public String city;

}
