package com.zidio.employee.service.impl;

import com.zidio.employee.dto.EmployeeDTO;
import com.zidio.employee.entity.Employee;
import com.zidio.employee.enums.EmployeeStatus;
import com.zidio.employee.repository.EmployeeRepository;
import com.zidio.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        dto.setStatus(employee.getStatus());
        return dto;
    }

    private Employee mapToEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setStatus(dto.getStatus() != null ? dto.getStatus() : EmployeeStatus.ACTIVE);
        return emp;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee emp = mapToEntity(dto);
        return mapToDTO(repository.save(emp));
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Optional<Employee> existing = repository.findById(id);
        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setFirstName(dto.getFirstName());
            emp.setLastName(dto.getLastName());
            emp.setEmail(dto.getEmail());
            emp.setDepartment(dto.getDepartment());
            emp.setStatus(dto.getStatus());
            return mapToDTO(repository.save(emp));
        }
        throw new RuntimeException("Employee not found with id " + id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}