package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.api.model.Server;

public interface ServerRepository extends MongoRepository<Server, String>{
  List<Server> findByNameContainingIgnoreCase(String name);
}
