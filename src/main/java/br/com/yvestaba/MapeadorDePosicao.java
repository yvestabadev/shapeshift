package br.com.yvestaba;

import java.util.ArrayList;
import java.util.List;

/**
 * Verifica todas as possibilidades de uma peça dentro do tabuleiro e guarda a coordenada atual que estamos testando
 */
public class MapeadorDePosicao implements Comparable<MapeadorDePosicao>{

    private final Peca peca;
    private final int limiteX;
    private final int limiteY;
    private final List<Coordenada> possibilidades;
    private Coordenada coordenadaAtual;

    public MapeadorDePosicao(Peca peca, Tabuleiro tabuleiro) {
        this.peca = peca;
        this.limiteX = tabuleiro.getTamanhoX() - peca.getTamanhoX();
        this.limiteY = tabuleiro.getTamanhoY() - peca.getTamanhoY();
        this.possibilidades = todasAsPossibilidades();
        this.coordenadaAtual = possibilidades.get(0);
    }

    private List<Coordenada> todasAsPossibilidades(){
        List<Coordenada> ret = new ArrayList<>();
        for(int x = 0; x <= limiteX; x++){
            for(int y = 0; y <= limiteY; y++){
                ret.add(new Coordenada(x, y));
            }
        }
        return ret;
    }

    /**
     *
     * @return se a lista foi reiniciada
     */
    public boolean proximaCoordenada(){
        int indexAtual = possibilidades.indexOf(coordenadaAtual);
        if(indexAtual == possibilidades.size() - 1){
            coordenadaAtual = possibilidades.get(0);
            return true;
        }
        coordenadaAtual = possibilidades.get(indexAtual + 1);
        return false;
    }
    public List<Coordenada> getPossibilidades() {
        return possibilidades;
    }
    public Peca getPeca() {
        return peca;
    }

    public Coordenada getCoordenadaAtual() {
        return coordenadaAtual;
    }

    public void setCoordenadaAtual(Coordenada coordenadaAtual) {
        this.coordenadaAtual = coordenadaAtual;
    }

    @Override
    public int compareTo(MapeadorDePosicao other) {
        return other.getPeca().getTamanhoPreenchido().compareTo(this.getPeca().getTamanhoPreenchido());
    }
}
