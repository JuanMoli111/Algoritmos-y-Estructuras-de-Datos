package Cursada2022.TP2.eje1;

import Cursada2022.TP2.ListasDeEnteros.ListaDeEnterosEnlazada;

public class ej1_6 {
    
    public ListaDeEnterosEnlazada calcularSucesion(int n){

        ListaDeEnterosEnlazada Lista = new ListaDeEnterosEnlazada();

        //Caso base
        if(n == 1){
            Lista.agregarFinal(n);

            return Lista;
        }
        else{
            if((Math.floorMod(n, 2) == 0)){
                Lista = calcularSucesion(n/2);
            }
            else{
                Lista = calcularSucesion((3 * n) + 1);
            }

            Lista.agregarInicio(n);

            return Lista;
        }
    }

    public static void main(String[] args) {
        ej1_6 program = new ej1_6();


        ListaDeEnterosEnlazada l = program.calcularSucesion(67);

        l.comenzar();

        while(!l.fin()){
            System.out.println(l.proximo());
        }
    }


}
