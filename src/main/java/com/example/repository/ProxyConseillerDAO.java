package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Conseiller;

public interface ProxyConseillerDAO extends JpaRepository<Conseiller, Long> {

}
