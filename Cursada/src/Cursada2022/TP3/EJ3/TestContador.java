package Cursada2022.TP3.EJ3;

import Cursada2022.TP2.ListasGenericas.ListaEnlazadaGenerica;
import Cursada2022.TP3.ArbolBinario.ArbolBinario;

public class TestContador {
    


    public static void main(String[] args) {
        
        ArbolBinario<Integer> AB = new ArbolBinario<Integer>(1);


        AB.agregarHijoDerecho(new ArbolBinario<Integer>(3));
        AB.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));

        ArbolBinario<Integer> SubArbolIzq = AB.getHijoIzquierdo();
        ArbolBinario<Integer> SubArbolDer = AB.getHijoDerecho();
     
        SubArbolDer.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
        SubArbolDer.agregarHijoDerecho(new ArbolBinario<Integer>(7));
        
        SubArbolIzq.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
        SubArbolIzq.agregarHijoDerecho(new ArbolBinario<Integer>(5));



        ContadorArbol Cont = new ContadorArbol(AB);

        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();

        Lista = Cont.numerosParesPostOrden();

        Lista.comenzar();
        while(!Lista.fin()){
            System.out.println(Lista.proximo());
        }

    }
}
