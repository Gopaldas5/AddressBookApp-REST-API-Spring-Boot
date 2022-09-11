package com.bridgeLabz.addressbookappdevelopment.model;

import com.bridgeLabz.addressbookappdevelopment.dto.AddressBookDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private  String city;
    @ElementCollection
            @CollectionTable(name = "Phone_Number", joinColumns = @JoinColumn(name = "contact_id"))
    List<String> phoneNumbers;
    @Email
    private String email;

    public AddressBook(int id, String firstName, String lastName, String address, String city, List<String> phoneNumbers, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
    }

    public AddressBook() {
    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
       this.phoneNumbers = addressBookDTO.getPhoneNumbers();
       this.email = addressBookDTO.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
