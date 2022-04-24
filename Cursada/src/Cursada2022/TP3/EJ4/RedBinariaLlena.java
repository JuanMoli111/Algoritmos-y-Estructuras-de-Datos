package Cursada2022.TP3.EJ4;

import Cursada2022.TP3.ArbolBinario.ArbolBinario;

public class RedBinariaLlena {


    private ArbolBinario<Integer> ab;


    public RedBinariaLlena(ArbolBinario<Integer> ab) {
        this.ab = ab;
    }


    public ArbolBinario<Integer> getAb() {
        return ab;
    }

    public void setAb(ArbolBinario<Integer> ab) {
        this.ab = ab;
    }



    //Para una red binaria llena, devuelve el retardo de envio mas grande, o el camino mas grande, sumando los integers de los nodos
    public int retardoReenvio(ArbolBinario<Integer> ab, int total){

        //Si es nulo o vacio, return 0
        if(ab == null || ab.esVacio()) return 0;

        //Si es hoja sumar el dato al total
        if(ab.esHoja()) return total += ab.getDato();

        //Sumar al total, el maximo entre el  retorno del subarbol hijo izquierdo y derecho, llamando recursivamente y pasandole el total = ab.getDato para sumar ese elemento
        return total + Math.max(retardoReenvio(ab.getHijoIzquierdo(),ab.getDato()), retardoReenvio(ab.getHijoDerecho(),ab.getDato()));
    }


















    //Para una red binaria llena, devuelve el elemento mas grande, del ultimo nivel, recursivamente
    public int retardoReenvioUltimaCapa(ArbolBinario<Integer> ab, int total){

        //Si es nulo o vacio, return 0
        if(ab == null || ab.esVacio()) return 0;

        //Si es hoja, sumar el dato al total
        if(ab.esHoja()) return total += ab.getDato();

        //Sumarle al total el valor max entre los hijos, pasandole total en cero,
        return total += Math.max(retardoReenvioUltimaCapa(ab.getHijoIzquierdo(),0), retardoReenvioUltimaCapa(ab.getHijoDerecho(),0));
    }

}
