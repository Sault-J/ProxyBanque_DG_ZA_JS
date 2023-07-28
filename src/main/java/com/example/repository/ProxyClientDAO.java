package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Client;

public interface ProxyClientDAO extends JpaRepository<Client, Long> {

}
