package com.kanakM.URLHitCounter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/visitor-count-app")
public class UrlHitController {
    private Map<String, Integer> hitCountMap = new HashMap<>();

    @GetMapping("/count")
    public ResponseEntity<Integer> getHitCount() {
        int hitCount = incrementHitCount("");
        return ResponseEntity.ok(hitCount);
    }

    @GetMapping("/username/{username}/count")
    public ResponseEntity<Map<String, Object>> getHitCountByUsername(@PathVariable("username") String username) {
        int hitCount = incrementHitCount(username);

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", hitCount);

        return ResponseEntity.ok(response);
    }

    private synchronized int incrementHitCount(String username) {
        hitCountMap.putIfAbsent(username, 0);
        int hitCount = hitCountMap.get(username) + 1;
        hitCountMap.put(username, hitCount);
        return hitCount;
    }
}


