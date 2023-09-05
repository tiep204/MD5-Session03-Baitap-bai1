package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.model.entity.Blog;
import ra.model.entity.Category;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}