package MultiVendor.ECommerce.example.MultiVendor.ECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "MultiVendor.ECommerce.example.MultiVendor.ECommerce.*")
public class MultiVendorECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiVendorECommerceApplication.class, args);
	}

}
