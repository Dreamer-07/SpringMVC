package pers.prover07.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author by Prover07
 * @classname CustomExceptionHandler
 * @description TODO
 * @date 2022/1/25 11:43
 */
// 扩展 Spring 组件
@ControllerAdvice
public class CustomExceptionHandler {

    // @ExceptionHandler 表示来处理的异常
    @ExceptionHandler({ ArithmeticException.class, NullPointerException.class })
    // 通过设置形参 Exception; Spring MVC 会帮助我们将异常对象注入进来
    public String handleArithmeticException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }

}
