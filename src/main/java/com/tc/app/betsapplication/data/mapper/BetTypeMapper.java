package com.tc.app.betsapplication.data.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tc.app.betsapplication.data.BetType;
import com.tc.app.betsapplication.data.views.BetTypeInvestmentDataView;

public class BetTypeMapper implements RowMapper<BetTypeInvestmentDataView> {

	@Override
	public BetTypeInvestmentDataView mapRow(ResultSet rs, int rowNum) throws SQLException {
		BetTypeInvestmentDataView betTypeInvestmentData = new BetTypeInvestmentDataView();
		betTypeInvestmentData.setBetType(BetType.valueOf(rs.getString("betType")));
		betTypeInvestmentData.setInvestmentAmount(new BigDecimal(rs.getString("investment")));
		return betTypeInvestmentData;
	}

}
