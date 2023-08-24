package com.example.mapper;

import com.example.dto.PersonDto;
import com.example.entity.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mapper {

    public static PersonDto toPersonDto(Person dto) {
        return PersonDto.builder()
        		.firstName(dto.getFirstName())
        		.lastName(dto.getLastName())
        		.email(dto.getEmail())
        		.gender(dto.getGender())
        		.build();

    }

    public static Person toEntity(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .gender(personDto.getGender())
                .build();
    }

}
