package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author by Prover07
 * @classname SessionScopeController
 * @description TODO
 * @date 2022/1/16 0:11
 */
@Controller
@RequestMapping("/scope/session")
public class SessionScopeController {

    @GetMapping("/servletApi")
    public String byServletApi(HttpSession session) {
        session.setAttribute("testByServletApi", "session data");
        return "success";
    }

}
