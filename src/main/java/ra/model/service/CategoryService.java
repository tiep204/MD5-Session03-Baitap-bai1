package ra.model.service;

import org.springframework.data.domain.Page;
import ra.model.entity.Category;

import java.util.List;

public interface CategoryService extends IGenericService<Category,Long>{
    Page<Category> findAll(String name,int page,int size,String sort,String by);
}