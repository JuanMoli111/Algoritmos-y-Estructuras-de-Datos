package TP2.EJ1;

import TP2.ListaDeEnterosEnlazada;

public class eje1inc6 {


    public ListaDeEnterosEnlazada calcularSucesion(int n)
    {
        //Crear lista
        ListaDeEnterosEnlazada Lista = new ListaDeEnterosEnlazada();

        //Si n es un nro a agregar 
        if(n > 1)
        {

            //Invocarse a si mismo pasandole n/2 si n es par, guardar el retorno en Lista
            if(n % 2 == 0)
            {
                Lista = calcularSucesion(n/2);
            }

            //Invocarse a si mismo pasandole 3*n + 1 si n es impar, guardar el retorno en Lista
            else
            {
                Lista = calcularSucesion((3 * n) + 1);

            }

            //Agregar el entero recibido por parametro
            Lista.agregarInicio(n);

        }
        //Caso base
        else
        {
            Lista.agregarInicio(1);
        }


        return Lista;

    }


    public static void main(String[] args) {
        
        eje1inc6 ej = new eje1inc6();

        ListaDeEnterosEnlazada Lista = new ListaDeEnterosEnlazada();

        Lista = ej.calcularSucesion(141);

        Lista.comenzar();

        for(int i = 0; i < Lista.tamanio(); i++)
        {
            System.out.println(Lista.proximo());
        }
    }
    
}
