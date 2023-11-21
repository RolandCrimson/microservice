package com.adacho.rps.service;

import org.springframework.stereotype.Service;

import com.adacho.rps.Enum.RockPaperScissors;

@Service
public class RandomGeneratorService {
	public RockPaperScissors getRockPaperScissors() {
		return RockPaperScissors.randomRps();
	}
}
