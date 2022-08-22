package com.dcy.web.admin;

import com.dcy.po.Blog;
import com.dcy.po.Type;
import com.dcy.po.User;
import com.dcy.queryvo.BlogQuery;
import com.dcy.queryvo.SearchBlog;
import com.dcy.queryvo.ShowBlog;
import com.dcy.service.BlogService;
import com.dcy.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

//    @GetMapping("/blogs")
//    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//
//        String orderBy = "update_time desc";
//
//        PageHelper.startPage(pageNum,5,orderBy);
//
//        List<BlogQuery> list =blogService.getAllBlog();
//
//        PageInfo<BlogQuery> pageInfo = new PageInfo<>(list);
//
//        model.addAttribute("types",typeService.getAllType());
//
//        model.addAttribute("pageInfo",pageInfo);
//
//        return null;
//
//    }
//

    @GetMapping("/blogs")
    public String blogs(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        String orderBy ="update_time desc";

        PageHelper.startPage(pageNum,5,orderBy);

        List<BlogQuery> list = blogService.getAllBlog();

        PageInfo<BlogQuery> pageInfo = new PageInfo<>(list);

        model.addAttribute("types",typeService.getAllType());

        model.addAttribute("pageInfo",pageInfo);

        return null;
    }

    //跳转博客新增页面
//    @GetMapping("/blogs/input")
//    public String input(Model model) {
//        model.addAttribute("types",typeService.getAllType());
//        model.addAttribute("blog", new Blog());
//        return "admin/blogs-input";
//    }

      @GetMapping("/blogs/input")
      public String input(Model model){

        model.addAttribute("types",typeService.getAllType());

        model.addAttribute("blog",new Blog());

        return "admin/blogs-input";
      }




    //    博客新增
//    @PostMapping("/blogs")
//    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
//        blog.setUser((User) session.getAttribute("user"));
//        //设置blog的type
//        blog.setType(typeService.getType(blog.getType().getId()));
//        //设置blog中typeId属性
//        blog.setTypeId(blog.getType().getId());
//        //设置用户id
//        blog.setUserId(blog.getUser().getId());
//        int b = blogService.saveBlog(blog);
//
//        if(b == 0){
//            attributes.addFlashAttribute("message", "新增失败");
//        }else {
//            attributes.addFlashAttribute("message", "新增成功");
//        }
//        return "redirect:/admin/blogs";
//    }



    //    博客新增
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getType(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());
        int b = blogService.saveBlog(blog);

        if(b == 0){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }


    //    删除文章
//    @GetMapping("/blogs/{id}/delete")
//    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
//        blogService.deleteBlog(id);
//        attributes.addFlashAttribute("message", "删除成功");
//        return "redirect:/admin/blogs";
//    }


    @GetMapping("blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){

        blogService.deleteBlog(id);

        attributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/blogs";
    }




    //    跳转编辑修改文章
//    @GetMapping("/blogs/{id}/input")
//    public String editInput(@PathVariable Long id, Model model) {
//        ShowBlog blogById = blogService.getBlogById(id);
//        List<Type> allType = typeService.getAllType();
//        model.addAttribute("blog", blogById);
//        model.addAttribute("types", allType);
//        return "admin/blogs-input";
//    }


    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){

        ShowBlog blogById = blogService.getBlogById(id);

        model.addAttribute("blog",blogById);

        model.addAttribute("types",typeService.getAllType());

        return "admin/blogs-input";

    }



    //    编辑修改文章
//    @PostMapping("/blogs/{id}")
//    public String editPost(ShowBlog showBlog, RedirectAttributes attributes) {
//        int b = blogService.updateBlog(showBlog);
//        if(b ==0){
//            attributes.addFlashAttribute("message", "修改失败");
//        }else {
//            attributes.addFlashAttribute("message", "修改成功");
//        }
//        return "redirect:/admin/blogs";
//    }

    @PostMapping("/blogs/{id}")
    public String editPost(ShowBlog showBlog,RedirectAttributes attributes){

        int b = blogService.updateBlog(showBlog);

        if (b == 0){

            attributes.addFlashAttribute("message","修改失败！");
        }else{

            attributes.addFlashAttribute("message","修改成功！");

        }
        return "redirect:/admin/blogs";


    }


    //    搜索博客
//    @PostMapping("/blogs/search")
//    public String search(SearchBlog searchBlog, Model model,
//                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
//        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
//        PageHelper.startPage(pageNum, 10);
//        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
//        model.addAttribute("pageInfo", pageInfo);
//        return "admin/blogs :: blogList";
//    }
//

    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog,Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNUm){

        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);

        PageHelper.startPage(pageNUm,5);

        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);

        model.addAttribute("pageInfo",pageInfo);

        return "admin/blogs ::blogList";
    }



}
