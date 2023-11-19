package com.example.springadvanced.dto;

import com.example.springadvanced.validation.notContains.NotContains;
import com.example.springadvanced.validation.notStartWith.NotStartWith;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data //do not use it not recommended instead use specific encapsulation for fields
@NoArgsConstructor
@NotContains({"abc","asd"})
public class EmployeeDto {
    private String name;
    private String surname;
    @NotStartWith({"http","https"})
    @NotEmpty
    @NotNull
    private String userName;
    private String password;
    private Integer weight;
    private Integer height;
    @NotStartWith({"http","https"})
    private String department;

}
