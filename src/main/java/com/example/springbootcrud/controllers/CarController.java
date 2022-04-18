package com.example.springbootcrud.controllers;

import com.example.springbootcrud.entities.CarEntity;
import com.example.springbootcrud.repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarRepository carRepository;


    @GetMapping(value="checkAPI")
    public String checkAPI() {
        return "Hello World";
    };

    @GetMapping(value="getAll")
    public List<CarEntity> getAll() {
        return carRepository.findAll();
    }

    @GetMapping(value="getById")
    public CarEntity getById(@RequestParam int id) {
        return carRepository.findById(id).get();
    }

    @GetMapping(value="deleteById")
    public List<CarEntity> deleteById(@RequestParam int id) {
        carRepository.deleteById(id);
        List<CarEntity> carList = carRepository.findAll();
        return carList;
    }

    @PostMapping(value="addNewCar")
        public CarEntity addNewCar(@RequestBody CarEntity param) {

            carRepository.save(param);
            return param;
        }

    @PostMapping(value="updateCar")
        public CarEntity updateCar(@RequestBody CarEntity param) {
            return carRepository.save(param);
        }

};