public class OitoRainhasProfundidade {
    private static final int TAMANHO_MAXIMO_LINHA = 8; // Tamanho do tabuleiro
    private int[] tabuleiro = new int[TAMANHO_MAXIMO_LINHA]; // Tabuleiro onde o índice é a coluna e o valor é a linha
    private int solucoesPossiveis = 0; // Contador de soluções possíveis para o problema

    public static void main(String[] args) {
        OitoRainhasProfundidade eq = new OitoRainhasProfundidade();
        eq.posicionarRainha(0);
    }

    private void posicionarRainha(int coluna) {
        if (coluna == TAMANHO_MAXIMO_LINHA) { //verifica se a coluna passada é o limite de exploração (8)
            exibirSolucao();
            solucoesPossiveis++;
            return;
        }

        for (int linha = 0; linha < TAMANHO_MAXIMO_LINHA; linha++) { // enquanto a linha explorada não for a ultima posição
            if (verificarPosicaoSegura(linha, coluna)) {
                tabuleiro[coluna] = linha; //atribui a linha atual a coluna atual informando a posição da rainha
                posicionarRainha(coluna + 1); //chama recursivamente a função para tentar achar uma nova posição chamando uma próxima coluna
            }
        }
    }

    //Verifica se a posição dada uma linha e uma coluna é segura para posicionar uma rainha
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