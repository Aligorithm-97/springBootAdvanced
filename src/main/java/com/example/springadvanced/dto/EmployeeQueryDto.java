package com.example.springadvanced.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class EmployeeQueryDto {
    private String name;
    private String surname;
    private Integer weight;
    private Integer height;
    private List<String> hobby;
    private String department;
}
