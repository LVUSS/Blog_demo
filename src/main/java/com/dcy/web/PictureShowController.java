package com.dcy.web;


import com.dcy.po.Picture;
import com.dcy.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;


    @GetMapping("/picture")
    public String picture(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        List<Picture> pictureList = pictureService.listPicture();

        model.addAttribute("pictures",pictureList);

        return "picture";

    }


}
