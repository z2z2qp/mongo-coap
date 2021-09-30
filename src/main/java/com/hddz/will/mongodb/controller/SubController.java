package com.hddz.will.mongodb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hddz.will.mongodb.mode.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * com.hddz.will.mongodb.controller.SubController
 *
 * @author Zhuang Jiabin
 * @version V1.0.0
 * @since 2020/8/25 15:15
 */
@RestController
@RequestMapping("api/device")
public class SubController {

    private static final Logger log = LoggerFactory.getLogger(SubController.class);

    @PostMapping("send")
    public HttpResult<String> devSend(@RequestBody Map<String, Object> param) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(param);
            log.info(str);
        } catch (JsonProcessingException e) {
            log.warn("", e);
        }
        return new HttpResult<>(200, "ok", "");
    }

    @PostMapping("change")
    public HttpResult<String> change(@RequestBody Map<String, Object> param) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(param);
            log.info(str);
        } catch (JsonProcessingException e) {
            log.warn("", e);
        }
        return new HttpResult<>(200, "ok", "");
    }

    @PostMapping("ctrl")
    public HttpResult<String> ctrl(@RequestBody Map<String, Object> param) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(param);
            log.info(str);
        } catch (JsonProcessingException e) {
            log.warn("", e);
        }
        return new HttpResult<>(200, "ok", "");
    }

    @PostMapping("online")
    public HttpResult<String> online(@RequestBody Map<String, Object> param) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String str = mapper.writeValueAsString(param);
            log.info(str);
        } catch (JsonProcessingException e) {
            log.warn("", e);
        }
        return new HttpResult<>(200, "ok", "");
    }

    @PostMapping("addDevice")
    public ResponseEntity<Object> post(@RequestBody Map<String, Object> param) {
        log.info("{}", param);
        return new ResponseEntity<>(param, HttpStatus.OK);
    }

    @DeleteMapping("delDevice/{pk}/{devId}")
    public ResponseEntity<Object> delete(@PathVariable String pk, @PathVariable String devId) {
        log.info("{},{}", pk, devId);
        return new ResponseEntity<>(pk + devId, HttpStatus.OK);
    }

    @PutMapping("updateName")
    public ResponseEntity<Object> put(@RequestBody Map<String, Object> param) {
        log.info("{}", param);
        return new ResponseEntity<>(param, HttpStatus.OK);
    }
}
