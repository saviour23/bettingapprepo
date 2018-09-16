package com.tc.app.betsapplication.data.mapper;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

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

@RunWith(SpringRunner.class)
@DataJpaTest
public class BetsHourlySoldMapperTest {

	private BetsHourlySoldMapper obj;
	@Mock
	ResultSet rs;

	@Before
	public void setUp() {

		obj = new BetsHourlySoldMapper();
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testWrongValueReturnedForCount() throws SQLException {
		exception.expect(NumberFormatException.class);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");
		when(rs.getString(anyString())).thenReturn(LocalDateTime.now().format(dateFormatter));
		try {
			BetsSoldHourlyView view = obj.mapRow(rs, 1);
		} catch (SQLException e) {
			fail("Failed to map data");
		}

	}

	@Test
	public void testWrongValueReturnedForDate() throws SQLException {
		exception.expect(DateTimeParseException.class);
		when(rs.getString(anyString())).thenReturn("10");
		try {
			BetsSoldHourlyView view = obj.mapRow(rs, 1);
		} catch (SQLException e) {
			fail("Failed to map data");
		}

	}

}
