package com.example.demo.controller;

import com.example.demo.model.Arithmeticmodel;
import com.example.demo.service.ArithmeticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/arithmetics")
@RequiredArgsConstructor
public class AriphmeticController {


    private final ArithmeticService arithmeticService;

    @PostMapping("/sum")
    public ResponseEntity<Integer> sumMethod(@RequestParam  int firstInt, @RequestParam int secondInt)
    {
        Integer result = arithmeticService.sum(firstInt, secondInt);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/subtract")
    public ResponseEntity<Integer> subtractMethod(@RequestParam  int firstInt,@RequestParam int secondInt)
    {
        Integer result = arithmeticService.substruct(firstInt, secondInt);
        return new ResponseEntity<> (result, HttpStatus.OK);
    }

    @PostMapping("/devide")
    public ResponseEntity<Double>devideMethod(@RequestParam  int firstInt,@RequestParam int secondInt)
    {
        Double result = arithmeticService.devide(firstInt, secondInt);
        return new ResponseEntity<> (result, HttpStatus.OK);
    }

    @PostMapping("/multiply")
    public ResponseEntity<Integer> multiplyMethod(@RequestParam  int firstInt,@RequestParam int secondInt)
    {
        Integer result = arithmeticService.multiply(firstInt, secondInt);
        return new ResponseEntity<> (result, HttpStatus.OK);
    }

    @GetMapping("/audits")
    public ResponseEntity<List<Arithmeticmodel>> getAudits(){


        return new ResponseEntity<> (arithmeticService.getAudit(), HttpStatus.OK);
    }

}
