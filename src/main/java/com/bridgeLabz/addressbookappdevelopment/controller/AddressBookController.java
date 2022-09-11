package com.bridgeLabz.addressbookappdevelopment.controller;

import com.bridgeLabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgeLabz.addressbookappdevelopment.dto.ResponseDTO;
import com.bridgeLabz.addressbookappdevelopment.email.EmailService;
import com.bridgeLabz.addressbookappdevelopment.model.AddressBook;
import com.bridgeLabz.addressbookappdevelopment.services.IAddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    IAddressBookServices iAddressBookServices;

    @Autowired
    EmailService emailService;

    // Create a POST method to add AddressBook details in the BookList.
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Add Contact data successfully to the list",
                iAddressBookServices.addContact(addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    // Create a GET  method to find  AddressBook details in the BookList by using id.
    @GetMapping("/findContact/{id}")
    public ResponseEntity<ResponseDTO> findEmployeePayrollData(@PathVariable("id") int id) {
        ResponseDTO responseDTO = new ResponseDTO("find contact Id successful",
                iAddressBookServices.findContactById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    // Create a GET  method to find all AddressBook details in the BookList.
    @GetMapping("/findAllContacts")
    public List<AddressBook> findingAllContact() {
        return iAddressBookServices.findAllContact();
    }

    // Create a PUT  method to update  AddressBook details by using id to the BookList.
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id,
                                                     @RequestBody AddressBookDTO addressBookDTO) {

        AddressBook addressBook = iAddressBookServices.updateContactById(id, addressBookDTO);;
        ResponseDTO responseDTO = new ResponseDTO("Update address Book contact successfully", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PostMapping("/email")
    public ResponseEntity<ResponseDTO> addContactEmail(@RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("EmployeeData email added successfully", iAddressBookServices.addContactEmail(addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
  @GetMapping("/findBookByName/{firstName}")
  public ResponseEntity<ResponseDTO> findBookByName(@PathVariable String firstName){
        ResponseDTO responseDTO = new ResponseDTO("Find book contact by Name",
                iAddressBookServices.findBookByName(firstName));
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
  }

    // Create a DELETE  method to delete  AddressBook details by using id from the BookList.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Delete Contact from Address Book successfully",
                iAddressBookServices.deleteContactById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
