package MultiVendor.ECommerce.example.MultiVendor.ECommerce.ApiResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private int status;

    private String errorMessage;

}
