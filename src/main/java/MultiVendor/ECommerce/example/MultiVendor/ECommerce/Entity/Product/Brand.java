package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Entity.Product;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name" , unique = true)
    @NotNull
    private String name;

    @Lob
    @NotNull
    @Column(name = "image")
    private byte[] image;


        //    <----------------- relational mappings -------------------->
       @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
       private final List<Product> products = new LinkedList<>();
       //    <----------------- relational mappings -------------------->



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
