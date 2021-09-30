package com.hddz.will.mongodb.resource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.hddz.will.mongodb.resource.MyResource
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/20 16:29
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyResource {
}
