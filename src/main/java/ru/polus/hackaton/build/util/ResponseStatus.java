
package ru.polus.hackaton.build.util;


import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

public class ResponseStatus {
    private static final String HEADER = "status";

    public static ResponseEntity<Map<String, String>> doSuccess() {
        return ResponseEntity.ok(Collections.singletonMap(HEADER, "success"));
    }

    public static ResponseEntity<Map<String, String>> doFailed() {
        return ResponseEntity.status(400).body(Collections.singletonMap(HEADER, "fail"));
    }

}
