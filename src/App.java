public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Jogo da Velha!");
        exibirJogo();
    }

    private static final char campoLivre = ' ';

    private static final char[][] jogo = {
            { campoLivre, campoLivre, campoLivre },
            { campoLivre, campoLivre, campoLivre },
            { campoLivre, campoLivre, campoLivre }
    };

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
                System.out.print(" |" + (jogo[i][j]) + jogo[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("  -------------");
    }

}
