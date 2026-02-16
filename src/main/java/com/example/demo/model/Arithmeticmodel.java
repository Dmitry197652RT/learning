package com.example.demo.model;

import com.example.demo.service.ArithmeticService;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;


public class Arithmeticmodel {

    private long id;
    private int first;
    private int second;
    private int result;
    private String operationalType;
    private LocalDateTime createdAt;

    public Arithmeticmodel(long id, int first, int second, int result, String operationalType, LocalDateTime createdAt) {
        this.id = id;
        this.first = first;
        this.second = second;
        this.result = result;
        this.operationalType = operationalType;
        this.createdAt = createdAt;
    }

    public Arithmeticmodel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getOperationalType() {
        return operationalType;
    }

    public void setOperationalType(String operationalType) {
        this.operationalType = operationalType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
