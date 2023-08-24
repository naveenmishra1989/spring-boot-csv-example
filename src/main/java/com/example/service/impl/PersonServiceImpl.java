package com.example.service.impl;

import com.example.dto.PersonDto;
import com.example.entity.Person;
import com.example.mapper.Mapper;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @SneakyThrows
    @Override
    public String saveData(MultipartFile file) {
        Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        // Iterate over the records in the CSV file
        CSVReader csvReader = new CSVReader(reader);
        List<Person> people = csvReader.readAll().stream()
                .map(s -> new PersonDto(s[0], s[1], s[2], s[3]))
                .map(Mapper::toEntity).collect(Collectors.toList());
        repository.saveAll(people);
        return "total person saved: "+people.size();
    }


    @Override
    public List<PersonDto> findAll() {
        return repository.findAll().stream().map(Mapper::toPersonDto)
                .collect(Collectors.toList());
    }
}
