package com.adacho.rpsgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adacho.rpsgame.domain.RpsChallenge;

public interface RpsChallengeRepository extends JpaRepository<RpsChallenge, Long>{
	List<RpsChallenge> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}
