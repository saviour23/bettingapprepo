package com.tc.app.betsapplication.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tc.app.betsapplication.data.BetType;
import com.tc.app.betsapplication.data.views.BetTypeCountView;

public class BetsCountMapper implements RowMapper<BetTypeCountView> {

	@Override
	public BetTypeCountView mapRow(ResultSet rs, int rowNum) throws SQLException {

		BetTypeCountView betCountView = new BetTypeCountView();
		betCountView.setBetType(BetType.valueOf(rs.getString("betType")));
		betCountView.setCount(Integer.parseInt(rs.getString("betcount")));
		return betCountView;
	}

}
