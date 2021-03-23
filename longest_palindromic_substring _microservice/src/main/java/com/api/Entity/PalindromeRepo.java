package com.api.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PalindromeRepo extends JpaRepository<Palindrome,Long> {
    @Override
    Optional<Palindrome> findById(Long aLong);


    List<Palindrome> findByInputString(String inputString);

}
