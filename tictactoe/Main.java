package tictactoe;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String jogador1;
        String jogador2;
        int opcaoEscolhida;

        //Iniciando jogo e exibindo menu
        menu();

        //Entrada dos nomes dos jogadores
        jogador1 = getNome("Jogador 1");
        jogador2 = getNome("Jogador 2");

        System.out.println("-----------------------------------------");

        //Iniciando a matriz
        int[][] tabuleiro = new int[3][3];
        int contador = 1;
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = contador;
                contador += 1;
            }
        }
        //Chamar o tabuleiro
        mostrarTabuleiro(tabuleiro);
        //Iniciando partida e escolha das jogadas


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

    static void menu(){
        System.out.println("\nIniciando o Jogo da Velha...\n");
        System.out.println("----- Boas vindas ao Jogo da Velha! -----\n");
        System.out.println(" _______________________________________");
        System.out.println("|__________________Menu_________________|");
        System.out.println("|                                       |");
        System.out.println("|  Jogador 1: X                         |");
        System.out.println("|  Jogador 2: O                         |");
        System.out.println("|____________________*__________________|");
    }
    static String getNome(String io){
        //TODO: tratar excessão.
        System.out.println("-----------------------------------------");
        System.out.printf("  Digite o nome do %s:            \n", io);
        return sc.next();

    }
    static void mostrarTabuleiro(int[][] tabuleiro){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean haVencedor(char[][] matrix){
        boolean aux = false;

        if(isEqual(matrix[0][0], matrix[0][1], matrix[0][2])){aux = true;}
        else if(isEqual(matrix[1][0], matrix[1][1], matrix[1][2])){aux = true;}
        else if(isEqual(matrix[2][0], matrix[2][1], matrix[2][2])){aux = true;}
        else if(isEqual(matrix[0][0], matrix[1][0], matrix[2][0])){aux = true;}
        else if(isEqual(matrix[0][1], matrix[1][1], matrix[2][1])){aux = true;}
        else if(isEqual(matrix[0][2], matrix[1][2], matrix[2][2])){aux = true;}
        else if(isEqual(matrix[0][0], matrix[1][1], matrix[2][2])){aux = true;}
        else if(isEqual(matrix[0][2], matrix[1][1], matrix[2][0])){aux = true;}
        else{aux = false;}

        return aux;
    }

    static boolean isEqual(char posicao1, char posicao2, char posicao3){
        boolean result = false;
        if(posicao1 == posicao2 && posicao2 == posicao3){
            result = true;
        }
        return result;
    }
}
