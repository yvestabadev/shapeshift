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
        ManipuladorTabuleiro manipuladorTabuleiro = ManipuladorTabuleiro.getStrategy(tabuleiro, mapeadoresOrganizados);
        while(true) {
            manipuladorTabuleiro.jogar();
            if (manipuladorTabuleiro.ganhou()) {
                return;
            }
            var iterator = mapeadoresOrganizados.iterator();
            boolean precisaContinuarReorganizando = true;
            while (precisaContinuarReorganizando) {
                MapeadorDePosicao mapeador = iterator.next();
                precisaContinuarReorganizando = mapeador.proximaCoordenada();
            }
            manipuladorTabuleiro.reiniciarTabuleiro();
        }
    }



}
