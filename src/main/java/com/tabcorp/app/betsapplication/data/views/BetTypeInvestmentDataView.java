package com.tabcorp.app.betsapplication.data.views;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.tabcorp.app.betsapplication.data.BetType;

public class BetTypeInvestmentDataView {

	@Enumerated(EnumType.STRING)
	BetType betType;
	BigDecimal totalInvestment;


	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public BigDecimal getInvestmentAmount() {
		return totalInvestment;
	}

	public void setInvestmentAmount(BigDecimal investmentAmount) {
		this.totalInvestment = investmentAmount;
	}

}
