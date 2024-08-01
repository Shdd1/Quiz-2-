package com.example.testspringboot.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "id can not be null")
    @Min(value = 3,message = "id must be 3 or more")
    private int id;
    @NotEmpty(message = "name can not be empty")
    @Size(min = 5,max = 8,message = "name character must between 5-8")
    private String name;
    @NotNull(message = "age can not be null")
    @Max(value = 30,message = "age must be between 22-30")
    @Min(value = 22)
    private int age;
    @NotEmpty(message = "major can not be empty")
    private String major;
}
