package TP2.EJ1;

import TP2.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {
    


    public static void main(String[] args) {
        
        ListaDeEnterosConArreglos Lista = new ListaDeEnterosConArreglos();

        for (String num : args) {
            
            int vv = Integer.parseInt(num);
            Lista.agregarFinal(vv);
        }

        Lista.comenzar();

        for(int i = 0; i < Lista.tamanio();i++)
        {
            System.out.println(Lista.proximo());
        }



    }

    






}
