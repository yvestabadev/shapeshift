package br.com.yvestaba;

import java.util.Arrays;

public class Tabuleiro implements Cloneable{
    private final int[/* y */][/* x */] matriz;
    private final int qtdeTipoPeca;

    public Tabuleiro(int[][] matriz, int qtdePeca) {
        this.matriz = matriz;
        this.qtdeTipoPeca = qtdePeca;
    }

    public void jogarPeca(boolean[][] peca, Coordenada coordenada){
       int x = coordenada.getX();;
       int y = coordenada.getY();
       for(int i = 0; i < peca.length; i++){
           for(int j = 0; j < peca[0].length; j++){
               if(peca[i][j]){
                   mudaImagem(x +j, y + i);
               }
           }
       }
    }

    private void mudaImagem(int x, int y) {
        this.matriz[y][x] = (this.matriz[y][x] + 1) % qtdeTipoPeca;
    }

    //a peça do objetivo tem valor zero
    public boolean ganhou(){
        return Arrays.deepEquals(new int[matriz.length][matriz[0].length], matriz);
    }

    public Tabuleiro clone(){
        var matrizNova = new int[matriz.length][matriz[0].length];
        for(int i = 0; i < matrizNova.length; i++){
            for(int j = 0; j < matrizNova[0].length; j++){
                matrizNova[i][j] = matriz[i][j];
            }
        }
        return new Tabuleiro(matrizNova, this.qtdeTipoPeca);
    }

    public int getTamanhoX(){
        return matriz[0].length;
    }
    public int getTamanhoY(){
        return matriz.length;
    }

    public int getPecaCoordenada(int y, int x){
        return matriz[y][x];
    }
}
