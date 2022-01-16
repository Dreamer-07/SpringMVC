package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author by Prover07
 * @classname RouterController
 * @description TODO
 * @date 2022/1/15 13:47
 */
@Controller
public class RouterController {

    //@GetMapping({"/", "/index"})
    //public String routeIndex() {
    //    return "index";
    //}

    @GetMapping("/testView")
    public String routeTestView() {
        return "view";
    }

}
