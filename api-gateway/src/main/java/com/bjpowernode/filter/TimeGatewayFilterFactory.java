package com.bjpowernode.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Component
/**
 * 局部过滤器的命名方式
 * 后缀必须为GatewayFilterFactory
 * 父类AbstractGatewayFilterFactory<>是泛型的，需要指定配置类
 */
public class TimeGatewayFilterFactory extends AbstractGatewayFilterFactory<TimeGatewayFilterFactory.Config> {
    public TimeGatewayFilterFactory(){
        super(TimeGatewayFilterFactory.Config.class);
    }

    //读取配置文件参数，赋值到对应关系的配置类变量的代码
    public List<String> shortcutFieldOrder(){
        return Arrays.asList("show");
    }

    /**
     * 生成过滤器
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            /**
             * 过滤器的方法实现
             * @param exchange    request与response
             * @param chain  过滤器链
             * @return
             */
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if(!config.show){
                    /**
                     * 调用过滤器连的下一个过滤器
                     */
                    return chain.filter(exchange);
                }
                long begin = new Date().getTime();
                exchange.getAttributes().put("begintime",begin);
                return chain.filter(exchange).then(Mono.fromRunnable(()->{
                    Long begintime = exchange.getAttribute("begintime");
                    long end = new Date().getTime();
                    System.out.println(exchange.getRequest().getURI()+"请求耗时"+(end-begintime));
                }));
            }
        };
    }

    @Getter
    @Setter
    static class Config{
        private boolean show;

    }

}
