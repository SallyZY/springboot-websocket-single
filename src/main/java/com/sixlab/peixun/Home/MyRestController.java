package com.sixlab.peixun.Home;

import com.sixlab.peixun.entity.MyUser;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yingzhang on 12/04/2020.
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {

    @RequestMapping(value="/getUser",method = RequestMethod.GET)
    public MyUser getUser(){

        MyUser user=new MyUser();
        user.setName("testname");
        user.setPassword("123456");
        user.setAge(26);

        return user;
    }

    @RequestMapping(value="/getName",method = RequestMethod.GET)
    public String setName(@RequestParam("name1") String myName1,@RequestParam("name2") String myName2){
        return "Hello: "+myName1 + " and "+myName2;
    }


//  post请求的body
//{
//    "name": "123",
//        "age": 12,
//        "password": "456"
//}
    @PostMapping("/setUser")
    public MyUser setUser(@RequestBody MyUser user){

        return user;
    }
}
