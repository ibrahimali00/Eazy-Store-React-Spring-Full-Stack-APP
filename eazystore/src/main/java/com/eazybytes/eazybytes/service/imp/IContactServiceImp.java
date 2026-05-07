package com.eazybytes.eazybytes.service.imp;

import com.eazybytes.eazybytes.dto.ContactDto;
import com.eazybytes.eazybytes.dto.ProductDto;
import com.eazybytes.eazybytes.entity.Contact;
import com.eazybytes.eazybytes.entity.Product;
import com.eazybytes.eazybytes.repository.ContactRepository;
import com.eazybytes.eazybytes.repository.ProductRepository;
import com.eazybytes.eazybytes.service.IContactService;
import com.eazybytes.eazybytes.service.IproductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IContactServiceImp implements IContactService {


    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactDto contactDto) {

            Contact contact = transformToEntity(contactDto) ;
            contactRepository.save(contact);
            return true;


    }

    private Contact transformToEntity (ContactDto contactDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
        return contact;
    }


}
