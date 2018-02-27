package com.seecen.controller;

import com.seecen.entity.Page;
import com.seecen.entity.User;
import com.seecen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by jessann on 2018/2/26.
 */
@Controller
@RequestMapping("user")
public class UserContoller {
    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public String list(Integer currentPage, User user, Model model){
        Page page = new Page();
        page.setPageSize(3);
        if (currentPage!=null){
            page.setCurrentPage(currentPage);
        }
        User u = new User();
        u.setUserName(user.getUserName());
        page = userService.findUserByPage(page,user);
        model.addAttribute("page",page);
        model.addAttribute("u",u);
        return "/user/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "/user/add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addPost(User user, RedirectAttributes redirectAttributes){
        if( userService.addUser(user)){
            redirectAttributes.addFlashAttribute("msg","新增成功");
        }else {
            redirectAttributes.addFlashAttribute("msg","新增失败");
        }

        return "redirect:/user/list";
    }
    @RequestMapping("delete")
    public String delete(Integer userId,RedirectAttributes redirectAttributes){
        User user = new User();
        if(userService.delete(userId)){
            redirectAttributes.addFlashAttribute("msg","删除成功");
        }else {
            redirectAttributes.addFlashAttribute("msg","删除失败");
        }
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String select(Integer userId,Model model){
        User user = new User();
        user= userService.select(userId);
        model.addAttribute("user",user);
        return "/user/update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(User user,RedirectAttributes redirectAttributes){
        if(userService.update(user)){
            redirectAttributes.addFlashAttribute("msg","更新成功");
        }else{
            redirectAttributes.addFlashAttribute("msg","更新失败");
        }
        return "redirect:/user/list";
    }
}
