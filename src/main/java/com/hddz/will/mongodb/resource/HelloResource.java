package com.hddz.will.mongodb.resource;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * com.hddz.will.mongodb.resource.HelloResource
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/20 16:26
 */
@MyResource
public class HelloResource extends CoapResource {

    public HelloResource(){
        super("hello");
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(CoAP.ResponseCode.CONTENT, "hello");
    }
}
