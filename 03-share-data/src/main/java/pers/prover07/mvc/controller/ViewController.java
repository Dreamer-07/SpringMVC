package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author by Prover07
 * @classname ViewController
 * @description TODO
 * @date 2022/1/16 9:52
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/thymeleaf")
    public String testThymeleafView() {
        return "success";
    }

    @GetMapping("/forward")
    public String testInternalResourceView() {
        return "forward:view/thymeleaf";
    }

    @GetMapping("/redirect")
    public String testRedirectView() {
        return "redirect:http://www.baidu.com";
    }

}
