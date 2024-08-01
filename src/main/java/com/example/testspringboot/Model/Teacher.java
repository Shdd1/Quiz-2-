package com.example.testspringboot.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5,max = 8,message = "name character must between 5-8")
    private String name;
    @NotNull(message = "id should not be null)")
    @Min(value = 3,message = "id must be 3 or more")
    private int id;
    @NotNull(message = "salary should not be null")
    @Min(value = 7000)
    private int salary;
}
