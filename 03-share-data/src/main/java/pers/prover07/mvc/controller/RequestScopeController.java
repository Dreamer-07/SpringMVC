package pers.prover07.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author by Prover07
 * @classname RequestScopeController
 * @description TODO
 * @date 2022/1/15 14:11
 */
@Controller
@RequestMapping("/scope/req")
public class RequestScopeController {

    /**
     * 通过 servlet api 向 request 域中共享数据
     *
     * @param request
     * @return
     */
    @GetMapping("/servletApi")
    public String byServletApi(HttpServletRequest request) {
        request.setAttribute("forServletApi", "byqtxdy");
        return "success";
    }

    @GetMapping("/mav")
    public ModelAndView byModelAndView() {
        ModelAndView mav = new ModelAndView();
        // 设置模型数据到 request 域中
        mav.addObject("forModelAndView", "hhhhh");
        // 设置视图名
        mav.setViewName("success");
        return mav;
    }

    @GetMapping("/model")
    public String byModel(Model model) {
        // 设置模型数据到 request 域中
        model.addAttribute("forModel", "tomoetyann");
        return "success";
    }

    @GetMapping("/map")
    public String byMap(Map<String, Object> dataMap) {
        dataMap.put("forMap", "通过 map 向 request 域中存储数据");
        return "success";
    }

    @GetMapping("/modelMap")
    public String byModelMap(ModelMap modelMap) {
        modelMap.addAttribute("forModelMap", "testForModelMap");
        return "success";
    }

}
