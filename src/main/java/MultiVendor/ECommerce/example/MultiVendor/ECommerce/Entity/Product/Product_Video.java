package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_video")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product_Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull

    private long id;

    @Lob
    @Column(name = "video")
    @NotNull
    private byte[] video;


    //    <----------------- relational mappings -------------------->

    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    @NotNull
    private Product product;
//    <----------------- relational mappings -------------------->

}
