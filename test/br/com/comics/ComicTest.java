package br.com.comics;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ComicTest {

	Collection<Comic> comics = Arrays.asList(new Comic("Superman", 1987), new Comic("Flash", 1989),
			new Comic("Batman", 1985), new Comic("Arrow", 1990));

	@Test
	void flatMap() {
		Assert.assertEquals("Superman", String.copyValueOf(comics.stream()
				.flatMap(c -> Arrays.asList(c.name.toCharArray()).stream()).findFirst().orElse(new char[] {})));
	}

	@Test
	void reduce() {
		Assert.assertEquals("SupermanFlashBatmanArrow",
				comics.stream().map(c -> c.name).reduce((c1, c2) -> c1.concat(c2)).orElse(""));
	}

	@Test
	void collect() {
		Assert.assertEquals("Superman - Flash - Batman - Arrow",
				comics.stream().map(c -> c.name).collect(Collectors.joining(" - ")));
	}

}
