package com.olivier.contactlist.controller;

import com.olivier.contactlist.entity.Contact;
import com.olivier.contactlist.service.ContactChecker;
import com.olivier.contactlist.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactChecker contactChecker;

    @GetMapping(value = {"/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("contacts", contactService.getAllContact());
        model.addAttribute("count", contactService.countContacts());
        return "home-page";
    }

    @GetMapping("/new-contact")
    public String showCreateContactPage(Model model ) {
        model.addAttribute("contact", new Contact());
        return "create-page";
    }

    @PostMapping("/add")
    public String saveContact(@ModelAttribute("contact") Contact contact, Model model) {
        List<String> errorList = new ArrayList<>();
        contactChecker.checkContactForm(contact, errorList);
        contactChecker.checkIfContactExistByLastname(contact.getLastName(), errorList);

        if (!errorList.isEmpty()) {
            model.addAttribute("errorList", errorList);
            return "create-page";
        } else {
            contactService.saveContact(contact);
            model.addAttribute("contacts", contactService.getAllContact());
            return "home-page";
        }

    }

    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id, Model model) {
        List<String> errorList = new ArrayList<>();
        contactChecker.chekIfContactExistById(id, errorList);

        if (!errorList.isEmpty()) {
            model.addAttribute("errorList", errorList);
        } else {
            contactService.deleteContact(id);
        }

        model.addAttribute("contacts", contactService.getAllContact());
        return "home-page";
    }

    @GetMapping("/contact/{id}")
    public String showContact(@PathVariable Long id, Model model) {
        List<String> errorList = new ArrayList<>();
        contactChecker.chekIfContactExistById(id, errorList);

        if (!errorList.isEmpty()) {
            model.addAttribute("errorList", errorList);
            model.addAttribute("contacts", contactService.getAllContact());
            return "home-page";
        } else {
            Contact contact = contactService.getContactById(id).orElse(null);
            model.addAttribute("contact", contact);
            return "update-page";
        }

    }

    @PostMapping("/update/{id}")
    public String updateContact(@PathVariable long id, @ModelAttribute Contact contact, Model model) {
        List<String> errorList = new ArrayList<>();
        contactChecker.checkContactForm(contact, errorList);
        contactChecker.chekIfContactExistById(contact.getId(), errorList);
        if (!errorList.isEmpty()) {
            model.addAttribute("errorList", errorList);
            return "update-page";
        } else {
            contactService.saveContact(contact);
            model.addAttribute("contacts", contactService.getAllContact());
            return "home-page";
        }

    }



}
