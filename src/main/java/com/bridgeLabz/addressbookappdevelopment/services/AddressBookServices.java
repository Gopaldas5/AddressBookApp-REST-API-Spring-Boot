package com.bridgeLabz.addressbookappdevelopment.services;

import com.bridgeLabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgeLabz.addressbookappdevelopment.email.EmailService;
import com.bridgeLabz.addressbookappdevelopment.exception.CustomException;
import com.bridgeLabz.addressbookappdevelopment.model.AddressBook;
import com.bridgeLabz.addressbookappdevelopment.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookServices implements IAddressBookServices {
    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    EmailService emailService;

    public AddressBook addContact(AddressBookDTO addressBookDTO) {
        AddressBook employeePayrollDataObj = new AddressBook(addressBookDTO);
        return addressBookRepository.save(employeePayrollDataObj);
    }

    @Override
    public Optional<AddressBook> findContactById(int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            return addressBookRepository.findById(id);
        } else {
            throw new CustomException("Contact id not found");
        }
    }

    public List<AddressBook> findAllContact() {
        if (addressBookRepository.findAll().isEmpty() == false) {
            return addressBookRepository.findAll();
        } else {
            throw new CustomException("Address Book is empty");
        }
    }

    @Override
    public AddressBook updateContactById(int id, AddressBookDTO addressBookDTO) {
        if (addressBookRepository.findById(id).isPresent()) {
            AddressBook addressBook = addressBookRepository.findById(id).get();
            System.out.println(addressBook);
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setAddress(addressBookDTO.getAddress());
            addressBookRepository.save(addressBook);
            return ResponseEntity.ok(addressBook).getBody();
        } else {
            throw new CustomException("Contact id not found, Insert correct id");
        }
    }

    public List<AddressBook> findBookByName(String name) {
        if (addressBookRepository.findBookByName(name).isEmpty()) {
            throw new CustomException("Contact id not found");

        } else {
            return addressBookRepository.findBookByName(name);
        }
    }

    public AddressBook addContactEmail(AddressBookDTO addressBookDTO) {
        AddressBook employeePayrollData = new AddressBook(addressBookDTO);
        addressBookRepository.save(employeePayrollData);
        emailService.sendEmail(addressBookDTO.getEmail(), "Account sign up Successfully", "Hello " + employeePayrollData.getFirstName() + " " + employeePayrollData.getLastName());
        return addressBookRepository.save(employeePayrollData);
    }

    public int deleteContactById(int id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            return id;
        } else {
            throw new CustomException("Id is not found , Insert correct id number! ");
        }
    }


}
