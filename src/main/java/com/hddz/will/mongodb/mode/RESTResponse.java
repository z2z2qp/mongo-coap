package com.hddz.will.mongodb.mode;

/**
 * com.hddz.will.mongodb.mode.RESTResponse
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/9/9 8:54
 */
public class RESTResponse <T> {

    public final int Code;
    public final String Message;

    public final T Response;

    public RESTResponse(int Code, String Message, T Response) {

        this.Code = Code;
        this.Response = Response;
        this.Message = Message;
    }

    public static <V> RESTResponse<V> of(V Response) {

        return new RESTResponse<>(0, null, Response);
    }

    public static <V> RESTResponse<V> of(int Code, String Message) {

        return new RESTResponse<>(Code, Message, null);
    }


    public String get() {
        return toString();
    }
}