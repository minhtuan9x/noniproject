package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ContactConverver;
import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.entity.ContactEntity;
import com.laptrinhjavaweb.repository.ContactRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactConverver contactConverver;
    @Autowired
    private ProductRepository productRepository;
//    @Override
//    public List<ContactDTO> findAllContactByProductId(Long productID) {
//        List<ContactEntity> contactEntity = contactRepository.findByProductEntityId(productID);
//        List<ContactDTO> contactDTOS = new ArrayList<>();
//        contactEntity.forEach(item->{
//            ContactDTO contactDTO = new ContactDTO();
//            contactDTO = contactConverver.toContactDTO(item);
//            contactDTOS.add(contactDTO);
//        });
//        return contactDTOS;
//    }
//
//    @Override
//    public void save(ContactDTO contactDTO, Long productId) {
//        ContactEntity contactEntity = contactConverver.toContactEntity(contactDTO);
//        if(productId!=null){
//            contactEntity.setProductEntity(productRepository.findOne(productId));
//        }
//        try {
//            contactRepository.save(contactEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void setProcessed(Long contactId) {
//        contactRepository.setProcessed(contactId);
//    }
//
//    @Override
//    public void delete(Long id) {
//        try {
//            contactRepository.delete(id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
