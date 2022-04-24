package Cursada2022.TP3.EJ4;

import Cursada2022.TP3.ArbolBinario.ArbolBinario;
public class TestRedBinariaLlena {
    

    public static void main(String[] args) {
        
                
        ArbolBinario<Integer> AB = new ArbolBinario<Integer>(1);


        AB.agregarHijoDerecho(new ArbolBinario<Integer>(3));
        AB.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));

        ArbolBinario<Integer> SubArbolIzq = AB.getHijoIzquierdo();
        ArbolBinario<Integer> SubArbolDer = AB.getHijoDerecho();
     
        SubArbolDer.agregarHijoIzquierdo(new ArbolBinario<Integer>(26));
        SubArbolDer.agregarHijoDerecho(new ArbolBinario<Integer>(7));
        
        SubArbolIzq.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
        SubArbolIzq.agregarHijoDerecho(new ArbolBinario<Integer>(5));



        RedBinariaLlena Red = new RedBinariaLlena(AB);

        AB.preOrden();

        System.out.println(Red.retardoReenvio(AB,0));

        
    }
}
