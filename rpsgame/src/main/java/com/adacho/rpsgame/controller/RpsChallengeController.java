package com.adacho.rpsgame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adacho.rpsgame.domain.Rps;
import com.adacho.rpsgame.domain.RpsChallenge;
import com.adacho.rpsgame.domain.User;
import com.adacho.rpsgame.dto.ResultDto;
import com.adacho.rpsgame.enums.RockPaperScissors;
import com.adacho.rpsgame.service.RpsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/results")
public class RpsChallengeController {
	private final RpsService rpsService;

	@PostMapping
	Map<String, String> postResult(@RequestParam(value = "userAlias") String userAlias,
			@RequestParam(value = "userChoice") String userChoice) {
		log.info("Received new attempt from {}", userAlias);
		User user = new User(userAlias);
		log.info("userChoice: " + userChoice);
		Rps rps = new Rps(stringToRockPaperScissors(userChoice));

		RpsChallenge rpsChallenge = new RpsChallenge(user, rps, null, null);
		Map<String, String> map = rpsService.chackChallenge(rpsChallenge);
		log.info("outcome: " + map.get("outcome"));
		log.info("opponent: " + map.get("opponent"));
		return map;
	}
	
	private RockPaperScissors stringToRockPaperScissors(String code) {
		RockPaperScissors result = null;
		for(RockPaperScissors rps: RockPaperScissors.values()) {
			log.info("RockPaperScissors value: " + rps.getCommentary());
			if (rps.getCommentary().equals(code)) {
				result =  rps;
				break;
			}
		}
		return result;
	}
	
	@GetMapping
	List<ResultDto> getStatistics(@RequestParam("alias") String alias) {
		List<RpsChallenge> challenges = rpsService.getStatsForUser(alias);
		List<ResultDto> results = new ArrayList<ResultDto>();
		for(RpsChallenge challenge: challenges) {
			ResultDto result = new ResultDto(challenge.getId(), challenge.getRps().getChallenge().getCommentary(),
					challenge.getOpponent().getCommentary(), challenge.getGameResult().getCommentary(),
					challenge.getUser().getId());
			results.add(result);
		}
		return results;
	}
}
