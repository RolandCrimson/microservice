package com.adacho.rpsgame.service;

import org.springframework.stereotype.Service;

import com.adacho.rpsgame.enums.RockPaperScissors;

@Service
public class RandomGeneratorService {
	public RockPaperScissors getRockPaperScissors() {
		return RockPaperScissors.randomRps();
	}
}
