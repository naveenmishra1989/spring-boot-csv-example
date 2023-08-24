package com.example.dto;

import com.example.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDto {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    public static Person toPerson(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .gender(personDto.getGender())
                .build();
    }

    public static PersonDto toPersonDto(Person person) {
        return PersonDto.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .gender(person.getGender())
                .build();

    }

}
