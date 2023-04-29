package com.example.demo.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.Server;
import com.example.demo.repository.ServerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

  @Autowired
  private ServerRepository repository;
  
  public Server createServer(Server server) {
    ObjectId id = new ObjectId();
    server.setId(id.toString());
    return repository.save(server);
  }

  public List<Server> getServer() {
    return repository.findAll();
  }

  public Server getServer(String id) {
    Optional<Server> optionalServer = repository.findById(id);
    return optionalServer.orElse(null);
  }

  public List<Server> getServerByName(String name) {
    List<Server> servers = repository.findByNameContainingIgnoreCase(name);
    return servers;
  }

  public Server updateServer(Server updatedServer) {
    Server existingServer = repository.findById(updatedServer.getId()).get();
    // if (existingServer == null) {

    // }
    existingServer.setName(updatedServer.getName());
    existingServer.setLanguage(updatedServer.getLanguage());
    existingServer.setFramework(updatedServer.getFramework());
    return repository.save(existingServer);
  }

  public void deleteServer(String id) {
    repository.deleteById(id);
    return;
  }
}
