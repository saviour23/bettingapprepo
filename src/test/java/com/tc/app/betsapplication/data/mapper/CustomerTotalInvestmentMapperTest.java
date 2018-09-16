package com.tc.app.betsapplication.data.mapper;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tc.app.betsapplication.data.views.BetsSoldHourlyView;
import com.tc.app.betsapplication.data.views.CustomerInvestmentDataView;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerTotalInvestmentMapperTest {

	private CustomerTotalInvestmentMapper obj;
	@Mock
	ResultSet rs;

	@Before
	public void setUp() {

		obj = new CustomerTotalInvestmentMapper();
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testWrongValueReturnedForInvestment() throws SQLException {
		exception.expect(NumberFormatException.class);
		when(rs.getString(anyString())).thenReturn("customerId");
		try {
			CustomerInvestmentDataView view = obj.mapRow(rs, 1);
		} catch (SQLException e) {
			fail("Failed to map data");
		}

	}

	@Test
	public void testMapRow() throws SQLException {
		when(rs.getString(anyString())).thenReturn("10");
		try {
			CustomerInvestmentDataView view = obj.mapRow(rs, 1);
			assertEquals(BigDecimal.TEN,view.getTotalInvestment());
		} catch (SQLException e) {
			fail("Failed to map data");
		}

	}

}

