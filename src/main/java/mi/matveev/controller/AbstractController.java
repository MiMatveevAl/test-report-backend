package mi.matveev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

public abstract class AbstractController {
    protected ResponseEntity<?> process(Supplier<?> serviceHandler) {
        return new ResponseEntity<>(serviceHandler.get(), HttpStatus.OK);
    }
}
