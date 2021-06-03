package com.tactfactory.enchere;

import java.util.Arrays;
import java.util.List;

public class ExempleLambda {

	private List<Integer> numbers = Arrays.asList(1, 4, 41, 5, 8);

	public void forI() {
		for (int i = 0; i < numbers.size(); ++i) {
			System.out.println(numbers.get(i));
		}
	}

	public void iterator() {
		for (int value : numbers) {
			System.out.println(value);
		}
	}

	public void lambda() {
		numbers.stream().forEach(System.out::println);
	}

	public void lambda2() {
		numbers.stream().forEach(this::monPrint);
		numbers.stream().forEach(value -> System.out.println(value + "² = " + (value * value)));

		int nb = numbers
			.stream()
			.filter(v -> v % 2 == 0) 		// On garde 4 et 8 (les valeurs paires).
			.map(v -> v * v)				// Mise au carré de chaque valeurs : 16 et 64
			.reduce((acc, v) -> acc + v)    // Somme des valeurs restantes : 16 + 64 = 80
			.get();

		// La meme chose en JS.
//		const nb = numbers
//			.filter(v => v % 2 === 0)
//			.map(v => v * v) // Ou v ** 2
//			.reduce((acc, v) => acc + v);

		// C++ (function)
		// auto fonction = [](int value) { std::cout << value << std::endl; };

		// JS ES6 (arrow function)
		// const fonction = value => console.log(value);
	}

	private void monPrint(int value) {
		System.out.println(value + "² = " + (value * value));
	}
}
