import java.util.Scanner;

public class App {

    private static final char campoLivre = ' ';
    private static final char JOGADOR_1 = 'X';
    private static final char JOGADOR_2 = 'O';
    private static final char EMPATE = 'E';

    private static Integer linha = 0;
    private static Integer coluna = 0;
    private static Boolean jogada = true;
    private static char vencedor = campoLivre;
    private static final Scanner scanner = new Scanner(System.in);

    private static final char[][] jogo = {
            { campoLivre, campoLivre, campoLivre },
            { campoLivre, campoLivre, campoLivre },
            { campoLivre, campoLivre, campoLivre } };

    public static void main(String[] args) {
        exibirJogo();
        escolherJogada(scanner);
        fazerJogada(JOGADOR_2);

    }

    public static void exibirJogo() {
        int linha = 1;

        System.out.println("    1   2   3");
        for (int i = 0; i <= 2; i++) {
            System.out.println("  -------------");
            for (int j = 0; j <= 2; j++) {
                if (j == 0) {
                    System.out.print(linha);
                    linha++;
                }
                System.out.print(" | " + jogo[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("  -------------");
    }

    public static void escolherJogada(Scanner scanner) {
        System.out.print("Escolha a linha - " + jogada(jogada) + ": ");
        linha = scanner.nextInt();

        System.out.print("Escolha a coluna - " + jogada(jogada) + ": ");
        coluna = scanner.nextInt();
    }

    public static boolean fazerJogada(char jogada) {
        if (jogo[linha - 1][coluna - 1] == campoLivre) {
            jogo[linha - 1][coluna - 1] = jogada;
            return true;
        } else {
            System.out.println("JOGADA INVÁLIDA.");
            return false;
        }
    }

    public static char jogada(Boolean jogada) {
        return jogada ? JOGADOR_1 : JOGADOR_2;
    }

    public static char vencedor() {
        int linha;
        int coluna;
        int diagonal1;
        int diagonal2;
        char resultado;

        for (int i = 0; i <= 2; i++) {
            linha = jogo[i][0] + jogo[i][1] + jogo[i][2];
            if ((resultado = validarVencedor(linha)) != campoLivre) {
                return resultado;
            }
        }

        for (int j = 0; j <= 2; j++) {
            coluna = jogo[0][j] + jogo[1][j] + jogo[2][j];
            if ((resultado = validarVencedor(coluna)) != campoLivre) {
                return resultado;
            }
        }

        diagonal1 = jogo[0][0] + jogo[1][1] + jogo[2][2];
        if ((resultado = validarVencedor(diagonal1)) != campoLivre) {
            return resultado;
        }

        diagonal2 = jogo[2][0] + jogo[1][1] + jogo[0][2];
        if ((resultado = validarVencedor(diagonal2)) != campoLivre) {
            return resultado;
        }

        int empate = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (jogo[i][j] != campoLivre)
                    empate += 1;
            }
        }

        if (empate >= 9)
            resultado = EMPATE;

        return resultado;
    }

    public static char validarVencedor(Integer valor) {
        if (valor == 264)
            return JOGADOR_1;

        if (valor == 237)
            return JOGADOR_2;

        return campoLivre;
    }

    public static void mostrarVencedor() {
        if (vencedor == EMPATE)
            System.out.println("######### JOGO EMPATADO #########");
        else
            System.out.println("######### JOGO ACABOU. O VENCEDOR É '" + vencedor + "' #########");
    }

    public static void resetarJogo() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                jogo[i][j] = campoLivre;
            }
        }

        linha = 0;
        coluna = 0;
        jogada = true;
        vencedor = campoLivre;
    }
}