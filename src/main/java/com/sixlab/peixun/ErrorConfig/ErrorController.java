package com.sixlab.peixun.ErrorConfig;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> ErrorConfig(){
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("msg", "error");
        hm.put("code", 400);
        hm.put("url", "None");

        return hm;
    }

}
