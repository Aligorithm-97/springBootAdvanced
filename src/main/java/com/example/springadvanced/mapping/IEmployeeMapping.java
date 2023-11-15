package com.example.springadvanced.mapping;

import com.example.springadvanced.dto.EmployeeDto;
import com.example.springadvanced.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IEmployeeMapping {
    IEmployeeMapping INSTANCE = Mappers.getMapper(IEmployeeMapping.class);
    //@Mapping(source = "firstName",target = "name") Eğer ismi değişik field varsa bu şekilde tek tek verilmeli
    //@Mapping(source = "weight",target = "customerDetails.weight") Eğer birden fazla customer objesi varsa ayrı fieldların tutulduğu
    @Mapping(source = "name",target = "firstName")
    @Mapping(source = "surname",target = "lastName")
    Employee toEmployee(EmployeeDto employeeDto); // Eğer tüm fieldlar aynıysa bu kadar yeterli
    @Mapping(source = "firstName",target = "name")
    @Mapping(source = "lastName",target = "surname")
    EmployeeDto toEmployeeDto(Employee employee);
}
