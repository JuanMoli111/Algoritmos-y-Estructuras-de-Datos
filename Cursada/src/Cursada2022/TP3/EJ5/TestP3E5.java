package Cursada2022.TP3.EJ5;

import Cursada2022.TP3.ArbolBinario.ArbolBinario;


public class TestP3E5 {
    
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



        P3E5 Test = new P3E5(AB);

        
        System.out.println(Test.sumaElementosProfundidad(2));

    }
}
