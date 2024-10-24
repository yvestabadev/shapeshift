package br.com.yvestaba;

public abstract class Peca{
    private final boolean[/* y */][/* x */] peca;

    public Peca(boolean[][] peca) {
        this.peca = peca;
    }

    public boolean[][] get(){
        return peca;
    }

    public int getTamanhoX(){
        return peca[0].length;
    }
    public int getTamanhoY(){
        return peca.length;
    }

    public Integer getTamanhoPreenchido(){
        int tamanho = 0;
        for(int i = 0; i < peca.length; i++){
            for(int j = 0; j < peca[0].length; j++){
                if(peca[i][j]){
                    tamanho++;
                }
            }
        }
        return tamanho;
    }
}

class Sozinha extends Peca{
    private static final boolean[][] PECA = {{true}};
    public Sozinha(){
        super(PECA);
    }
}

class Deitada1x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, true}};
    public Deitada1x3(){
        super(PECA);
    }
}

class Deitada1x2 extends Peca{
    private static final boolean[][] PECA = {{true, true}};
    public Deitada1x2(){
        super(PECA);
    }
}

class DePe2x1 extends Peca{
    private static final boolean[][] PECA =
            {{true},
            {true}};
    public DePe2x1(){
        super(PECA);
    }
}

class DePe3x1 extends Peca{
    private static final boolean[][] PECA =
            {{true},
            {true},
            {true}};
    public DePe3x1(){
        super(PECA);
    }
}

class DePe3x2 extends Peca{
    private static final boolean[][] PECA =
            {{true, true},
            {true, true},
            {true, true}};
    public DePe3x2(){
        super(PECA);
    }
}

class Z2x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, false},
                                            {false, true, true}};
    public Z2x3(){
        super(PECA);
    }
}

class ZDefeituoso3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, false},
                                            {true, true, false},
                                            {false, true, true}};
    public ZDefeituoso3x3(){
        super(PECA);
    }
}

class ZPerfeito3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, false},
                                            {false, true, false},
                                            {false, true, true}};
    public ZPerfeito3x3(){
        super(PECA);
    }
}

class N3x3 extends Peca{
    private static final boolean[][] PECA = {{false, false, true},
                                            {true, true, true},
                                            {true, false, false}};
    public N3x3(){
        super(PECA);
    }
}

class NInvHoriz3x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, false},
                                            {true, true, true},
                                            {false, false, true}};
    public NInvHoriz3x3(){
        super(PECA);
    }
}

class S3x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, true},
                                            {false, true, false},
                                            {true, true, false}};
    public S3x3(){
        super(PECA);
    }
}

class T2x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, true},
                                            {false, true, false}};
    public T2x3(){
        super(PECA);
    }
}

class TDireita3x2 extends Peca{
    private static final boolean[][] PECA = {{false, true},
                                            {true, true},
                                            {false, true}};
    public TDireita3x2(){
        super(PECA);
    }
}

class TBaixo2x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, false},
                                            {true, true, true}};
    public TBaixo2x3(){
        super(PECA);
    }
}

class TEsquerda3x2 extends Peca{
    private static final boolean[][] PECA = {{true, false},
                                            {true, true},
                                            {true, false}};
    public TEsquerda3x2(){
        super(PECA);
    }
}

class TEsquerda3x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, false},
                                            {true, true, true},
                                            {true, false, false}};
    public TEsquerda3x3(){
        super(PECA);
    }
}

class LInvHoriz2x2 extends Peca{
    private static final boolean[][] PECA = {{false, true},
                                            {true, true}};
    public LInvHoriz2x2(){
        super(PECA);
    }
}

class LInvHorizVertic2x2 extends Peca{
    private static final boolean[][] PECA = {{true, true},
                                            {false, true}};
    public LInvHorizVertic2x2(){
        super(PECA);
    }
}

class LInvHoriz3x3 extends Peca{
    private static final boolean[][] PECA = {{false, false, true},
                                            {false, false, true},
                                            {true, true, true}};
    public LInvHoriz3x3(){
        super(PECA);
    }
}

class LInvVertic3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, true},
                                            {true, false, false},
                                            {true, false, false}};
    public LInvVertic3x3(){
        super(PECA);
    }
}

class LInvVertic3x2 extends Peca{
    private static final boolean[][] PECA = {{true, true},
                                            {true, false},
                                            {true, false}};
    public LInvVertic3x2(){
        super(PECA);
    }
}

class L2x2 extends Peca{
    private static final boolean[][] PECA = {{true, false},
                                            {true, true}};
    public L2x2(){
        super(PECA);
    }
}

class LInvVertc2x2 extends Peca{
    private static final boolean[][] PECA = {{true, true},
                                            {true, false}};
    public LInvVertc2x2(){
        super(PECA);
    }
}

class LInvHoriz2x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, true},
                                            {true, true, true}};
    public LInvHoriz2x3(){
        super(PECA);
    }
}

class RaioComecaEsquerda3x2 extends Peca{
    private static final boolean[][] PECA = {{true, false},
                                            {true, true},
                                            {false, true}};
    public RaioComecaEsquerda3x2(){
        super(PECA);
    }
}

class O3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, true},
                                            {true, false, true},
                                            {true, true, true}};
    public O3x3(){
        super(PECA);
    }
}

class O2x2 extends Peca{
    private static final boolean[][] PECA = {{true, true},
                                            {true, true}};
    public O2x2(){
        super(PECA);
    }
}

class U3x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, true},
                                            {true, false, true},
                                            {true, true, true}};
    public U3x3(){
        super(PECA);
    }
}

class UDireitaTorta4x4 extends Peca{
    private static final boolean[][] PECA = {{true, false, false, true},
                                            {true, false, true, true},
                                            {true, false, true, false},
                                            {true, true, true, false}};
    public UDireitaTorta4x4(){
        super(PECA);
    }
}

class U2x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, true},
                                            {true, true, true}};
    public U2x3(){
        super(PECA);
    }
}

class UBaixo2x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, true},
                                            {true, false, true}};
    public UBaixo2x3(){
        super(PECA);
    }
}

class SpaceInvader3x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, false},
                                            {true, true, true},
                                            {true, false, true}};
    public SpaceInvader3x3(){
        super(PECA);
    }
}

class SpaceInvaderDireita3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, false},
                                            {false, true, true},
                                            {true, true, false}};
    public SpaceInvaderDireita3x3(){
        super(PECA);
    }
}

class SpaceInvaderEsquerda4x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, true},
                                            {true, true, false},
                                            {false, true, true},
                                            {false, true, true}};
    public SpaceInvaderEsquerda4x3(){
        super(PECA);
    }
}

class SpaceInvaderEsquerdaBaixoMaior3x4 extends Peca{
    private static final boolean[][] PECA = {{false, true, true, false},
                                            {true, true, false, false},
                                            {false, true, true, true}};
    public SpaceInvaderEsquerdaBaixoMaior3x4(){
        super(PECA);
    }
}

class SpaceInvaderBaixo3x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, true},
                                            {true, true, true},
                                            {false, true, false}};
    public SpaceInvaderBaixo3x3(){
        super(PECA);
    }
}

class H3x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, true},
                                            {true, true, true},
                                            {true, false, true}};
    public H3x3(){
        super(PECA);
    }
}

class HDeitado3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, true},
                                            {false, true, false},
                                            {true, true, true}};
    public HDeitado3x3(){
        super(PECA);
    }
}

class JBaixo3x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, true},
                                            {false, true, false},
                                            {true, true, true}};
    public JBaixo3x3(){
        super(PECA);
    }
}

class EscadaComecaDireita3x3 extends Peca{
    private static final boolean[][] PECA = {{true, false, false},
                                            {true, true, false},
                                            {false, true, true}};
    public EscadaComecaDireita3x3(){
        super(PECA);
    }
}

class EscadaSemChaoDireita3x3 extends Peca{
    private static final boolean[][] PECA = {{true, true, false},
                                            {false, true, true},
                                            {false, false, true}};
    public EscadaSemChaoDireita3x3(){
        super(PECA);
    }
}

class EscadaComecaEsquerda3x3 extends Peca{
    private static final boolean[][] PECA = {{false, false, true},
                                            {false, true, true},
                                            {true, true, false}};
    public EscadaComecaEsquerda3x3(){
        super(PECA);
    }
}

class EscadaPreenchEsquerda3x3 extends Peca{
    private static final boolean[][] PECA = {{false, false, true},
                                            {false, true, true},
                                            {true, true, true}};
    public EscadaPreenchEsquerda3x3(){
        super(PECA);
    }
}

class Cruz3x3 extends Peca{
    private static final boolean[][] PECA = {{false, true, false},
                                            {true, true, true},
                                            {false, true, false}};
    public Cruz3x3(){
        super(PECA);
    }
}

class ZL4x5 extends Peca{
    private static final boolean[][] PECA = {{true, true, false, false, false},
                                            {false, true, true, true, false},
                                            {false, false, true, false, false},
                                            {false, false, true, true, true}};
    public ZL4x5(){
        super(PECA);
    }
}