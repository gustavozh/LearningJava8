package br.com.comics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Java7Test {

	@Test
	public void safeVarargs() {
		teste(1_000, 05);
		testeList(Arrays.asList(6, 0_6), Arrays.asList(0xFF_FF, 0b1000_0000));
	}

	@SafeVarargs
	public final static <T> void teste(T... objeto) {
		T[] meuT = objeto;
		Object[] objetosT = objeto;
		Assertions.assertEquals(meuT[0], 1000);
		Assertions.assertEquals(objetosT[1], 5);
	}

	@SafeVarargs
	private static <T> void testeList(List<T>... listasT) {
		List<T>[] meusT = listasT;
		List<T> meuT = new LinkedList<>(meusT[0]);
		Object[] objetosT = listasT;
		Object objetoT = objetosT[1];
		Assertions.assertEquals(meuT.get(1), 6);
		Assertions.assertEquals(((List) objetoT).get(1), 128);
	}

	@Test
	public void switchString() {
		String comic = "Batman";
		String result = null;
		switch (comic) {
		case "Batman":
		case "Superman":
		case "Aquaman":
			result = "Usam capa";
			break;
		default:
			result = "Não usam capa";
		}
		Assertions.assertEquals("Usam capa", result);
	}

	@Test(expected = FileNotFoundException.class)
	public void tryResources() throws FileNotFoundException {
		File file = Paths.get("./test/br/com/comics/teste").toFile();
		try (FileReader fileReader = new FileReader(file)) {
			Assertions.assertFalse(file.exists());
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
