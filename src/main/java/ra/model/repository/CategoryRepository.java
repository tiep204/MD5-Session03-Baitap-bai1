package ra.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.Category;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByNameContainsIgnoreCase(String name, Pageable pageable);

    @Query(value = "SELECT c.* FROM category c INNER JOIN cate_blog cb ON c.id = cb.category_id WHERE cb.blog_id = :blogId", nativeQuery = true)
    List<Category> findCategoriesByBlogId(@Param("blogId") Long blogId);

}