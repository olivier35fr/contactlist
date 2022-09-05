package com.olivier.contactlist.service;

import com.olivier.contactlist.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactChecker {

    @Autowired
    private ContactService contactService;

    private static final String FIRST_NAME_IS_NOT_VALID_ERROR_STRING = "First name is not valid";
    private static final String LAST_NAME_IS_NOT_VALID_ERROR_STRING = "Last name is not valid";
    private static final String EMAIL_IS_NOT_VALID_ERROR_STRING = "Email is not valid";
    private static final String THIS_CONTACT_ALREADY_EXIST_ERROR_STRING = "This contact already exist";
    private static final String THIS_CONTACT_NOT_EXIST_ERROR_STRING = "This contact not exist";

    public void checkContactForm(Contact contact, List<String> errorList) {
        boolean isValidFirstName = isValidString(contact.getFirstName());
        boolean isValidLastName = isValidString(contact.getLastName());
        boolean isValidEmail = isValidEmail(contact.getEmail());

        if(!isValidFirstName) {
            errorList.add(String.format(FIRST_NAME_IS_NOT_VALID_ERROR_STRING));
        }

        if (!isValidLastName) {
            errorList.add(String.format(LAST_NAME_IS_NOT_VALID_ERROR_STRING));
        }

        if (!isValidEmail) {
            errorList.add(String.format(EMAIL_IS_NOT_VALID_ERROR_STRING));
        }
    }

    public void checkIfContactExistByLastname(String lastname, List<String> errorList) {
        if(contactService.checkIfContactExistByLastname(lastname)) {
            errorList.add(String.format(THIS_CONTACT_ALREADY_EXIST_ERROR_STRING));
        }
    }

    public void chekIfContactExistById(Long id, List<String> errorList) {
        if(!contactService.checkIfContactExistById(id)) {
            errorList.add(String.format(THIS_CONTACT_NOT_EXIST_ERROR_STRING));
        }
    }

    private static boolean isValidString(String string){
        boolean isValid = true;
        if(string == null || string.equals("") || string.trim().equals("")) {
            isValid = false;
        }

        return isValid;
    }

    private static boolean isValidEmail( String emailStr ) {
        String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        return emailStr.matches( regExp );
    }

}
