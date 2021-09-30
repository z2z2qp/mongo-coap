package com.hddz.will.mongodb.service;

import com.hddz.will.mongodb.resource.HelloResource;
import com.hddz.will.mongodb.resource.MyResource;
import com.hddz.will.mongodb.resource.TimeResource;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.data.util.CastUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * 优雅的启动 coap 服务
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020 /8/20 16:14
 */
@Component
public class COAPService implements ApplicationRunner, ApplicationListener<ContextClosedEvent> {
    private static final Logger log = LoggerFactory.getLogger(COAPService.class);
    private CoapServer server;

    /**
     * 初始化 server
     */
    @PostConstruct
    public void init() {
        server = new CoapServer();
        Reflections refs = new Reflections("com.hddz.will.mongodb.resource");
        for(Class<?> clazz : refs.getTypesAnnotatedWith(MyResource.class)){
            try {
                CoapResource resource = CastUtils.cast(clazz.getDeclaredConstructor().newInstance());
                server.add(resource);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                log.warn("loop resource error:{}",e.getMessage());
            }
        }
        // server.add(new HelloResource());
        // server.add(new TimeResource());
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!Objects.isNull(server)) {
           server.start();
        }
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        if (!Objects.isNull(server)) {
            server.stop();
        }
    }
}
