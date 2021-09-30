package com.hddz.will.mongodb.resource;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * com.hddz.will.mongodb.resource.TimeResource
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/20 16:27
 */
@MyResource
public class TimeResource extends CoapResource {
    public TimeResource() {
        super("time");
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        var param = exchange.getQueryParameter("a");
        System.out.println(param);
        var time = LocalDateTime.now();
        var str = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        exchange.respond(CoAP.ResponseCode.CONTENT, str);
    }
}
