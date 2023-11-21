package com.adacho.rpsgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adacho.rpsgame.domain.Rps;

public interface RpsRepository extends JpaRepository<Rps , Long>{

}
