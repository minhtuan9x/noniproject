package com.nonicafe.api.admin;

import com.nonicafe.dto.ReSearchDTO;
import com.nonicafe.service.ReSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research")
public class ReSearchAPI {
    @Autowired
    private ReSearchService reSearchService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reSearchService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ReSearchDTO reSearchDTO){
        reSearchService.save(reSearchDTO);
        return ResponseEntity.noContent().build();
    }
}
