package MultiVendor.ECommerce.example.MultiVendor.ECommerce.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomApiResponse<T> {

    private int status;
    private String message;
    private T data;

}
