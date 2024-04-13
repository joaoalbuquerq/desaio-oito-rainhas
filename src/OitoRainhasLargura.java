import java.util.LinkedList;
import java.util.Queue;

public class OitoRainhasLargura {

    private static final int TAMANHO_MAXIMO = 8;
    private int solucoesPossiveis = 0;

    public static void main(String[] args) {
        OitoRainhasLargura eq = new OitoRainhasLargura();
        eq.encontrarSolucoes();
    }

    private void encontrarSolucoes() {
        Queue<int[]> fila = new LinkedList<>();
        fila.offer(new int[TAMANHO_MAXIMO]);

        while (!fila.isEmpty()) {
            int[] tabuleiro = fila.poll(); //guarda a config do tabuleiro que será explorada no momento
            int coluna = encontrarProximaColuna(tabuleiro);

            if (coluna == TAMANHO_MAXIMO) { //Verifica se a iteração chegou no tamanho máximo definido pelo tabuleiro (8)
                exibirSolucao(tabuleiro);
                solucoesPossiveis++;
            } else {
                for (int linha = 0; linha < TAMANHO_MAXIMO; linha++) { //explora totalmente a linha atual dada uma coluna
                    if (verificarPosicaoSegura(tabuleiro, linha, coluna)) { //verifica se a posição atual é segura
                        int[] novoTabuleiro = tabuleiro.clone(); //clona o tabuleiro
                        novoTabuleiro[coluna] = linha;
                        fila.offer(novoTabuleiro); //adiciona a lista de estados a serem explorados
                    }
                }
            }
        }
    }

    //Encontra a próxima coluna vazia em determinado estado do tabuleiro passado.
    private int encontrarProximaColuna(int[] tabuleiro) {
        for (int coluna = 0; coluna < TAMANHO_MAXIMO; coluna++) {
            if (tabuleiro[coluna] == 0) {
                return coluna;
            }
        }
        return TAMANHO_MAXIMO;
    }

    private boolean verificarPosicaoSegura(int[] tabuleiro, int linha, int coluna) {
        //percorre todas as colunas anteriores a coluna atual
        for (int i = 0; i < coluna; i++) {

            if (tabuleiro[i] == linha //verifica se a linha atual possui uma rainha
                    || Math.abs(tabuleiro[i] - linha) == Math.abs(i - coluna)) {  //verifica se existem rainhas na diagonal
                return false; //indica que a posição não é segura
            }
        }
        return true; //indica que é segura
    }

    private void exibirSolucao(int[] tabuleiro) {
        System.out.println("Solução " + (solucoesPossiveis + 1) + ":");
        for (int i = 0; i < TAMANHO_MAXIMO; i++) {
            for (int j = 0; j < TAMANHO_MAXIMO; j++) {
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
