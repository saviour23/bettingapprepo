package com.tabcorp.app.betsapplication.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "betting_data")
public class BettingData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotNull
	@Column(name = "customer_id")
	private String customerId;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@NotEmpty
	@Column(name = "pro_number")
	private String propNumber;

	// @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "bet_type")
	private BetType betType;
	@NotNull
	@Column(name = "investment")
	private BigDecimal investment;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getPropNumber() {
		return propNumber;
	}

	public void setPropNumber(String propNumber) {
		this.propNumber = propNumber;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public BigDecimal getInvestment() {
		return investment;
	}

	public void setInvestment(BigDecimal investment) {
		this.investment = investment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
