package com.eazybytes.eazybytes.controller;

import com.eazybytes.eazybytes.dto.ContactDto;
import com.eazybytes.eazybytes.dto.ProductDto;
import com.eazybytes.eazybytes.service.IContactService;
import com.eazybytes.eazybytes.service.IproductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService iContactService;


    @PostMapping
    public String saveContact(@RequestBody ContactDto contactDto) {

         boolean isSaved = iContactService.saveContact(contactDto);
        if(isSaved){
            return "Request processed successfully";
        } else {
            return "An Error occured. please try again or contact our dev team";

        }
    }
}
