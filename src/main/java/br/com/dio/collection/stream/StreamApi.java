package br.com.dio.collection.stream;

import java.util.*;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);

id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/


public class StreamApi {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> contatos = new HashMap(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};

        System.out.println(contatos);

        System.out.println("--\tOrdem Inserção\t--");

        Map<Integer, Contato> linkedContatos = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};

        System.out.println(linkedContatos);

        for(Map.Entry<Integer, Contato> entry: linkedContatos.entrySet()){
            System.out.println(entry.getKey() +" - "+ entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> treeContatos = new TreeMap<>(contatos);
        System.out.println(treeContatos);

        for(Map.Entry<Integer, Contato> entry: treeContatos.entrySet()){
            System.out.println(entry.getKey() +" - "+ entry.getValue().getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");
        Set<Map.Entry<Integer, Contato>> contatosOrdemTelefone = new TreeSet<>();
        contatosOrdemTelefone.addAll(contatos.entrySet());

        for(Map.Entry<Integer, Contato> entry: contatosOrdemTelefone){
            System.out.println(entry.getKey() +" - "+ entry.getValue().getNumero() + ": "+entry.getValue().getNome());
        }

        System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> contatosOrdemNome = new TreeSet<>(new ComparatorPorNome());
        contatosOrdemNome.addAll(contatos.entrySet());

        for(Map.Entry<Integer,Contato> entry: contatosOrdemNome){
            System.out.println(entry.getKey() +" - "+ entry.getValue().getNome() +" - "+ entry.getValue().getNumero());
        }
    }
}

class ComparatorPorTelefone implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2){
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}

class ComparatorPorNome implements Comparator <Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2){
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}

class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
