package com.sixlab.peixun.Home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Home")
public class HomeController {

    @RequestMapping("Index")
    public Map<String, Object> index() {
        HashMap<String, Object> hm = new HashMap<>();
        int a = 1 / 0;
        hm.put("msg", "ok");
        hm.put("code", 200);
        hm.put("url", "https://www.baidu.com");

        return hm;
    }

    @RequestMapping("Error")
    public Map<String, Object> error() {
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("msg", "error");
        hm.put("code", 400);
        hm.put("url", "/Home/Index");

        return hm;
    }

}
