package br.com.comics;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTimeApiTest {

	@Test
	void duration() {
		Duration duration = Duration.between(LocalDateTime.of(2019, 9, 25, 20, 0),
				LocalDateTime.of(2019, 12, 25, 0, 0));
		Assertions.assertEquals(duration.toHours(), 2164);
	}

	@Test
	void instant() {
		Instant instant = Instant.ofEpochSecond(300);
		LocalDateTime localDateTime = LocalDateTime.of(2019, 9, 25, 20, 0);
		localDateTime = localDateTime.plusSeconds(instant.getEpochSecond());
		Assertions.assertEquals(LocalDateTime.of(2019, 9, 25, 20, 5), localDateTime);
	}

	@Test
	void with() {
		LocalDateTime localDateTime = LocalDateTime.of(2019, 9, 25, 20, 0);
		Duration duration = Duration.ofHours(5).plusMinutes(30);
		localDateTime = localDateTime.with(d -> d.plus(duration));
		Assertions.assertEquals(LocalDateTime.of(2019, 9, 26, 1, 30), localDateTime);
	}

	@Test
	void range() {
		LocalDateTime localDateTime = LocalDateTime.of(2019, 9, 25, 20, 0);
		ValueRange range = localDateTime.range(ChronoField.DAY_OF_MONTH);
		Assertions.assertEquals(range.getMaximum(), 30);
	}

}
