package com.example.demo.repository;

import com.example.demo.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgoRepository extends JpaRepository<MessageEntity, Long> {


}
