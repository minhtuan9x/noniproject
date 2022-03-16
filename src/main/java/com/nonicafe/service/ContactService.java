package com.nonicafe.service;

import com.nonicafe.dto.AbstractDTO;
import com.nonicafe.dto.ContactDTO;
import com.nonicafe.dto.request.ProcessRequest;
import com.nonicafe.dto.response.ContactDetailResponse;
import com.nonicafe.dto.response.ContactResponse;
import com.nonicafe.dto.response.ContactStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    ResponseEntity<Void> save(ContactDTO contactDTO);
    AbstractDTO<ContactResponse> findAll(Integer status,String name,String date);
    AbstractDTO<ContactResponse> findAllWithPage(Integer page);
    void setProcessed(Long contactId, ProcessRequest processRequest);
    ContactDetailResponse findOne(Long id);
    List<Long> delete(List<Long> ids);
    ContactStatus getStatus();
}
