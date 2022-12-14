package com.dcy.web;


import com.dcy.queryvo.BlogQuery;
import com.dcy.service.BlogService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(Model model){


        List<BlogQuery> blogs = blogService.getAllBlog();

        model.addAttribute("blogs",blogs);

        return "archives";
    }




}
