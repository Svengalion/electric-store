package com.svengali.employee;

import com.svengali.employee.entity.Employee;
import com.svengali.employee.repository.EmployeeRepository;
import com.svengali.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Employee emp1 = new Employee(1L, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 1, 1), 10L, 100L, true);
        Employee emp2 = new Employee(2L, "Petrov", "Petr", "Petrovich", LocalDate.of(1990, 2, 2), 11L, 101L, false);
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> result = employeeService.findAll();
        assertEquals(2, result.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Employee emp = new Employee(1L, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1980, 1, 1), 10L, 100L, true);
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(emp));

        Employee result = employeeService.findById(1L);
        assertNotNull(result);
        assertEquals("Ivanov", result.getLastName());
        verify(employeeRepository, times(1)).findById(1L);
    }
}
