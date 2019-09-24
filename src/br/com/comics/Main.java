package br.com.comics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		//firstExercise();
		
		secondExercise();
	}

	private static void secondExercise() {
		Comic superman = new Comic("Superman", 1987);
		Comic flash = new Comic("Flash", 1989);
		Comic batman = new Comic("Batman", 1985);
		Comic arrow = new Comic("Arrow", 1990);
		
		Collection<Comic> comics = Arrays.asList(superman, flash, batman, arrow);
		comics.stream().map(c -> c.name).filter(n -> n.contains("man")).forEach(System.out::println);
		
		long count = Stream.of(superman, flash, batman, arrow).peek(c -> System.out.println(c.name + " - " + c.year)).count();
		System.out.println("Quantidade de quadrinhos: " + count);
	}

	private static void firstExercise() {
		String[] hqs = {"Aquaman", "Superman", "Batman", "Harley", "Flash" };
		
		Comparator<String> sortBySizeDesc = (nome1, nome2) -> nome2.length() - nome1.length();
		
		Arrays.sort(hqs, sortBySizeDesc);
		for (String nome : hqs) {
			System.out.println(nome);
		}
	}

}
