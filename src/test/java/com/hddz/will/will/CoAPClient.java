package com.hddz.will.will;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.elements.exception.ConnectorException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * com.hddz.will.will.Client
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/20 14:29
 */
public class CoAPClient {

    @Test
    public void client() throws URISyntaxException, ConnectorException, IOException {
        var uri = new URI("localhost:5683/time?a=a");
        var client = new CoapClient(uri);
        var response = client.get();
        if(!Objects.isNull(response)){
            System.out.println(Utils.prettyPrint(response));
        }
    }
}
