package com.code.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;

  private String username;
  private String name;
  private String email;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
