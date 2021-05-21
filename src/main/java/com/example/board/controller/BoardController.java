package com.example.board.controller;

import com.example.board.dao.BoardDAO;
import com.example.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    BoardDAO boardDAO;

    private final String TEMPLATE = "template";

    private void templeUtil(Model model, String title, String page){
        model.addAttribute("title",title);
        model.addAttribute("page",page);
    }

    @RequestMapping("/list")
    public String hello(Model model,
                        @RequestParam(value = "page",defaultValue = "1") int page){
        int pageKey = (page-1)*3;

        List<BoardVO> list = boardDAO.selectBoardList(pageKey);

        model.addAttribute("list",list);
        model.addAttribute("totalPage",boardDAO.getPageCnt());
        templeUtil(model,"리스트","board/list");
        return TEMPLATE;
    }

    @RequestMapping("/search")
    public String searchBoard(Model model){
        System.out.println(boardDAO.getPageCnt());

        return "";
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String showBoard(Model model,
                            BoardVO param){

        templeUtil(model,"게시글","board/detail");
        return TEMPLATE;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public String ajaxDetail(Model model,
                            @RequestBody Map<String,Object> params){
        System.out.println(params.get("ibaord"));

        return "";
    }
}
