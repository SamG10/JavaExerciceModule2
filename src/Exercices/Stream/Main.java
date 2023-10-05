package Exercices.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader trader1 = new Trader("Abdallah", "Cambridge");
        Trader trader2 = new Trader("Audrey", "Milan");
        Trader trader3 = new Trader("Corentin", "Cambridge");
        Trader trader4 = new Trader("Tristan", "Cambridge");

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

        String noms = transactions.stream().map(t -> t.getTrader().getName()).sorted().collect(Collectors.toList()).toString();

        System.out.println(noms);

        System.out.println("Exercice 4");

        Boolean cityEqualsMilan = transactions.stream().map(t -> t.getTrader().getCity()).anyMatch(c -> c.equals("Milan"));

        System.out.println(cityEqualsMilan);

        System.out.println("Exercice 5");

        Optional<Integer> transactionLaPlusElevee = transactions.stream()
                .map(t -> t.getValue())
                .max(Integer::compareTo);

        System.out.println(transactionLaPlusElevee);

        System.out.println("Exercice 6");

        List<Trader> cambridgeTraders = transactions.stream()
                .map(t -> t.getTrader())
                .filter(tr -> tr.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).collect(Collectors.toList());

        System.out.println(cambridgeTraders);

        System.out.println("Exercice 7");

        List<Integer> getValuesFromCambridgeTraders = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(tr -> tr.getValue())
                .collect(Collectors.toList());

        System.out.println(getValuesFromCambridgeTraders);

        System.out.println("Exercice 8");

        Optional<Integer> transactionAvecLaPlusPetiteValue = transactions.stream().map(t -> t.getValue()).min(Integer::compareTo);

        System.out.println(transactionAvecLaPlusPetiteValue);

        System.out.println("Exercice 9");

        // ?
    }
}
