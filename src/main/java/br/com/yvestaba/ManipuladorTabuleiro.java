package br.com.yvestaba;

import java.util.List;
import java.util.SortedSet;

public class ManipuladorTabuleiro {
    public static void tentarGanhar(Tabuleiro tabuleiro, List<MapeadorDePosicao> mapeadoresOrganizados, MapeadorDePosicao ultimoMapeamento) {
        for(var mapeador : mapeadoresOrganizados){
            tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
        }
        tabuleiro.jogarPecaDefinirCoordenada(ultimoMapeamento);
    }
}
