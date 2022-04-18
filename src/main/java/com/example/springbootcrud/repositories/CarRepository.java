package com.example.springbootcrud.repositories;

import com.example.springbootcrud.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends  JpaRepository<CarEntity, Integer>{
    
}
