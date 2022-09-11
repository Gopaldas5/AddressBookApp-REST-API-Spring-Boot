package com.bridgeLabz.addressbookappdevelopment.repository;


import com.bridgeLabz.addressbookappdevelopment.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

    @Query(value = "SELECT * FROM address_book e WHERE e.first_name = :firstName", nativeQuery = true)
    List<AddressBook> findBookByName(@Param("firstName") String firstName);

//    @Query(value = "SELECT * FROM book e WHERE e.id = :id", nativeQuery = true)
//    AddressBook getBooksById(@Param("id")int id);
}
