package TP3;

public class TestArboles {
    

    public static void main(String[] args) {
        

        ArbolBinario<Integer> AB = new ArbolBinario<>(1);


        //Cargar el arbol
        {
            AB.agregarHijoDerecho(new ArbolBinario<>(2));
            AB.agregarHijoIzquierdo(new ArbolBinario<>(617));
            
            
            AB.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(44));
            AB.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(51));

            AB.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(61));
            AB.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(681));
        }


        
        AB.recorridoPorNiveles();

        System.out.println();
        System.out.println();

        AB.espejo().recorridoPorNiveles();


    }
}
