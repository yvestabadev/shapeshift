package br.com.yvestaba;

import java.util.List;

public class ManipuladorTabuleiroMenor extends ManipuladorTabuleiro{

    private final List<MapeadorDePosicao> mapeadoresOrganizados;
    public ManipuladorTabuleiroMenor(Tabuleiro tabuleiro, List<MapeadorDePosicao> mapeadoresOrganizados) {
        super(tabuleiro.clone());
        this.tabuleiro = tabuleiro;
        int indexLast = mapeadoresOrganizados.size() - 1;
        ultimoMapeamento = mapeadoresOrganizados.get(indexLast);
        mapeadoresOrganizados.remove(mapeadoresOrganizados.remove(indexLast));
        this.mapeadoresOrganizados = mapeadoresOrganizados;
    }

    @Override
    public void jogar() {
        for(var mapeador : mapeadoresOrganizados){
            tabuleiro.jogarPeca(mapeador.getPeca().get(), mapeador.getCoordenadaAtual());
        }
        jogarUltimaPeca();
    }

}
