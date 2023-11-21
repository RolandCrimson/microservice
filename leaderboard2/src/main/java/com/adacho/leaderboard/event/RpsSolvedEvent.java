package com.adacho.leaderboard.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RpsSolvedEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7055561106743916191L;
	private final Long rpsChallengeId;
	private final Long userId;
	private final String outcome;

	// JSON 역직렬화에 필요(추가)
	RpsSolvedEvent() {
		this.rpsChallengeId = 0L;
		this.userId = 0L;
		this.outcome = null;
	}
}
