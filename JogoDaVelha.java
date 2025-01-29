import java.util.Scanner;

public class JogoDaVelha {

    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        inicializarTabuleiro();
        boolean jogoAcabou = false;

        while (!jogoAcabou) {
            exibirTabuleiro();
            System.out.println("Jogador " + jogadorAtual + ", é sua vez.");
            fazerJogada();
            jogoAcabou = verificarFimDeJogo();
            trocarJogador();
        }

        exibirTabuleiro();
        if (verificarVitoria()) {
            trocarJogador(); // Volta ao jogador que venceu
            System.out.println("Jogador " + jogadorAtual + " venceu!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fazerJogada() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;
        boolean jogadaValida = false;

        while (!jogadaValida) {
            System.out.print("Digite a linha (0, 1, 2): ");
            linha = scanner.nextInt();
            System.out.print("Digite a coluna (0, 1, 2): ");
            coluna = scanner.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == '-') {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadaValida = true;
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
    }

    private static boolean verificarFimDeJogo() {
        return verificarVitoria() || verificarEmpate();
    }

    private static boolean verificarVitoria() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] != '-' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
                return true;
            }
        }

        // Verificar diagonais
        if (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true;
        }
        if (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true;
        }

        return false;
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}