package com.nonicafe.api.admin;

import com.nonicafe.dto.ContactDTO;
import com.nonicafe.dto.request.ProcessRequest;
import com.nonicafe.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
