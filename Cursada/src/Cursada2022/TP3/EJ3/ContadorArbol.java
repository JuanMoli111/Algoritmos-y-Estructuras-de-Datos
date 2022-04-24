package Cursada2022.TP3.EJ3;

import Cursada2022.TP2.ListasGenericas.ListaEnlazadaGenerica;
import Cursada2022.TP2.ListasGenericas.ListaGenerica;
import Cursada2022.TP3.ArbolBinario.ArbolBinario;

public class ContadorArbol {
 
    private ArbolBinario<Integer> ab;

    


    public ArbolBinario<Integer> getAb() {
        return ab;
    }


    public void setAb(ArbolBinario<Integer> ab) {
        this.ab = ab;
    }


    public ContadorArbol(ArbolBinario<Integer> ab) {
        this.ab = ab;
    }


    //Recorre el arbol in orden, devuelve una lista con los Integer pares del arbol, si el arbol es vacio devuelve NULO
    public ListaEnlazadaGenerica<Integer> numerosParesInOrden(){

        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();

        //Si la raiz es vacio retornar nulo
        if(ab.esVacio()) return null;

        Lista = numerosParesRecursionInOrden(ab);

        return Lista;
    }


    private ListaEnlazadaGenerica<Integer> numerosParesRecursionInOrden(ArbolBinario<Integer> Arbol){//ListaEnlazadaGenerica<Integer> Lista){
        
        //Instanciar una lista vacia
        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();

        //Si el dato es par, agregarlo a la lista
        if(Arbol.getDato() % 2 == 0) Lista.agregarFinal(Arbol.getDato());


        //Si tiene hijos llamar recursivamente, pasar por parametro el sub-arbol hijo
        if(Arbol.tieneHijoIzquierdo()){
            Lista.agregarLista(numerosParesRecursionInOrden(Arbol.getHijoIzquierdo()));
        }

        if(Arbol.tieneHijoDerecho()){
            Lista.agregarLista(numerosParesRecursionInOrden(Arbol.getHijoDerecho()));
        }

        return Lista;
    }


    //Recorre el arbol post orden, devuelve una lista con los Integer pares del arbol, si el arbol es vacio devuelve NULO
    public ListaEnlazadaGenerica<Integer> numerosParesPostOrden(){

        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();

        //Si la raiz es vacio retornar nulo
        if(ab.esVacio()) return null;

        Lista = numerosParesRecursionPostOrden(ab);

        return Lista;
    }

    private ListaEnlazadaGenerica<Integer> numerosParesRecursionPostOrden(ArbolBinario<Integer> Arbol){//ListaEnlazadaGenerica<Integer> Lista){
        
        //Instanciar una lista vacia
        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();


        //Si tiene hijos llamar recursivamente, pasar por parametro el sub-arbol hijo
        if(Arbol.tieneHijoIzquierdo()){
            Lista.agregarLista(numerosParesRecursionPostOrden(Arbol.getHijoIzquierdo()));
        }

        if(Arbol.tieneHijoDerecho()){
            Lista.agregarLista(numerosParesRecursionPostOrden(Arbol.getHijoDerecho()));
        }

        //Si el dato es par, agregarlo a la lista
        if(Arbol.getDato() % 2 == 0) Lista.agregarFinal(Arbol.getDato());

        return Lista;
    }
}