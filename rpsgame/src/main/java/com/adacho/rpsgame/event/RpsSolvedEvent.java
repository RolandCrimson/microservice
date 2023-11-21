package com.adacho.rpsgame.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RpsSolvedEvent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7508228804287744855L;
	private final Long rpsChallengeId;
	private final Long userId;
	private final String outcome;
}
