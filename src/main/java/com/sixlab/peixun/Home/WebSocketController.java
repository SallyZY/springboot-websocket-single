package com.sixlab.peixun.Home;

import com.sixlab.peixun.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WebSocketController {

    @Autowired
    private SocketServer socketServer;

    /**
     *
     * 客户端页面
     * @return
     */
    @RequestMapping(value = "/chat")
    public String idnex() {

        return "chat";
    }

    /**
     *
     * 服务端页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin1")
    public String admin(Model model) {
        int num = socketServer.getOnlineNum();
        List<String> list = socketServer.getOnlineUsers();
        System.out.print("number=");
        System.out.println(num);
        System.out.print("users=");
        for (String user : list){
            System.out.println(user);
        }


        model.addAttribute("num",num);
        model.addAttribute("users",list);
        return "admin1";
    }

    /**
     * 个人信息推送
     * @return
     */
    @RequestMapping("sendmsg")
    @ResponseBody
    public String sendmsg(String msg, String username){
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的用户人数
        String [] persons = username.split(",");
        SocketServer.SendMany(msg,persons);
        return "success";
    }

    /**
     * 推送给所有在线用户
     * @return
     */
    @RequestMapping("sendAll")
    @ResponseBody
    public String sendAll(String msg){
        SocketServer.sendAll(msg);
        return "success";
    }
}
