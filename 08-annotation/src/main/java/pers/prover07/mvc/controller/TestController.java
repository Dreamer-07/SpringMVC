package pers.prover07.mvc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author by Prover07
 * @classname TestController
 * @description TODO
 * @date 2022/1/25 14:22
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String testIndex(){
        return "index";
    }

}
