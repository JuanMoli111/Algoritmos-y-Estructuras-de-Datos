package TP2.EJ1;

import TP2.ListaDeEnterosEnlazada;

public class eje1inc5 {
    

    public static void printLista(ListaDeEnterosEnlazada Lista)
    {
        if(Lista.fin())
        {
            System.out.println("Caso base");

        }
        else
        {
            int elem = Lista.proximo();

            printLista(Lista);

            //Lista.proximo();
            
            System.out.println(elem);
        }

    }

    public static void main(String[] args) {
        
        ListaDeEnterosEnlazada Lista = new ListaDeEnterosEnlazada();

        for (String num : args) {
            
            int vv = Integer.parseInt(num);
            Lista.agregarFinal(vv);
        }


        Lista.comenzar();
        printLista(Lista);


        Lista.comenzar();
        printLista(Lista);


    }

    
}
