package com.tc.app.betsapplication.data.views;

import java.math.BigDecimal;

public class CustomerInvestmentDataView {

	String customerId;
	BigDecimal totalInvestment;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(BigDecimal totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

}
