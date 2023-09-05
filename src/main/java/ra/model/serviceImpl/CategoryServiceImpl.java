package ra.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Category;
import ra.model.repository.CategoryRepository;
import ra.model.service.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Page<Category> findAll(String name, int page, int size,String sort, String by) {
        Sort s;
        if (by.equals("asc")){
            s = Sort.by(sort).ascending();
        }else {
            s = Sort.by(sort).descending();
        }
        return categoryRepository.findAllByNameContainsIgnoreCase(name, PageRequest.of(page,size,s));
    }

    @Override
    public List<Category> findCategoryByBlogId(Long blogId) {
        return categoryRepository.findCategoriesByBlogId(blogId);
    }
}