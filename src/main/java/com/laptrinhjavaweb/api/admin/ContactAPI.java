package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.dto.request.ProcessRequest;
import com.laptrinhjavaweb.dto.request.ProductIdRequest;
import com.laptrinhjavaweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/contact")
public class ContactAPI {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity save(@RequestBody ContactDTO contactDTO) {
        return contactService.save(contactDTO);
    }

    @PutMapping("/{id}")
    public Long setProcessed(@PathVariable Long id, @RequestBody ProcessRequest status) {
        contactService.setProcessed(id, status);
        return id;
    }

    @DeleteMapping
    public List<Long> delete(@RequestBody List<Long> ids) {
        contactService.delete(ids);
        return ids;
    }
}
