package Cursada2022.TP3.ArbolBinario;

public class TestTree {
    

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

        SubArbolIzq.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
        SubArbolIzq.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(9));
        SubArbolIzq.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
        SubArbolIzq.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(11));

        SubArbolDer.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(12));
        SubArbolDer.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(13));
        SubArbolDer.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(14));
        SubArbolDer.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(15));



        AB.porNiveles();

        System.out.println();
        
        AB.espejo().porNiveles();
        System.out.println();


        AB.entreNiveles(3, 1);
    }
}
