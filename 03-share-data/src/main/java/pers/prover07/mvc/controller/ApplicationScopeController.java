package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @author by Prover07
 * @classname ApplicationScopeController
 * @description TODO
 * @date 2022/1/16 0:20
 */
@Controller
@RequestMapping("/scope/application")
public class ApplicationScopeController {

    @GetMapping("/servletApi")
    public String byServletApi(HttpSession session) {
        // 通过 session 获取上下文对象
        ServletContext application = session.getServletContext();
        application.setAttribute("testByServletApi", "application data");
        return "success";
    }

}
