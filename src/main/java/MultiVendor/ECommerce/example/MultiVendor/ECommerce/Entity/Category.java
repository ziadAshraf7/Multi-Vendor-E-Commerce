package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity;


import MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @Column(name = "title" , columnDefinition = "VARCHAR(255) COLLATE utf8_general_ci")
    @NotNull
    private String title;

    @Column(name = "meta_title")
    @NotNull
    private String metaTitle;

    @Lob
    @Column(name = "image")
    @NotNull
    private byte[] image;

    @Column(name = "description" , columnDefinition = "TEXT")
    @NotNull
    private String description;

    //    <----------------- relational mappings -------------------->

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Category> subCategories = new LinkedList<>();

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private final List<Product> products = new LinkedList<>();

    //    <----------------- relational mappings -------------------->


   // <--------------------- Methods -------------------------------->

    public void addSubCategory(Category subCategory){
        this.subCategories.add(0,subCategory);
    }

    public Category getSubCategory(int subCategoryIndex){
        return this.subCategories.get(subCategoryIndex);
    }

    public void deleteSubCategory(int subCategoryIndex){
        this.subCategories.remove(subCategoryIndex);
    }

    public void addProduct(Product product){
        this.products.add(0,product);
    }

    public Product getProduct(int productIndx){
        return this.products.get(productIndx);
    }

    public void deleteProduct(int productIndx){
        this.products.remove(productIndx);
    }

}
