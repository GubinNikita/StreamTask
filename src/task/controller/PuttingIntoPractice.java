package task.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import task.entity.Trader;
import task.entity.Transaction;

public class PuttingIntoPractice {

	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		/*
		 * 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к
		 * большей).
		 */
		System.out.println("Транзакции за 2011 год:");
		transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
				.forEach(System.out::println);

		/*
		 * 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
		 */
		System.out.println("\nНеповторяющиеся города трейдеров:");
		Stream.of(raoul, mario, alan, brian).map(t -> t.getCity()).distinct().forEach(System.out::println);

		/*
		 * 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
		 */
		System.out.println("\nТрейдеры из Кембриджа:");
		Stream.of(raoul, mario, alan, brian).filter(t -> t.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);

		/*
		 * 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
		 * порядке.
		 */
		System.out.println("\nОтсортированные имена трейдеров:");
		String str = Stream.of(raoul, mario, alan, brian).map(t -> t.getName()).sorted()
				.collect(Collectors.joining("\s"));
		System.out.println(str);

		/*
		 * 5. Выяснить, существует ли хоть один трейдер из Милана.
		 */
		System.out.println("\nСуществуют ли трейдеры из Милана:");
		boolean isExist = Stream.of(raoul, mario, alan, brian).anyMatch(t -> t.getCity().equals("Milan"));
		System.out.println(isExist);

		/*
		 * 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
		 */
		System.out.println("\nСуммы транзакций трейдеров из Кембриджа:");
		transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(t -> t.getValue())
				.forEach(System.out::println);

		/*
		 * 7. Какова максимальная сумма среди всех транзакций?
		 */
		System.out.println("\nМаксимальное значение транзакций:");
		int max = transactions.stream().map(t -> t.getValue()).max(Integer::compare).get();
		System.out.println(max);

		/*
		 * 8. Найти транзакцию с минимальной суммой.
		 */
		System.out.println("\nТранзакция с минимальной суммой:");
		int min = transactions.stream().map(t -> t.getValue()).min(Integer::compare).get();
		Transaction trans = transactions.stream().filter(t -> t.getValue() == min).findAny().get();
		System.out.println(trans);

	}

}