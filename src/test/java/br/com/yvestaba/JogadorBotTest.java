package br.com.yvestaba;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JogadorBotTest {

    @BeforeEach
    void printar(){
        System.out.println("PRÓXIMO TESTE");
    }

    @Test
    void fase1(){
        int[][] matriz =
                {{1,0,1},
                {0,0,0},
                {0,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Sozinha(), new Deitada1x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase2(){
        int[][] matriz =
                {{0,1,0},
                {1,1,1},
                {0,1,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Z2x3(), new Deitada1x3(), new DePe3x1());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase3(){
        int[][] matriz =
                {{0,0,1},
                {0,1,0},
                {0,1,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Z2x3(), new Deitada1x3(), new Deitada1x3(), new Z2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase4(){
        int[][] matriz =
                {{0,0,1},
                {0,0,1},
                {1,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Sozinha(), new Sozinha(), new Deitada1x3(), new LInvHoriz2x2(), new T2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase5(){
        int[][] matriz =
                {{1,0,0},
                {1,1,0},
                {1,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Sozinha(), new Sozinha(), new LInvHoriz2x2(), new RaioComecaEsquerda3x2(), new Deitada1x3(), new Deitada1x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase6(){
        int[][] matriz =
                {{1,0,1},
                {1,1,1},
                {1,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new TDireita3x2(), new TEsquerda3x2(), new Sozinha(), new DePe3x2(),
                new TDireita3x2(), new Deitada1x2(), new T2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase7(){
        int[][] matriz =
                {{1,1,1},
                {1,1,0},
                {0,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new DePe2x1(), new Sozinha(), new Deitada1x3(), new TEsquerda3x2(), new LInvHoriz2x2(),
                new LInvHoriz2x3(), new Z2x3(), new Sozinha());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase8(){
        int[][] matriz =
                {{1,1,1},
                {0,0,1},
                {0,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Sozinha(), new DePe2x1(), new LInvHorizVertc2x2(), new RaioComecaEsquerda3x2(),
                new RaioComecaEsquerda3x2(), new TEsquerda3x2(), new LInvHoriz2x3(), new RaioComecaEsquerda3x2(), new RaioComecaEsquerda3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase9(){
        int[][] matriz =
                {{0,1,0},
                {1,0,1},
                {1,0,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Deitada1x3(), new LInvHoriz2x3(), new Z2x3(), new DePe3x2(), new TDireita3x2(),
                new T2x3(), new LInvHoriz2x3(), new Deitada1x3(), new Sozinha(), new DePe3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase10(){
        int[][] matriz =
                {{0,0,0},
                {1,1,0},
                {1,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Sozinha(), new Sozinha(), new DePe2x1(), new LInvHoriz2x3(), new RaioComecaEsquerda3x2(),
                new Deitada1x2(), new LInvHorizVertc2x2(), new Sozinha(), new TDireita3x2(), new T2x3(), new DePe3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase11(){
        int[][] matriz =
                {{1,1,0},
                {0,0,0},
                {0,1,0},
                {1,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Deitada1x2(), new TEsquerda3x2(), new Deitada1x2(), new T2x3(),
                new Deitada1x2(), new Deitada1x2(), new LInvHoriz2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase12(){
        int[][] matriz =
                {{1,0,0},
                {1,1,0},
                {0,1,0},
                {1,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new DePe2x1(), new Z3x3(), new Deitada1x2(), new Z2x3(), new LInvHoriz2x3(),
                new Sozinha(), new TEsquerda3x2(), new TEsquerda3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase13(){
        int[][] matriz =
                {{0,0,1},
                {1,0,1},
                {1,1,0},
                {0,1,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Deitada1x2(), new Deitada1x2(), new Z3x3(), new Deitada1x3(), new RaioComecaEsquerda3x2(),
                new Deitada1x3(), new O3x3(), new TDireita3x2(), new DePe2x1());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase14(){
        int[][] matriz =
                {{0,1,1},
                {1,1,0},
                {0,1,1},
                {1,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Z2x3(), new LInvHoriz2x2(), new TEsquerda3x2(), new Deitada1x3(), new TEsquerda3x2(),
                new Z3x3(), new DePe2x1(), new Deitada1x2(), new Sozinha(), new RaioComecaEsquerda3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase15(){
        int[][] matriz =
                {{1,1,1},
                {1,0,1},
                {0,0,0},
                {0,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new DePe2x1(), new DePe3x2(), new RaioComecaEsquerda3x2(), new DePe2x1(), new Deitada1x2(),
                new Sozinha(), new TDireita3x2(), new RaioComecaEsquerda3x2(), new DePe2x1(), new SpaceInvader3x3(), new RaioComecaEsquerda3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase16(){
        int[][] matriz =
                {{0,0,0},
                {1,1,1},
                {1,0,0},
                {0,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new TEsquerda3x2(), new DePe2x1(), new LInvHoriz2x3(), new DePe2x1(), new DePe2x1(),
                new RaioComecaEsquerda3x2(), new T2x3(), new DePe2x1(), new DePe2x1(), new LInvHoriz2x3(), new Deitada1x3(), new HDeitado3x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase17(){
        int[][] matriz =
                {{1,1,0},
                {0,0,1},
                {1,1,0},
                {1,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Deitada1x2(), new TEsquerda3x2(), new EscadaComecaDireita3x3(), new Deitada1x2(),
                new Deitada1x3(), new LInvHorizVertc2x2(), new LInvHorizVertc2x2(), new O3x3(), new EscadaComecaDireita3x3(),
                new HDeitado3x3(), new LInvHoriz2x3(), new LInvHoriz2x3(), new T2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase18(){
        int[][] matriz =
                {{0,0,1},
                {0,0,0},
                {0,1,0},
                {1,1,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Deitada1x3(), new Sozinha(), new LInvHorizVertc2x2(), new Deitada1x2(), new DePe3x2(),
                new EscadaComecaDireita3x3(), new Z2x3(), new Sozinha(), new HDeitado3x3(), new HDeitado3x3(), new DePe3x2(),
                new TEsquerda3x2(), new T2x3(), new DePe3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase19(){
        int[][] matriz =
                {{1,0,0},
                {0,0,0},
                {1,1,1},
                {1,1,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new EscadaComecaDireita3x3(), new Deitada1x2(), new T2x3(), new HDeitado3x3(),
                new T2x3(), new TDireita3x2(), new O3x3(), new Sozinha(), new Deitada1x3(), new Deitada1x3(),
                new Deitada1x2(), new DePe3x2(), new Z2x3(), new Deitada1x3(), new HDeitado3x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase20(){
        int[][] matriz =
                {{1,0,1},
                {1,1,1},
                {1,0,0},
                {1,1,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new EscadaComecaDireita3x3(), new TEsquerda3x2(), new EscadaComecaDireita3x3(),
                new DePe3x2(), new O3x3(), new LInvHoriz2x2(), new Z2x3(), new EscadaComecaDireita3x3(), new T2x3(),
                new DePe3x2(), new LInvHoriz2x3(), new LInvHoriz2x3(), new Z2x3(), new LInvHoriz2x3(), new DePe3x2(), new T2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase21(){
        int[][] matriz =
                {{1,1,0,0},
                {1,0,1,0},
                {0,0,1,0},
                {0,1,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new SpaceInvaderDireita3x3(), new L2x2(), new T2x3(), new LInvHorizVertc2x2(),
                new O3x3(), new U3x3(), new O2x2(), new TDireita3x2(), new TEsquerda3x3(), new H3x3(), new LInvHoriz2x3(), new O2x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase22(){
        int[][] matriz =
                {{0,1,0,0},
                {0,1,0,0},
                {0,1,1,0},
                {1,1,0,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new Deitada1x3(), new S3x3(), new U3x3(), new EscadaComecaDireita3x3(), new O3x3(),
                new SpaceInvaderDireita3x3(), new Sozinha(), new EscadaComecaEsquerda3x3(), new H3x3(), new Deitada1x3(),
                new Sozinha(), new Sozinha(), new TEsquerda3x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase23(){
        int[][] matriz =
                {{1,0,1,0},
                {1,1,1,1},
                {0,1,1,0},
                {0,0,1,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new LInvHoriz2x2(), new HDeitado3x3(), new LInvHoriz3x3(), new Sozinha(), new Deitada1x3(),
                new DePe3x1(), new RaioComecaEsquerda3x2(), new Sozinha(), new Deitada1x3(), new LInvHorizVertc2x2(), new Deitada1x3(),
                new DePe2x1(), new Deitada1x2(), new RaioComecaEsquerda3x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase24(){
        int[][] matriz =
                {{1,0,0,1},
                {0,1,1,1},
                {0,0,1,1},
                {1,1,0,1}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new H3x3(), new LInvHorizVertic3x3(), new TBaixo2x3(), new Z2x3(), new ZPerfeito3x3(),
                new DePe2x1(), new Z3x3(), new DePe3x1(), new EscadaComecaEsquerda3x3(), new DePe3x2(), new ZPerfeito3x3(),
                new Deitada1x3(), new EscadaComecaEsquerda3x3(), new EscadaComecaDireita3x3(), new LInvHorizVertic3x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase25(){
        int[][] matriz =
                {{1,1,1,0},
                {1,0,1,0},
                {0,0,0,1},
                {1,0,0,0}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 2);
        List<Peca> pecas = Arrays.asList(new LInvHorizVertic3x3(), new T2x3(), new TEsquerda3x3(), new Z2x3(), new TBaixo2x3(),
                new DePe3x2(), new LInvHorizVertic3x3(), new O2x2(), new L2x2(), new LInvHoriz3x3(), new S3x3(), new DePe3x2(),
                new L2x2(), new TEsquerda3x2(), new TEsquerda3x2(), new Deitada1x2());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }

    @Test
    void fase26(){
        int[][] matriz =
                {{0,0,0,0},
                {0,1,1,1},
                {1,1,2,0},
                {1,2,1,2}};
        Tabuleiro tabuleiro = new Tabuleiro(matriz, 3);
        List<Peca> pecas = Arrays.asList(new L2x2(), new UBaixo2x3(), new SpaceInvaderBaixo3x3(), new TDireita3x2(), new LInvHorizVertc2x2(),
                new Sozinha(), new U2x3(), new LInvHorizVertic3x3(), new DePe3x2(), new LInvHorizVertic3x2(), new UBaixo2x3());

        JogadorBot.acharSolucao(tabuleiro, pecas);
    }
}