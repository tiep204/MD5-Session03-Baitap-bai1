package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Blog;
import ra.model.entity.Category;
import ra.model.service.BlogService;
import ra.model.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String findAll(Model model) {
        List<Blog> blogList = blogService.findAll();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("listCategory", categoryList);
        model.addAttribute("listBlog", blogList);
        return "blog/list";
    }

    @GetMapping("/create")
    public String showAdd(Model model) {
        Blog blog = new Blog();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("category", categoryList);
        model.addAttribute("blog", blog);
        return "blog/add";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        Blog blog = blogService.findById(id);
        List<Category> category = categoryService.findAll();
        model.addAttribute("listCategory", category);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findCategoryByBlogId(id);
        model.addAttribute("blog", blog);
        model.addAttribute("cate",categoryList);
        System.out.println(categoryList);
        return "blog/detail";
    }
}