package ra.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import ra.model.entity.Category;

import java.util.List;

public interface CategoryService extends IGenericService<Category,Long>{
    Page<Category> findAll(String name,int page,int size,String sort,String by);
    List<Category> findCategoryByBlogId(Long blogId);
}