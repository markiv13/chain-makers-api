package chainmakers.supplychain.api.rest;

import chainmakers.supplychain.core.exception.SampleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({SampleException.class})
    public void handleSampleException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
