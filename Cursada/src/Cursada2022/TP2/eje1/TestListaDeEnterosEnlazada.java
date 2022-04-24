package Cursada2022.TP2.eje1;

import Cursada2022.TP2.ListasDeEnteros.ListaDeEnterosEnlazada;

import java.util.Scanner;
public class TestListaDeEnterosEnlazada {


    public static void main(String[] args) {
    
        ListaDeEnterosEnlazada Lista = new ListaDeEnterosEnlazada();


        Scanner read = new Scanner(System.in);

        int s = read.nextInt();

        while(s != 0){
            Lista.agregarFinal(s);

            s = read.nextInt();
        }   

        read.close();

        Lista.comenzar();

        while(!Lista.fin()) System.out.println(Lista.proximo());
    }

}
