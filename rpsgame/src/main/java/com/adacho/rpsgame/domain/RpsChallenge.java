package com.adacho.rpsgame.domain;

import com.adacho.rpsgame.enums.GameResult;
import com.adacho.rpsgame.enums.RockPaperScissors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class RpsChallenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private final User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "rpsplay_id")	
	private final Rps rps;
	
	private final RockPaperScissors opponent;
	
	private final GameResult gameResult;
	
	RpsChallenge() {
		user = null;
		rps = null;
		opponent = null;
		gameResult = null;
	}
}
