package com.eazybytes.eazybytes.service;

import com.eazybytes.eazybytes.dto.ContactDto;
import com.eazybytes.eazybytes.dto.ProductDto;

import java.util.List;

public interface IContactService {

    boolean saveContact(ContactDto contactDto);
}
