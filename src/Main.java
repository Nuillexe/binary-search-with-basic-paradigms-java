// Autor: Emanuel [Seu Sobrenome Aqui]
// Disciplina: Algoritmos e Programação - IFBA 2025.1
// Trabalho Final

import java.util.Scanner;

public class Main {
    static int quantidadeNomes = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] listaDeNomes = new String[20];
        boolean continuar = true;
        int opcao;
        String nomeDigitado;

        while (continuar) {
            mostrarMenu();

            opcao = entrada.nextInt();
            entrada.nextLine(); // Evita bug com quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome que deseja cadastrar na lista:");
                    nomeDigitado = entrada.nextLine();
                    cadastrarNome(listaDeNomes, nomeDigitado);
                    break;

                case 2:
                    listarNomes(listaDeNomes);
                    break;

                case 3:
                    System.out.println("Digite o nome que deseja buscar na lista:");
                    nomeDigitado = entrada.nextLine();
                    if (buscaBinaria(nomeDigitado, listaDeNomes)) {
                        System.out.println("Esse nome está na lista.");
                    } else {
                        System.out.println("Esse nome não foi encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa... Até mais!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção do menu.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("**********************************");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar nome");
        System.out.println("2 - Listar nomes cadastrados");
        System.out.println("3 - Buscar nome");
        System.out.println("4 - Sair");
        System.out.println("**********************************1\n");
    }

    static void listarNomes(String[] lista) {
        int i = 0;
        while (i < quantidadeNomes) {
            System.out.println("Índice " + i + ": " + lista[i]);
            i++;
        }
    }

    static void cadastrarNome(String[] lista, String nome) {
        if (nomeRepetido(nome, lista)) {
            System.out.println("Não é possível cadastrar este nome, pois já existe na lista.");
        } else {
            if(quantidadeNomes>19){
                System.out.println("Não é possível cadastrar este nome, pois na lista já existem 20 nomes");
            }else {
                lista[quantidadeNomes] = nome;
                quantidadeNomes++;
                ordenarLista(lista);
                System.out.println("Nome cadastrado com sucesso!");
            }
        }
    }

    static boolean nomeRepetido(String nome, String[] lista) {
        for (int i = 0; i < quantidadeNomes; i++) {
            if (lista[i].equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    static void ordenarLista(String[] lista) {
        String aux;
        for (int i = 0; i < quantidadeNomes - 1; i++) {
            for (int j = i + 1; j < quantidadeNomes; j++) {
                if (lista[i].compareToIgnoreCase(lista[j]) > 0) {
                    aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }
        }
    }

    static boolean buscaBinaria(String nome, String[] lista) {
        int inicio = 0;
        int fim = quantidadeNomes - 1;
        int meio;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;

            if (lista[meio].compareToIgnoreCase(nome) < 0) {
                inicio = meio + 1;
            } else if (lista[meio].compareToIgnoreCase(nome) > 0) {
                fim = meio - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
