package com.bridgeLabz.addressbookappdevelopment.services;

import com.bridgeLabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgeLabz.addressbookappdevelopment.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookServices {
    AddressBook addContact(AddressBookDTO addressBookDTO);

    Optional<AddressBook> findContactById(int id);

    List<AddressBook> findAllContact();

    AddressBook updateContactById(int id, AddressBookDTO employeePayrollDTO);

    int deleteContactById(int id);

    Object addContactEmail(AddressBookDTO addressBookDTO);

     List<AddressBook> findBookByName(String name);
}
