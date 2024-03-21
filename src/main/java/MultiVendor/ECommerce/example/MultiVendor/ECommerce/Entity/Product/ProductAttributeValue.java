package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_attribute_value")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeValue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "product_attr_id")
    ProductAttributeName productAttributeName;

    @Column(name = "value")
    private String value;
}
