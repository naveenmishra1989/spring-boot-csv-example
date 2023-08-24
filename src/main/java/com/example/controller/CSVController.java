package com.example.controller;

import com.example.dto.PersonDto;
import com.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CSVController {

    private final PersonService personService;

    @PostMapping("/upload")
    public ResponseEntity<String> saveToDatabase(@RequestParam("file") MultipartFile file) throws IOException {

        String saveData = personService.saveData(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveData);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<PersonDto>> persons(){
        return ResponseEntity.ok(personService.findAll());
    }
}
