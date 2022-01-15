package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.prover07.mvc.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author by Prover07
 * @classname ParamController
 * @description TODO
 * @date 2022/1/13 18:53
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @GetMapping
    public String route() {
        return "param";
    }

    @GetMapping("/testServletApi")
    public String testServletApi(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "-" + password);
        return "success";
    }

    @GetMapping("/testParam")
    public String testParam(String username, String password, String[] hobby) {
        // 对于请求参数中的同名多个值，可以用 String(每个值之间用,分割) / String[] 接收
        System.out.println(username + "-" + password + "-" + Arrays.toString(hobby));
        return "success";
    }

    @GetMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "user_name", defaultValue = "byqtxdy") String username,
            @RequestParam(defaultValue = "123456") String password
    ) {
        System.out.println(username + "-" + password);
        return "success";
    }

    @PostMapping("/testPoJO")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
