package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Category;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parent_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ParentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String description;


    //    <----------------- relational mappings -------------------->

    @OneToMany(mappedBy =  "parentCategory" , cascade = CascadeType.ALL)
    private final List<SubCategory> subCategories = new ArrayList<>(200);

    //    <----------------- relational mappings -------------------->

}
