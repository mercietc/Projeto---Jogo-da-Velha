package principal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jogador1;
        String jogador2;
        int opcaoEscolhida;

        //Iniciando jogo e exibindo menu
        System.out.println("\nIniciando o Jogo da Velha...\n");
        System.out.println("----- Boas vindas ao Jogo da Velha! -----\n");
        System.out.println(" _______________________________________");
        System.out.println("|__________________Menu_________________|");
        System.out.println("|                                       |");
        System.out.println("|  Jogador 1: X                         |");
        System.out.println("|  Jogador 2: O                         |");
        System.out.println("|____________________*__________________|");

        //Entrada dos nomes dos jogadores
        System.out.println("-----------------------------------------");
        sc.nextLine();
        System.out.println("  Digite o nome do Jogador 1:            ");
        jogador1 = sc.next();
        jogador1 = jogador1.toUpperCase();
        System.out.println("-----------------------------------------");
        sc.nextLine();
        System.out.println("  Digite o nome do Jogador 2:            ");
        jogador2 = sc.next();
        jogador2 = jogador2.toUpperCase();
        System.out.println("-----------------------------------------");

        //Iniciando partida e escolha das jogadas
        while (true) {
            System.out.println(" ---* Escolha uma posição no tabuleiro para jogar *---");

            //Criando e exibindo o tabuleiro
            int contador = 1;
            int[][] tabuleiro = new int[3][3];
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    tabuleiro[i][j] = contador;
                    System.out.print(tabuleiro[i][j] + " ");
                    contador += 1;
                }
                System.out.println();
            }

            //Escolha da posicao
            System.out.println("Digite o número correspondente à posição que deseja jogar: ");
            opcaoEscolhida = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    if (tabuleiro[i][j] == opcaoEscolhida) {
                        //tabuleiro[i][j] = "X";
                    }
                }
            }
        }
    }
}
