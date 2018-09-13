package com.tabcorp.app.betsapplication.data.views;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.tabcorp.app.betsapplication.data.BetType;

public class BetTypeCountView {

	@Enumerated(EnumType.STRING)
	BetType betType;
	int count;

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
