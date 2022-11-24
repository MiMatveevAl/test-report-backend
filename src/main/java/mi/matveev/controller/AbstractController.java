package mi.matveev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

public abstract class AbstractController {
    protected ResponseEntity<?> process(Supplier<?> serviceHandler) {
        try {
            return new ResponseEntity<>(serviceHandler.get(), HttpStatus.OK);
        } catch (NullPointerException npe) {
            return new ResponseEntity<>(npe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException iae) {
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
