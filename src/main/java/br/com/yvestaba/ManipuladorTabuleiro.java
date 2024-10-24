package br.com.yvestaba;

import java.util.List;
import java.util.SortedSet;

public class ManipuladorTabuleiro {
    public static void tentarGanhar(Tabuleiro tabuleiro, List<MapeadorDePosicao> mapeadoresOrganizados, MapeadorDePosicao ultimoMapeamento) {
        for(var mapeador : mapeadoresOrganizados){
            tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
        }
        for(int y = 0; y < tabuleiro.getTamanhoY(); y++){
            for(int x = 0; x < tabuleiro.getTamanhoX(); x++){
                if(tabuleiro.getPecaCoordenada(y, x) != 0){
                    var peca = ultimoMapeamento.getPeca().get();
                    Coordenada coordenadaAtual = definirCoordenada(peca, x, y);
                    ultimoMapeamento.setCoordenadaAtual(coordenadaAtual);
                    try {
                        tabuleiro.jogarPeca(peca, coordenadaAtual);
                    } catch (Exception e){
                        tabuleiro.jogarPeca(peca, new Coordenada(0, 0));
                    }
                    return;
                }
            }
        }
    }

    //define de acordo com a primeira coordenada da peça preenchida
    //ex: [[false, true][true, true]] a primeira preenchida é [0][1], então acrescenta 1 à coordenada x
    private static Coordenada definirCoordenada(boolean[][] peca, int x, int y) {
        int largura = x;
        for(int i = 0; i < peca[0].length; i++){
            if(peca[0][i]){
                break;
            }
            largura--;
        }
        return new Coordenada(largura, y);
    }
}
