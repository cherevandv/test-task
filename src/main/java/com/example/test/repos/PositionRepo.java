package com.example.test.repos;

import com.example.test.models.Employee;
import com.example.test.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PositionRepo extends JpaRepository<Position, Long> {
    List<Position> findByEmployeeId(Integer id);
}
