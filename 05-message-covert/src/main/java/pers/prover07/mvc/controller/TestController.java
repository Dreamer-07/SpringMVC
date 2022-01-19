package pers.prover07.mvc.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.prover07.mvc.bean.User;

/**
 * @author by Prover07
 * @classname TestController
 * @description TODO
 * @date 2022/1/19 14:07
 */
@Controller
public class TestController {

    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String userInfo) {
        System.out.println(userInfo);
        return "success";
    }

    @PostMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("请求头:" + requestEntity.getHeaders());
        System.out.println("请求体:" + requestEntity.getBody());
        return "success";
    }

    @GetMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "byqtxdy";
    }

    @GetMapping("/testResponseBodyJson")
    @ResponseBody
    public User testResponseBodyJson() {
        return new User(1001, "巴御前", "天下第一");
    }

    @PostMapping("/testAjax")
    @ResponseBody
    public String testAjax(@RequestBody User user) {
        System.out.println(user);
        return "success";
    }

}
