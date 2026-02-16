package com.example.demo.service;

import com.example.demo.model.Arithmeticmodel;
import com.example.demo.model.SampleModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ArithmeticService {

    private List<Arithmeticmodel> audit = new ArrayList<>();
    public int sum(int first, int second){
        String tipe = "Sum";
        audit.add(addAudit(first, second, tipe));
        return first + second;
    }

    public int substruct(int first, int second){
        String tipe = "Substruct";
        audit.add(addAudit(first, second, tipe));
        return first + second;
    }

    public int multiply(int first, int second){
        String tipe = "Multiply";
        audit.add(addAudit(first, second, tipe));
        return first * second;
    }

    public double devide(int first, int second){
        String tipe = "Devide";
        audit.add(addAudit(first, second, tipe));
        return 1.0 * first / second;
    }
    public List<Arithmeticmodel> getAudit(){
        return audit;
    }
    private Arithmeticmodel addAudit(int first, int second, String operationType){
        Arithmeticmodel audit  = new Arithmeticmodel();
        audit.setId(new Random().nextInt(Integer.MAX_VALUE));
        audit.setOperationalType(operationType);
        audit.setFirst(first);
        audit.setSecond(second);
        audit.setCreatedAt(LocalDateTime.now());
        return audit;
    }
    public void testOutput(){
        System.out.println(new SampleModel().getDest());
    }
}
