package br.com.yvestaba;

public abstract class Peca {
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

class TEsquerda3x2 extends Peca{
    private static final boolean[][] PECA = {{true, false},
                                            {true, true},
                                            {true, false}};
    public TEsquerda3x2(){
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

class RaioComecaEsquerda3x2 extends Peca{
    private static final boolean[][] PECA = {{true, false},
                                            {true, true},
                                            {false, true}};
    public RaioComecaEsquerda3x2(){
        super(PECA);
    }
}