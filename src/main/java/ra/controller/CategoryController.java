package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Category;
import ra.model.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String findAll(Model model, @RequestParam(defaultValue = "") String name,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "2") int size,
                          @RequestParam(defaultValue = "name") String sort,
                          @RequestParam(defaultValue = "asc") String by) {
/*        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("listCategory", categoryList);*/
        Page<Category> categoryList = categoryService.findAll(name,page,size,sort,by);
        model.addAttribute("listCategory", categoryList);
        model.addAttribute("name",name);
        return "category/list";
    }

    @GetMapping("add")
    public String showAdd(Model model) {
        Category category = new Category();
        model.addAttribute("cate", category);
        return "category/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Category cate) {
        categoryService.save(cate);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String showEdit(Model model,@PathVariable Long id){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/";
    }
}