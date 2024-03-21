package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_image")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product_Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull

    private long id;


    @Lob
    @Column(name = "image")
    @NotNull
    private byte[] image;


    //    <----------------- relational mappings -------------------->

    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    @NotNull
    Product product;
//    <----------------- relational mappings -------------------->

}
