package com.api.controllers;

import com.api.Entity.Palindrome;
import com.api.Entity.PalindromeRepo;
import com.api.Services.Solution_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class problems_1 {

    PalindromeRepo palindromeRepo;
    Solution_Service solution_service;

    @Autowired
    problems_1(PalindromeRepo palindromeRepo,Solution_Service solution_service){
        this.palindromeRepo=palindromeRepo;
        this.solution_service=solution_service;
    }



    @PostMapping("post/{str}")
    public ResponseEntity<Palindrome> post(@PathVariable String str){
        Palindrome palindrome=new Palindrome();
        palindrome.setInputString(str);
        palindrome.setLongestPalindromicSubstring(solution_service.longestPalindromicSubstring(str));
        palindromeRepo.save(palindrome);
        return ResponseEntity.ok(palindrome);
    }

    @GetMapping("get/{str}")
    public ResponseEntity<List<Palindrome>> get(@PathVariable String str){
        List<Palindrome> res=palindromeRepo.findByInputString(str);
        if (res.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(palindromeRepo.findByInputString(str));
    }

}
