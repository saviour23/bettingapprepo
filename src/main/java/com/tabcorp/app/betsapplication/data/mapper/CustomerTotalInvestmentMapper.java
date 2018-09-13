package com.tabcorp.app.betsapplication.data.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tabcorp.app.betsapplication.data.views.CustomerInvestmentDataView;

public class CustomerTotalInvestmentMapper implements RowMapper<CustomerInvestmentDataView> {

	@Override
	public CustomerInvestmentDataView mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomerInvestmentDataView customerInvestmentData = new CustomerInvestmentDataView();
		customerInvestmentData.setCustomerId(rs.getString("customerId"));
		customerInvestmentData.setTotalInvestment(new BigDecimal(rs.getString("investment")));
		return customerInvestmentData;
	}

}
