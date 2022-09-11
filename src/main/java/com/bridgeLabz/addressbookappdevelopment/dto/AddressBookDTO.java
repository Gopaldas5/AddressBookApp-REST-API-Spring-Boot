package com.bridgeLabz.addressbookappdevelopment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {


    @NotEmpty(message = "AddressBook name can not be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,25}$", message = "Not a valid Name : It should at least 3 characters  ")
    private String firstName;
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,25}$", message = "Not a valid Name : It should at least 3 characters  ")
    private String lastName;
    private String address;
    private String city;
    private List<String> phoneNumbers;
    private String email;
}


