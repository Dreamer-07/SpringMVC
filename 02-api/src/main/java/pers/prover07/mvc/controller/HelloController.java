package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author by Prover07
 * @classname HelloController
 * @description TODO
 * @date 2022/1/12 16:29
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String toIndex() {
        return "index";
    }

}
