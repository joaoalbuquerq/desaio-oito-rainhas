public class EightQueens {
    private static final int TAMANHO_MAXIMO_LINHA = 8; // Tamanho do tabuleiro
    private int[] tabuleiro = new int[TAMANHO_MAXIMO_LINHA]; // Tabuleiro onde o índice é a coluna e o valor é a linha
    private int solucoesPossiveis = 0; // Contador de soluções

    public static void main(String[] args) {
        EightQueens eq = new EightQueens();
        eq.posicionarRainha(0);
    }

    private void posicionarRainha(int coluna) {
        if (coluna == TAMANHO_MAXIMO_LINHA) {
            exibirSolucao();
            solucoesPossiveis++;
            return;
        }

        for (int linha = 0; linha < TAMANHO_MAXIMO_LINHA; linha++) {
            if (verificarPosicaoSegura(linha, coluna)) {
                tabuleiro[coluna] = linha;
                posicionarRainha(coluna + 1);
            }
        }
    }

    private boolean verificarPosicaoSegura(int linha, int coluna) {
        for (int i = 0; i < coluna; i++) {
            if (tabuleiro[i] == linha || // Mesma linha
                    Math.abs(tabuleiro[i] - linha) == Math.abs(i - coluna)) { // Mesma diagonal
                return false;
            }
        }
        return true;
    }

    private void exibirSolucao() {
        System.out.println("Solução " + (solucoesPossiveis + 1) + ":");
        for (int i = 0; i < TAMANHO_MAXIMO_LINHA; i++) {
            for (int j = 0; j < TAMANHO_MAXIMO_LINHA; j++) {
                if (tabuleiro[i] == j) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}