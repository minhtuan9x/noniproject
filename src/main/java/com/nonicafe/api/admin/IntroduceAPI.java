package com.nonicafe.api.admin;

import com.nonicafe.dto.IntroduceDTO;
import com.nonicafe.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "introduceApiOfAdmin")
@RequestMapping("/api/introduce")
public class IntroduceAPI {
    @Autowired
    private IntroduceService introduceService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody IntroduceDTO introduceDTO){
        introduceService.save(introduceDTO);
        return ResponseEntity.noContent().build();
    }
}
