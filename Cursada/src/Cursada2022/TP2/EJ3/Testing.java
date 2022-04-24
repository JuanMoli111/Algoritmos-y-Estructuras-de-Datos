package Cursada2022.TP2.EJ3;

//import Cursada2022.TP2.ListasGenericas.PilaGenerica;
import Cursada2022.TP2.ListasGenericas.ColaGenerica;

public class Testing {
    

    public static void main(String[] args) {
        
        ColaGenerica<Integer> cola = new ColaGenerica<Integer>();


        //pila.apilar(1); pila.apilar(2); pila.apilar(10);
    
        //cola.encolar(2); cola.encolar(3); cola.encolar(10);


        System.out.println(cola.tope());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());


    }


}
