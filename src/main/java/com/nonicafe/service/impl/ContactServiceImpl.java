package com.nonicafe.service.impl;

import com.nonicafe.converter.ContactConverter;
import com.nonicafe.dto.AbstractDTO;
import com.nonicafe.dto.ContactDTO;
import com.nonicafe.dto.request.ProcessRequest;
import com.nonicafe.dto.response.ContactDetailResponse;
import com.nonicafe.dto.response.ContactResponse;
import com.nonicafe.dto.response.ContactStatus;
import com.nonicafe.entity.ContactEntity;
import com.nonicafe.entity.ProductContactEntity;
import com.nonicafe.repository.ContactRepository;
import com.nonicafe.repository.ProductRepository;
import com.nonicafe.service.ContactService;
import com.nonicafe.service.GoogleCaptchaService;
import com.nonicafe.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactConverter contactConverver;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MailService mailService;
    @Autowired
    private GoogleCaptchaService googleCaptchaService;


    @Override
    @Transactional
    public ResponseEntity<Void> save(ContactDTO contactDTO) {
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
    public AbstractDTO<ContactResponse> findAll(Integer status,String name,String date) {
        AbstractDTO<ContactResponse> contactResponses = new AbstractDTO<>();
        contactRepository.findAll(status,name,date).forEach(item -> {
            contactResponses.getListResult().add(contactConverver.toContactResponse(item));
        });
        return contactResponses;
    }

    @Override
    public AbstractDTO<ContactResponse> findAllWithPage(Integer page) {
        AbstractDTO<ContactResponse> contactResponseAbstractDTO = new AbstractDTO<>();
        Page<ContactEntity> contactEntityPage = contactRepository.OrderByCreatedDateDesc(new PageRequest(page-1,20));
        contactResponseAbstractDTO.setPage(page);
        contactResponseAbstractDTO.setListResult(contactEntityPage.getContent().stream().map(item->contactConverver.toContactResponse(item)).collect(Collectors.toList()));
        contactResponseAbstractDTO.setTotalPage(contactEntityPage.getTotalPages());
        return contactResponseAbstractDTO;
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

    @Override
    public ContactStatus getStatus() {
        ContactStatus contactStatus = new ContactStatus();
        contactStatus.setContactNew(contactRepository.countByStatus(0));
        contactStatus.setContactProcess(contactRepository.countByStatus(1));
        contactStatus.setContactProcessed(contactRepository.countByStatus(2));
        contactStatus.setTotalProcess((int) contactRepository.count());
        return contactStatus;
    }
}
