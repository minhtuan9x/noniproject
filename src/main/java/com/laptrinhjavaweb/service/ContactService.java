package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    List<ContactDTO> findAllContactByProductId(Long productID);
    void save(ContactDTO contactDTO,Long productId);
    void setProcessed(Long contactId);
    void delete(Long id);
}
