package Cursada2022.TP2.eje1;

import Cursada2022.TP2.ListasDeEnteros.ListaDeEnteros;
import Cursada2022.TP2.ListasDeEnteros.ListaDeEnterosConArreglos;

import java.util.Scanner;


public class TestListaDeEnterosConArreglos {
    
    public static void ImprimirRecursivo(ListaDeEnteros lista){
        
        if(lista.fin())
            lista.comenzar();


        if(!lista.fin()){

            System.out.println(lista.proximo());

            lista.eliminarEn(1);

            ImprimirRecursivo(lista);
        }
    }

    public static void main(String[] args) {
    
        ListaDeEnterosConArreglos Lista = new ListaDeEnterosConArreglos();
        


        Scanner read = new Scanner(System.in);

        int s = read.nextInt();

        while(s != 0){
            Lista.agregarFinal(s);

            s = read.nextInt();
        }   

        read.close();



        /*while(!Lista.fin()) {
            System.out.println(Lista.proximo());           
        }*/

        //Lista.comenzar();

        ImprimirRecursivo(Lista);
    }

}
