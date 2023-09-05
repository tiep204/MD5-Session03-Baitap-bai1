package ra.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Cate_Blog", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> listCategory = new HashSet<>();

    public Blog() {
    }

    public Blog(Long id, String title, String content, Set<Category> listCategory) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.listCategory = listCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(Set<Category> listCategory) {
        this.listCategory = listCategory;
    }
}