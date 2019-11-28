package Zade.Server.Assets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AssetNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AssetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String assetNotFoundHandler(AssetNotFoundException ex) {
        return ex.getMessage();
    }
}