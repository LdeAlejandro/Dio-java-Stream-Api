package br.com.dio.collection.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Ordenacao {

    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        // numerosAleatorios.stream().forEach(System.out::println);
        //numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
                .limit(5) // primeiros 5
                .collect(Collectors.toSet()) // pegar os elementos que não sejam repetidos
                .forEach(System.out::println); // imprimir

//        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
//                .limit(5)
//                .collect(Collectors.toSet());
//        System.out.println(numerosAleatorios5Primeiros);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());//pegar elementos da lista, converter string en Int

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //.forEach(System.out::println);
        System.out.println(numerosAleatoriosInteger);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
//        numerosAleatorios.stream()
//                .map(Integer::parseInt)
//                .filter(i -> i % 2 == 0 && i > 2)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);


        System.out.println("Mostre a média dos números: ");
//        numerosAleatorios1.stream()
//                .average()
//                .ifPresent(System.out::println);

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        numerosAleatorios1.removeIf(integer -> integer % 2 != 0);
        System.out.println(numerosAleatorios1);
        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatoriosInteger);

//        Para você
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3)
                .map(Integer::parseInt)
                .forEach(System.out::println);

        //Retirando os números repetidos da lista, quantos números ficam?

        Set <Integer> countNumerosUnicos = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet()); //pegar elementos que (sem elementos duplicados) retornar set
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);

        System.out.println("Mostre o menor valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.print("Mostre o maior valor da lista: ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);
        //System.out.println("Pegue apenas os números pares e some: " + somaDosNumerosPares);

        System.out.println("Mostre a lista na ordem númerica: ");

        // Ordena a lista de números inteiros em ordem natural (crescente) usando Comparator.naturalOrder().
        List<Integer> numerosOrdenados = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder()) // Aplica a ordenação natural.
                .collect(Collectors.toList()); // Coleta os elementos ordenados em uma nova lista.
        System.out.println(numerosOrdenados);

// Agrupa os valores da lista que são ímpares e múltiplos de 3 ou 5.
        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
// Usa o metodo collect para agrupar os elementos da lista com base na condição especificada.
        Map<Boolean, List<Integer>> collectNumerosMultiplsDe3e5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0))); // Cria dois grupos: true (múltiplos de 3 ou 5) e false (não múltiplos).
        System.out.println(collectNumerosMultiplsDe3e5);



    }
}
