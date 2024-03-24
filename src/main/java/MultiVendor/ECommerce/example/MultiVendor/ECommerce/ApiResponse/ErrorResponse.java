package MultiVendor.ECommerce.example.MultiVendor.ECommerce.ApiResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private int status;

    private String errorMessage;

}
