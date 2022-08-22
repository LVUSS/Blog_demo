package com.dcy.web.admin;


import com.dcy.po.Picture;
import com.dcy.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PictureController {

    @Autowired
    private PictureService pictureService;



    //查询照片墙

    @GetMapping("/pictures")
    public String pictures(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        PageHelper.startPage(pageNum,5);

        List<Picture> pictureList = pictureService.listPicture();

        PageInfo<Picture> pageInfo = new PageInfo<>(pictureList);

        model.addAttribute("pageInfo",pageInfo);

        return "admin/pictures";
    }

    //跳转新增照片页面

    @GetMapping("/pictures/input")
    public String addPicture(Model model){


        model.addAttribute("picture",new Picture());

        return "admin/pictures-input";


    }

    //新增照片

    @PostMapping("/pictures")
    public String post(RedirectAttributes attributes, Picture picture, BindingResult result){

        if(result.hasErrors()){

            return "admin/pictures-input";

        }

        int a = pictureService.savePicture(picture);

        if (a == 0){

            attributes.addFlashAttribute("message","新增失败！！");

        }else{

            attributes.addFlashAttribute("message","新增成功！！");
        }

        return "redirect:/admin/pictures";
    }

    //跳转编辑页面

    @GetMapping("/pictures/{id}/input")
    public String editInput(@PathVariable Long id,Model model){

        model.addAttribute("picture",pictureService.searchPicture(id));

        return "admin/pictures-input";
    }

    //编辑照片

    @PostMapping("/pictures/{id}")
    public String editPost(Picture picture,RedirectAttributes attributes){

        int b = pictureService.updatePicture(picture);

        if (b == 0){

            attributes.addFlashAttribute("message","编辑失败!!");

        }else {

            attributes.addFlashAttribute("message","编辑成功!!");
        }

        return "redirect:/admin/pictures";
    }

    //删除照片
    @GetMapping("/pictures/{id}/delete")
    public String deletePicture(@PathVariable Long id,RedirectAttributes attributes){

        pictureService.deletePicture(id);

        attributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/pictures";

    }


}
