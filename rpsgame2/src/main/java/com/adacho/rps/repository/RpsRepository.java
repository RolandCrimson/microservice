package com.adacho.rps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adacho.rps.domain.Rps;

public interface RpsRepository extends JpaRepository<Rps , Long>{

}
