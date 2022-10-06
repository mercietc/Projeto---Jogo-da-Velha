package tictactoe;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] placar = {0, 0};
    public static void main(String[] args) {

        String[] jogadores = new String[2];
        boolean novaRodada = false;
        char op;
        //Iniciando jogo e exibindo menu
        menu();

        //Entrada dos nomes dos jogadores
        jogadores[0] = getNome("Jogador 1");
        jogadores[1] = getNome("Jogador 2");

        System.out.println("-----------------------------------------");

        //Iniciando a matriz
        char[][] tabuleiro = iniciandoTabuleiro();
        //Iniciando partida e escolha das jogadas
        do{
            mostrarTabuleiro(tabuleiro);
            jogada(tabuleiro, jogadores);

            System.out.println("Jogar novamente: (s/n)");
            
            op = sc.next().charAt(0);
            if (op == 's'){
                tabuleiro = iniciandoTabuleiro();
                novaRodada = true;
            }else {
                novaRodada = false;
            }
        }while (novaRodada);
        System.out.println("Placar: " + placar[0] + " X " + placar[1]);


    }

    /**
     * Funções
     */
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
        boolean success = false;
        String nome=null;

        while (!success){
            try {
                System.out.println("-----------------------------------------");
                System.out.printf("  Digite o nome do %s:            \n", io);
                nome = sc.next();
                nome = nome.toUpperCase();
                success = true;
            } catch (IllegalArgumentException e){
                System.out.println("Nome inválido");
            }
        }
        return nome;

    }
    static void mostrarTabuleiro(char[][] tabuleiro){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void jogada(char[][] tabuleiro, String[] jogadores) {
    	int rodadas = 1;
    	boolean temVencedor = false;
    	boolean valido = false;

    	while(rodadas<=9 && !temVencedor) {
    		//Escolha da posicao
            System.out.println("Digite o número correspondente à posição que deseja jogar: ");
            do {
                char opcaoEscolhida = getPosition();
                valido = escolherPosicao(tabuleiro, opcaoEscolhida, rodadas);
                if(valido == false){
                    System.out.println("Posicao invalida, jogue novamente");
                }
            }while(!valido);



            mostrarTabuleiro(tabuleiro);

            if(rodadas >= 5 && haVencedor(tabuleiro)) {
            	temVencedor = true;
                placar[(rodadas+1)%2]++;
                //TODO:retornar um vencedor?
                System.out.println("O vencedor é: " + jogadores[(rodadas+1)%2]);
            }
            rodadas++;

    	}
    }
    static char getPosition(){
        String str = sc.next();

        while (!isNumeric(str)){
            System.out.println("Valor invalido. Entre com um numero inteiro de 1 a 9");
            str = sc.next();
        }
        int valorInt = Integer.parseInt(str);

        return (char)(valorInt + '0');
    }
    public static boolean isNumeric(String input){
        return input.matches("\\d");
    }

    static boolean escolherPosicao(char[][] tabuleiro, int opcao, int rodadas){
        char vez = rodadas%2 == 0? 'O':'X';
        boolean valido = false;
        //TODO: checar se opcaoEscolhida é valida

        switch (opcao){
            case '1':
                if (tabuleiro[0][0] != 'X' && tabuleiro[0][0] != 'O'){
                    tabuleiro[0][0] = vez;
                    valido = true;
                }
                break;
            case '2':
                if (tabuleiro[0][1] != 'X' && tabuleiro[0][1] != 'O'){
                    tabuleiro[0][1] = vez;
                    valido = true;
                }
                break;
            case '3':
                if (tabuleiro[0][2] != 'X' && tabuleiro[0][2] != 'O'){
                    tabuleiro[0][2] = vez;
                    valido = true;
                }
                break;
            case '4':
                if (tabuleiro[1][0] != 'X' && tabuleiro[1][0] != 'O'){
                    tabuleiro[1][0] = vez;
                    valido = true;
                }
                break;
            case '5':
                if (tabuleiro[1][1] != 'X' && tabuleiro[1][1] != 'O'){
                    tabuleiro[1][1] = vez;
                    valido = true;
                }
                break;
            case '6':
                if (tabuleiro[1][2] != 'X' && tabuleiro[1][2] != 'O'){
                    tabuleiro[1][2] = vez;
                    valido = true;
                }
                break;
            case '7':
                if (tabuleiro[2][0] != 'X' && tabuleiro[2][0] != 'O'){
                    tabuleiro[2][0] = vez;
                    valido = true;
                }
                break;
            case '8':
                if (tabuleiro[2][1] != 'X' && tabuleiro[2][1] != 'O'){
                    tabuleiro[2][1] = vez;
                    valido = true;
                }
                break;
            case '9':
                if (tabuleiro[2][2] != 'X' && tabuleiro[2][2] != 'O'){
                    tabuleiro[2][2] = vez;
                    valido = true;
                }
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }

        return  valido;
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
    static char[][] iniciandoTabuleiro(){
        //Iniciando a matriz
        char[][] matrix = new char[3][3];
        int contador = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (char) (contador+'0');
                contador += 1;
            }
        }
        return matrix;
    }
}
