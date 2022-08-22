package com.dcy.web.admin;


import com.dcy.po.FriendLink;
import com.dcy.service.FriendLinkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class FriendController {

    @Autowired
    private FriendLinkService friendLinkService;


    //查询所有友链
    @GetMapping("/friendlinks")
    public String friend(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,5);

        List<FriendLink> friendLinkList = friendLinkService.listFriendLink();

        PageInfo<FriendLink> pageInfo = new PageInfo<>(friendLinkList);

        model.addAttribute("pageInfo",pageInfo);

        return "admin/friendlinks";
    }

    //跳转友链新增页面


    @GetMapping("/friendlinks/input")
    public String input(Model model){

        model.addAttribute("friendlink",new FriendLink());

        return "admin/friendlinks-input";
    }


    //新增友链
    @PostMapping("/friendlinks")
    public String post(FriendLink friendLink, RedirectAttributes attributes, BindingResult result){


        System.out.println("控制进来了！！！！");
        FriendLink type1 =friendLinkService.getFriendLinkByBlogaddress(friendLink.getBlogaddress());


        if (type1 != null){

            attributes.addFlashAttribute("message","不能添加相同的友链");

            return "redirect:/admin/friendlinks/input";
        }

        if (result.hasErrors()){

            return "admin/friendlinks-input";
        }

        friendLink.setCreateTime(new Date());

        int b = friendLinkService.saveFriendLink(friendLink);

        if (b == 0){

            attributes.addFlashAttribute("message","新增失败！");
        }else {

            attributes.addFlashAttribute("message","新增成功！");
        }

        return "redirect:/admin/friendlinks";
    }

    //跳转编辑页面

    @GetMapping("/friendlinks/{id}/input")
    public String editInput(@PathVariable Long id,Model model){

        model.addAttribute("friendlink",friendLinkService.getFriendLink(id));

        return "admin/friendlinks-input";
    }

    //编辑友链
    @PostMapping("/friendlinks/{id}")
    public String editPost(FriendLink friendLink,RedirectAttributes attributes){

        int a = friendLinkService.updateFriendLink(friendLink);

        if (a == 0){

            attributes.addFlashAttribute("messages","编辑失败！");
        }else {

            attributes.addFlashAttribute("message","编辑成功！");
        }


        return "redirect:/admin/friendlinks";
    }


    //删除友链
    @GetMapping("/friendlinks/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){

        friendLinkService.deleteFriendLink(id);

        attributes.addFlashAttribute("message","删除成功！！");

        return "redirect:/admin/friendlinks";
    }


}
