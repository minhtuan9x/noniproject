package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ContactConverver;
import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.dto.request.ProcessRequest;
import com.laptrinhjavaweb.dto.response.ContactDetailResponse;
import com.laptrinhjavaweb.dto.response.ContactResponse;
import com.laptrinhjavaweb.entity.ContactEntity;
import com.laptrinhjavaweb.entity.ProductContactEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ContactRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.ContactService;
import com.laptrinhjavaweb.service.GoogleCaptchaService;
import com.laptrinhjavaweb.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
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
    @Autowired
    private MailService mailService;
    @Autowired
    private GoogleCaptchaService googleCaptchaService;


    @Override
    @Transactional
    public ResponseEntity save(ContactDTO contactDTO) {
        if(!googleCaptchaService.verifyGoogleCaptcha(contactDTO.getCaptchaResponse()))
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        ContactEntity contactEntity = contactConverver.toContactEntity(contactDTO);
        ContactEntity contactEntityFound = contactRepository.save(contactEntity);
        List<ProductContactEntity> productContactEntities = new ArrayList<>();
        contactDTO.getProductIdRequests().forEach(item -> {
            ProductContactEntity productContactEntity = new ProductContactEntity();
            productContactEntity.setProductEntity(productRepository.findOne(item.getProductId()));
            productContactEntity.setQuantity(item.getQuantity());
            productContactEntity.setContactEntity(contactEntityFound);
            productContactEntities.add(productContactEntity);
        });
        contactEntityFound.setProductContactEntities(productContactEntities);
        contactEntityFound.setStatus(0);
        contactRepository.save(contactEntityFound);
        mailService.sentMailContact(contactEntityFound);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public List<ContactResponse> findAll(Integer status,String name,String date) {
        List<ContactResponse> contactResponses = new ArrayList<>();
        contactRepository.findAll(status,name,date).forEach(item -> {
            contactResponses.add(contactConverver.toContactResponse(item));
        });
        return contactResponses;
    }

    @Override
    @Transactional
    public void setProcessed(Long contactId, ProcessRequest processRequest) {
        ContactEntity contactEntity = contactRepository.findOne(contactId);
        contactEntity.setStatus(processRequest.getStatus());
        contactRepository.save(contactEntity);
    }

    @Override
    public ContactDetailResponse findOne(Long id) {
        return contactConverver.toContactDetailResponse(contactRepository.findOne(id));
    }

    @Override
    @Transactional
    public List<Long> delete(List<Long> ids) {
        return contactRepository.deleteByIdIn(ids);
    }
}
