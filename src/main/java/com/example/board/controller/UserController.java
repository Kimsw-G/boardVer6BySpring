package com.example.board.controller;

import com.example.board.model.ParamVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping("/user/*")
@Controller
public class UserController implements HandlerInterceptor {

    private final String TEMPLATE = "template";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    private void templeUtil(Model model,String title, String page){
        model.addAttribute("title",title);
        model.addAttribute("page",page);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String viewLogin(Model model){
        templeUtil(model,"로그인","user/login");
        return TEMPLATE;
    }



    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String viewJoin(Model model){
        templeUtil(model,"회원가입","user/join");
        return TEMPLATE;
    }

    @ResponseBody
    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public ParamVO postJoin(@RequestBody ParamVO params){
        System.out.println(params.getUid());
        ParamVO vo = new ParamVO();
        vo.setUid("kkk");
        vo.setUnm("bbb");
        vo.setGender(1);
        vo.setUpw("badf");
        return vo;
    }

}
