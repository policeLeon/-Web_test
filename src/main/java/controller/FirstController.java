package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.c_course;


@Controller
public class FirstController {
    //设置当前方法的访问映射地址
    @RequestMapping("/firstController")
    public String sayHello() {
        System.out.println("访问到FirstController！");
        //具体跳转页面
        return "succes";
    }

}
