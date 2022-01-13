package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author by Prover07
 * @classname UserController
 * @description TODO
 * @date 2022/1/12 16:47
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(
            value = {"/home", "/test"},
            method = {RequestMethod.POST, RequestMethod.GET}
    )
    public String toUserHome() {
        return "/home";
    }

    @GetMapping(
            value = "/testRequestParamsAndHeader",
            params = {
                    "username", // 必须携带 username 参数
                    "!password", // 不能携带 password 参数
                    "age=7", // age 请求参数值必须为 7
                    "sex!=2" // sex 请求参数的值不能为 2
            },
            headers = {
                    "Host=localhost:8080" // Host 属性值必须为 localhost:8080
            }
    )
    public String testRequestParamsAndHeader() {
        return "/success";
    }

    @GetMapping("/testPathVariable/{id}/{username}")
    public String testPathVariable(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ", username:" + username);
        return "/success";
    }


}
