package br.com.yvestaba;

import java.util.*;

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
        for(MapeadorDePosicao mapeador : mapeadores){
            tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
        }
        if(tabuleiro.ganhou()){
            return;
        }
        var iterator = mapeadores.listIterator();
        boolean precisaContinuarReorganizando = true;
        while(precisaContinuarReorganizando){
            MapeadorDePosicao mapeador = iterator.next();
            precisaContinuarReorganizando = mapeador.proximaCoordenada();
        }
        testarJogo(tabuleiroInicial, mapeadores);
    }



}
