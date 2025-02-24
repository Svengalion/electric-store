package com.svengali.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;

    private LocalDate birthDate;

    // Храним идентификатор должности (ссылка на PositionType в directory-service)
    private Long positionId;

    // Храним идентификатор магазина (ссылка на Shop в directory-service)
    private Long shopId;

    // Пол: true - мужской, false - женский
    private Boolean gender;
}
