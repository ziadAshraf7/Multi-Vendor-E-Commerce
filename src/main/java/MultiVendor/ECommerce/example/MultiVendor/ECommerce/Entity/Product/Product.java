package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product;


import MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @Column(name = "title" , length = 50)
    @NotNull(message = "the value should not be null")
    private String title;

    @Column(name = "price")
    @DecimalMin(value = "0.25", message = "Value must be greater than or equal to 0.25 $")
    @NotNull(message = "the value should not be null")
    private double price;

    @Column(name = "code" , unique = true)
    @NotNull(message = "the value should not be null")
    private String code;

    @Column(name = "description" , columnDefinition = "TEXT")
    @NotNull(message = "the value should not be null")
    private String description;

    @Column(name = "meta_title")
    private String metaTitle;



    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

//    <----------------- relational mappings -------------------->

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private final List<Product_Image> images = new ArrayList<>(50);

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private final List<Product_Color> colors = new ArrayList<>(50);

//    <----------------- relational mappings -------------------->

}
