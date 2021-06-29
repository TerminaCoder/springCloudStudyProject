package com.example.demo.module.test.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author created by LiuXF on 2021/04/29 17:03:25
 */
@Service
public class TestService {

    @SentinelResource(value = "/serviceGet", blockHandler = "blockHandler")
    public String serviceGet(String name) {
        return "1";
    }

    /**
     * 根据Sentinel中（对资源名）的配置（流控/降级）来进行处理<br>
     * 当达到Sentinel中配置的条件阈值时将会调用（如：单位时间内超过流量限制，单位时间内超过异常数量的限制）
     *
     * @param name 被控制的方法的参数
     * @param e    断流的异常，参数必须加，不加这个参数即使达到了断流条件也不会执行
     * @return
     */
    public String blockHandler(String name, BlockException e) {
        return "超过了Sentinel中的设置，被断流了。。。" + name + " " + e.getMessage();
    }


    /**
     * 处理java代码中的异常，不管有没有达到Sentinel中的配置<br>
     * 只要java代码中出现异常就会调用，如果断流的方法被调用，则这个方法不被调用
     *
     * @param name 被控制的方法的参数
     * @param e    代码中抛出的异常，这个参数是可选的
     * @return
     */
    public String fallBack(String name, Throwable e) {
        System.err.println("Java代码有异常：" + e.getMessage());
        return "业务方法中出现异常: " + name + " -> " + e.getMessage();
    }
}
