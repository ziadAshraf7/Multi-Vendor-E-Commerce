package MultiVendor.ECommerce.example.MultiVendor.ECommerce.Exceptions;

import MultiVendor.ECommerce.example.MultiVendor.ECommerce.ApiResponse.CustomApiResponse;
import MultiVendor.ECommerce.example.MultiVendor.ECommerce.ApiResponse.ErrorResponse;
import MultiVendor.ECommerce.example.MultiVendor.ECommerce.Exceptions.ErrorEntity.DatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(DatabaseException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
