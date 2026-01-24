package com.eazybytes.eazybytes.repository;

import com.eazybytes.eazybytes.entity.Contact;
import com.eazybytes.eazybytes.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
