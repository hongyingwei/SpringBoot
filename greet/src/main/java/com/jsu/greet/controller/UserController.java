package com.jsu.greet.controller;

import com.jsu.greet.entity.User;
import com.jsu.greet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller // 标识该类为Spring MVC中的handler
public class UserController {
    @Resource
    UserService service;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/login") // 标识url地址的
    public String doLogin(@Validated User u, BindingResult result,
                          Model m, RedirectAttributes a,
                          HttpSession sess) {
        System.out.println("u：" + u.toString());

        if (result.hasErrors()) {
            boolean reallyError = false;
            for (FieldError e1: result.getFieldErrors()) {
                if (!e1.getField().equals("password2")) {
                    System.out.println("FieldError：" + e1.getField());
                    System.out.println("ObjectName：" + e1.getObjectName());
                    reallyError = true;
                    a.addFlashAttribute(e1.getField() + "Err", e1.getDefaultMessage());
                }
            }

            if (reallyError)
                return "redirect:go_login";
        }

        if (service.checkUser(u)) {
//            a.addAttribute("username", u.getUsername());
            sess.setAttribute("username", u.getUsername());
            return "redirect:go_home";
        } else {
            m.addAttribute("msg", "登录失败");
            return "login";// 逻辑视图名
        }
    }

    @RequestMapping("/reg")
    public String doReg(@Validated User u, BindingResult result,
                          RedirectAttributes a) {
        System.out.println("u：" + u.toString());

        if (result.hasErrors()) {
            for (FieldError e1: result.getFieldErrors()) {
                System.out.println("FieldError：" + e1.getField());
                System.out.println("ObjectName：" + e1.getObjectName());
                a.addFlashAttribute(e1.getField() + "Err", e1.getDefaultMessage());
            }

            return "redirect:go_reg";
        }

        String msg = service.reg(u);
        if (null == msg) {
            a.addFlashAttribute("msg", "注册成功");
            return "redirect:go_login";
        } else {
            a.addFlashAttribute("msg", msg);
            return "redirect:go_reg";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession sess, RedirectAttributes a) {
        sess.invalidate();
        a.addFlashAttribute("msg", "请重新登录");
        return "redirect:go_login";
    }

    // redirect 过来的参数不要加 @ModelAttribute
    @GetMapping("/go_login")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/go_reg")
    public String goReg() {
        return "reg";
    }

    @GetMapping("/go_home")
    public String goHome(String username, Model m) {
        m.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/user/all")
    public String all(Model m) {
        List<User> users = service.findAllUsers();
        m.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/del_user/{id}")
    @ResponseBody
    public Boolean del(@PathVariable int id) {
        return service.del(id);
    }
}
