package com.olivier.contactlist.service;

import com.olivier.contactlist.entity.Contact;
import com.olivier.contactlist.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public boolean checkIfContactExistByLastname(String lastname) {
        return contactRepository.findByLastName(lastname).isPresent();
    }

    public boolean checkIfContactExistById(Long id) {
        return contactRepository.findById(id).isPresent();
    }

    public List<Contact> getAllContacts() {
        return (List) contactRepository.findAll();
    }

    public Long countContacts() {
        return contactRepository.count();
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
