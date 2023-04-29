package com.example.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.api.model.Server;
import com.example.demo.service.ServerService;

@RestController
@RequestMapping("/servers")
public class ServerController {

  private ServerService serverService;

  @Autowired
  public ServerController(ServerService serverService) {
    this.serverService = serverService;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping
  public List<Server> getServer() {
    List<Server> servers = serverService.getServer();
    return servers;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/{id}")
  public ResponseEntity<Optional<Server>> getServer(@PathVariable("id") String id) {
    Optional<Server> server = Optional.ofNullable(serverService.getServer(id));
    if (server.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(server, HttpStatus.OK);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/search/{name}")
  public ResponseEntity<List<Server>> getServerByName(@PathVariable("name") String name) {
    List<Server> servers = serverService.getServerByName(name);
    if (servers.size() == 0) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(servers, HttpStatus.OK);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping
  public Server createServer(@RequestBody Server server) {
    return serverService.createServer(server);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PutMapping
  public ResponseEntity<Server> updateServer(@RequestBody Server updatedServer) {
    Optional<Server> server = Optional.ofNullable(serverService.getServer(updatedServer.getId()));
    if (server.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Server updated_server = serverService.updateServer(updatedServer);
    return new ResponseEntity<>(updated_server, HttpStatus.OK);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @DeleteMapping("/{id}")
  public ResponseEntity<Server> deleteServer(@PathVariable("id") String id) {
    Optional<Server> server = Optional.ofNullable(serverService.getServer(id));
    if (server.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    serverService.deleteServer(id);
    return ResponseEntity.noContent().build();
  }
}
