package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contact")
public class ContactAPI {
    @Autowired
    private ContactService contactService;

//    @GetMapping("/{id}/product")
//    public List<ContactDTO> getAllContactByProductId(@PathVariable("id") Long id) {
//        return contactService.findAllContactByProductId(id);
//    }
//    @PostMapping("/{productId}")
//    public ContactDTO save(@PathVariable("productId") Long productId,@RequestBody ContactDTO contactDTO){
//        contactService.save(contactDTO,productId);
//        return contactDTO;
//    }
//    @PutMapping("/{id}")
//    public Long setProcessed(@PathVariable("id")Long id){
//        contactService.setProcessed(id);
//        return id;
//    }
//    @DeleteMapping("/{id}")
//    public Long delete(@PathVariable("id") Long id){
//        contactService.delete(id);
//        return id;
//    }
}
