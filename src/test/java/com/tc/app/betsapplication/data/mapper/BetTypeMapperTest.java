package com.tc.app.betsapplication.data.mapper;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tc.app.betsapplication.data.views.BetTypeInvestmentDataView;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BetTypeMapperTest {

	private BetTypeMapper obj;
	@Mock
	ResultSet rs;

	@Before
	public void setUp() {

		obj = new BetTypeMapper();
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testWrongValueReturnedForInvestment() throws SQLException {
		exception.expect(NumberFormatException.class);
		when(rs.getString(anyString())).thenReturn("DOUBLE");
		try {
			BetTypeInvestmentDataView view = obj.mapRow(rs, 1);
		} catch (SQLException e) {
			fail("Failed to map data");
		}

	}

	@Test
	public void testWrongValueReturnedForBet() throws SQLException {
		exception.expect(IllegalArgumentException.class);
		when(rs.getString(anyString())).thenReturn("10");
		try {
			BetTypeInvestmentDataView view = obj.mapRow(rs, 1);
		} catch (SQLException e) {
			fail("Failed to map data");
		}

	}
}
