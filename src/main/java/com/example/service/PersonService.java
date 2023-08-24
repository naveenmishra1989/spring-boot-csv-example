package com.example.service;

import com.example.dto.PersonDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    String saveData(MultipartFile file);

    List<PersonDto> findAll();
}
