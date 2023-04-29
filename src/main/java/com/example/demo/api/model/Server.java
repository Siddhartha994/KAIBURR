package com.example.demo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "servers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {

  @Id
  private String id;
  private String name;
  private String language;
  private String framework;

  // public Server(int id, String name, String language, String framework) {
  //   this.id = id;
  //   this.name = name;
  //   this.language = language;
  //   this.framework = framework;
  // }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public String getFramework() {
    return framework;
  }
  public void setFramework(String framework) {
    this.framework = framework;
  }
} 
