package rg.ragulajw.data.models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", 0);
        map.put("errorMsg", "");
        map.put("message", message);
        map.put("status", status.value());
        map.put("response", responseObj);

        return new ResponseEntity<Object>(map,status);
    }

    public static ResponseEntity<Object> generateErrorResponse(int errrorId, String errorMessage, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("error", errrorId);
        map.put("errorMsg", errorMessage);
        map.put("message", "Error");
        map.put("status", status.value());
        map.put("response", null);
        return new ResponseEntity<Object>(map,status);
    }
}
