package com.nonicafe.converter;

import com.nonicafe.constant.ProcessConstant;
import com.nonicafe.dto.ContactDTO;
import com.nonicafe.dto.response.ContactDetailResponse;
import com.nonicafe.dto.response.ContactResponse;
import com.nonicafe.dto.response.ProductContactResponse;
import com.nonicafe.entity.ContactEntity;
import com.nonicafe.entity.ProductContactEntity;
import com.nonicafe.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContactConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DecimalFormat decimalFormat;

    public ContactDTO toContactDTO(ContactEntity contactEntity) {
        ContactDTO contactDTO = modelMapper.map(contactEntity, ContactDTO.class);
        contactDTO.setCreatedDateStr(DateUtils.toDateStr(contactEntity.getCreatedDate()));
        return contactDTO;
    }

    public ContactResponse toContactResponse(ContactEntity contactEntity) {
        ContactResponse contactResponse = modelMapper.map(contactEntity, ContactResponse.class);
        contactResponse.setCreatedDateStr(DateUtils.toDateStr(contactEntity.getCreatedDate()));
        if (contactEntity.getStatus() == 0) {
            contactResponse.setProcess(ProcessConstant.DON_HANG_MOI);
        } else {
            if (contactEntity.getStatus() == 2)
                contactResponse.setProcess(ProcessConstant.DA_XU_LI);
            else
                contactResponse.setProcess(ProcessConstant.DANG_XU_LI);
        }
        int tong = 0;
        for (ProductContactEntity item : contactEntity.getProductContactEntities()) {
            tong += item.getQuantity() * item.getProductEntity().getPrice();
        }
        contactResponse.setTotalPrice(decimalFormat.format(tong));
        return contactResponse;
    }

    public ContactEntity toContactEntity(ContactDTO contactDTO) {
        ContactEntity contactEntity = modelMapper.map(contactDTO, ContactEntity.class);
        return contactEntity;
    }

    public ContactDetailResponse toContactDetailResponse(ContactEntity contactEntity) {
        ContactDetailResponse contactDetailResponse = modelMapper.map(contactEntity, ContactDetailResponse.class);
        if (contactEntity.getStatus() == 0) {
            contactDetailResponse.setProcess(ProcessConstant.DON_HANG_MOI);
        } else {
            if (contactEntity.getStatus() == 2)
                contactDetailResponse.setProcess(ProcessConstant.DA_XU_LI);
            else
                contactDetailResponse.setProcess(ProcessConstant.DANG_XU_LI);
        }
        int tong = 0;
        for (ProductContactEntity item : contactEntity.getProductContactEntities()) {
            tong += item.getQuantity() * item.getProductEntity().getPrice();
        }
        contactDetailResponse.setTotalPrice(decimalFormat.format(tong));

        List<ProductContactResponse> productContactResponses = new ArrayList<>();
        for (ProductContactEntity item : contactEntity.getProductContactEntities()) {
            ProductContactResponse productContactResponse = new ProductContactResponse();
            productContactResponse.setProductName(
                    "[" + item.getProductEntity().getMass() + "]" + item.getProductEntity().getName());
            productContactResponse.setProductQuantity("x" + item.getQuantity().toString());
            productContactResponse.setTotal(decimalFormat.format((long) item.getProductEntity().getPrice() * item.getQuantity()));
            productContactResponses.add(productContactResponse);
        }
        contactDetailResponse.setProductContactResponses(productContactResponses);
        return contactDetailResponse;
    }
}
