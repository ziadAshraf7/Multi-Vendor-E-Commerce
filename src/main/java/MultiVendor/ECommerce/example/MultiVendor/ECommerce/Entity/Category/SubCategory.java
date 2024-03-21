package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Category;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubCategory {
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

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH} )
    @JoinColumn(name = "parent_category_id")
    private ParentCategory parentCategory;

    //    <----------------- relational mappings -------------------->




}
