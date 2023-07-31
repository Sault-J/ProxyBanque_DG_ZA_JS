package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Compte;

public interface ProxyCompteDAO extends JpaRepository<Compte, Long>  {

}
