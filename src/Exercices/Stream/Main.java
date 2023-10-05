package Exercices.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader trader1 = new Trader("Abdallah", "Cambridge");
        Trader trader2 = new Trader("Audrey", "Milan");
        Trader trader3 = new Trader("Corentin", "Paris");
        Trader trader4 = new Trader("Tristan", "Paris");

        List<Transaction> transactions = Arrays.asList(new Transaction(trader1, 2011, 500), new Transaction(trader2, 2012, 300), new Transaction(trader3, 2012, 1000), new Transaction(trader4, 2011, 400));

        List<Transaction> transactionList = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .toList();

        System.out.println(transactionList);

        System.out.println("Exercice 2");

        List<String> villes = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        villes.forEach(System.out::println);

        System.out.println("Exercice 3");


    }
}
