package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_attribute_name")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull

    private Long id;

    @Column(name = "attr_name")
    @NotNull
    private String attrName;


    //    <----------------- relational mappings -------------------->

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "productAttributeName" , cascade = CascadeType.ALL)
    private final List<ProductAttributeValue> productAttributeValueList = new ArrayList<>(20);

//    <----------------- relational mappings -------------------->





}
