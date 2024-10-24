package br.com.yvestaba;

import java.util.*;
import java.util.stream.Collectors;

public class JogadorBot {

    public static void acharSolucao(Tabuleiro tabuleiro, List<Peca> pecas){
        var posicoes = new ArrayList<MapeadorDePosicao>();
        for(var peca : pecas){
            posicoes.add(new MapeadorDePosicao(peca, tabuleiro));
        }

        testarJogo(tabuleiro, posicoes);

        PrintadorDePecas.printSolucao(tabuleiro, posicoes);
    }

    private static void testarJogo(Tabuleiro tabuleiro, List<MapeadorDePosicao> mapeadores) {
        Tabuleiro tabuleiroInicial = tabuleiro.clone();
        List<MapeadorDePosicao> mapeadoresOrganizados = mapeadores.stream().sorted().collect(Collectors.toList());
        int indexLast = mapeadoresOrganizados.size() - 1;
        var ultimoMapeamento = mapeadoresOrganizados.get(indexLast);
        mapeadoresOrganizados.remove(mapeadoresOrganizados.remove(indexLast));
        while(true) {
            ManipuladorTabuleiro.tentarGanhar(tabuleiro, mapeadoresOrganizados, ultimoMapeamento);
            if (tabuleiro.ganhou()) {
                return;
            }
            var iterator = mapeadoresOrganizados.iterator();
            boolean precisaContinuarReorganizando = true;
            while (precisaContinuarReorganizando) {
                MapeadorDePosicao mapeador = iterator.next();
                precisaContinuarReorganizando = mapeador.proximaCoordenada();
            }
            tabuleiro = tabuleiroInicial.clone();
        }
    }



}
