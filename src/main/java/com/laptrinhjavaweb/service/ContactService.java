package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ContactDTO;
import com.laptrinhjavaweb.dto.request.ProcessRequest;
import com.laptrinhjavaweb.dto.response.ContactDetailResponse;
import com.laptrinhjavaweb.dto.response.ContactResponse;
import com.laptrinhjavaweb.entity.ContactEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    ResponseEntity save(ContactDTO contactDTO);
    List<ContactResponse> findAll(Integer status,String name,String date);
    void setProcessed(Long contactId, ProcessRequest processRequest);
    ContactDetailResponse findOne(Long id);
    List<Long> delete(List<Long> ids);
}
