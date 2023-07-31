package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.CompteCourant;

public interface ProxyCompteCourantDAO extends JpaRepository<CompteCourant, Long> {

}
