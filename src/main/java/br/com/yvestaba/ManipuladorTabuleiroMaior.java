package br.com.yvestaba;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ManipuladorTabuleiroMaior extends ManipuladorTabuleiro{

    private final List<MapeadorDePosicao> pecasMaiores;
    private final List<MapeadorDePosicao> pecasMenores;
    private int mudancasDisponiveis;

    public ManipuladorTabuleiroMaior(Tabuleiro tabuleiro, List<MapeadorDePosicao> mapeadoresOrganizados) {
        super(tabuleiro.clone());
        this.tabuleiro = tabuleiro;
        int indexLast = mapeadoresOrganizados.size() - 1;
        ultimoMapeamento = mapeadoresOrganizados.get(indexLast);
        mapeadoresOrganizados.remove(mapeadoresOrganizados.remove(indexLast));

        int metadeTabuleiro = tabuleiro.getMetadeTabuleiro();
        int valorAtual = 0;
        int indexReverse = 0;
        List<MapeadorDePosicao> mapeadoresOrdemContraria = mapeadoresOrganizados.stream().sorted(Comparator.reverseOrder()).toList();
        for(MapeadorDePosicao pecaMenor : mapeadoresOrdemContraria){
            Integer tamanhoPreenchido = pecaMenor.getPeca().getTamanhoPreenchido();
            if(valorAtual + tamanhoPreenchido > metadeTabuleiro){
                break;
            }
            valorAtual += tamanhoPreenchido;
            indexReverse++;
        }
        int midPoint = mapeadoresOrganizados.size() - indexReverse;
        this.pecasMaiores = mapeadoresOrganizados.subList(0, midPoint);
        this.pecasMenores = mapeadoresOrganizados.subList(midPoint, mapeadoresOrganizados.size());
        for(var mapeador : pecasMaiores){
            tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
        }
        mudancasDisponiveis = pecasMenores.stream().mapToInt(v -> v.getPeca().getTamanhoPreenchido()).sum() + ultimoMapeamento.getPeca().getTamanhoPreenchido();
    }

    @Override
    public void jogar() {
        for (var mapeador : pecasMaiores) {
            tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
        }
        int mudancasRestantes = tabuleiro.getMudancasRestantes();
        if(mudancasDisponiveis < mudancasRestantes){
            return;
        }
        Tabuleiro tabuleiroInicialSegundaParte = tabuleiro.clone();
        while (true) {
            for (var mapeador : pecasMenores) {
                tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
            }
            jogarUltimaPeca();
            if(ganhou()){
                return;
            }
            var iterator = pecasMenores.iterator();
            boolean precisaContinuarReorganizando = true;

            while (precisaContinuarReorganizando && iterator.hasNext()) {
                MapeadorDePosicao mapeador = iterator.next();
                precisaContinuarReorganizando = mapeador.proximaCoordenada();
            }
            if(!iterator.hasNext()){
                break;
            }
            tabuleiro = tabuleiroInicialSegundaParte.clone();
        }
        reiniciarTabuleiro();
    }

}
