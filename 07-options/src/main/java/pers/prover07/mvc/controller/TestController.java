package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by Prover07
 * @classname TestController
 * @description TODO
 * @date 2022/1/21 12:07
 */
@Controller
public class TestController {

    @RequestMapping("/testInterceptor")
    @ResponseBody
    public String testInterceptor() {
        return "success";
    }
}
