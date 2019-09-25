package br.com.comics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BufferedReaderComicTest {

	@Test
	void linesBuffered() {
		try(BufferedReader reader = new BufferedReader(new FileReader("./test/br/com/comics/BufferedReaderComicTest.java"));
				Stream<String> line = reader.lines();) {
			String lineOne = line.findFirst().orElse("");
			Assert.assertEquals("package br.com.comics;", lineOne);
		} catch (IOException e) {
			throw new RuntimeException("Deu ruim!");
		}
	}
	
	@Test
	void lines() {
		try(Stream<String> line = Files.lines(Paths.get("./test/br/com/comics/BufferedReaderComicTest.java"));) {
			String lineOne = line.findFirst().orElse("");
			Assert.assertEquals("package br.com.comics;", lineOne);
		} catch (IOException e) {
			throw new RuntimeException("Deu ruim!");
		}
	}
	
	@Test
	void walk() {
		try(Stream<Path> line = Files.walk(Paths.get("./test/br/com/comics"));) {
			long paths = line.count();
			Assert.assertEquals(3, paths);
		} catch (IOException e) {
			throw new RuntimeException("Deu ruim!");
		}
	}
	
	@Test
	void find() {
		try(Stream<Path> line = Files.find(Paths.get("./test/br/com/comics"), 1, (p, b) -> p.isAbsolute())) {
			long paths = line.count();
			Assert.assertEquals(0, paths);
		} catch (IOException e) {
			throw new RuntimeException("Deu ruim!");
		}
	}

}
