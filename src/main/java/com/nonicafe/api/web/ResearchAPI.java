package com.nonicafe.api.web;

import com.nonicafe.dto.ReSearchDTO;
import com.nonicafe.service.ReSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "reSearchApiOfWeb")
@RequestMapping("/api/research")
public class ResearchAPI {
    @Autowired
    private ReSearchService reSearchService;
    @GetMapping()
    public ResponseEntity<List<ReSearchDTO>> findOne(){
        return ResponseEntity.ok(reSearchService.findAll());
    }
}
