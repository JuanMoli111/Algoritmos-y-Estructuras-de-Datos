package TP2.EJ2.inc1;

import TP1.EJ3.Estudiante;
import TP2.ListaEnlazadaGenerica;


public class TestListaEnlazadaGenerica {
    

    public static void main(String[] args) {
        

        ListaEnlazadaGenerica<Estudiante> Lista = new ListaEnlazadaGenerica<>();

        Estudiante[] array = new Estudiante[4];



        for(int i = 0; i < 4; i++)
        {
            array[i] = new Estudiante("1", "m", "comision", "email", "dir");


            Estudiante temp = new Estudiante("a","b","c","d","e");

            Lista.agregarInicio(temp);

        }


        Lista.agregarArreglo(array);
    
        ListaEnlazadaGenerica<Estudiante> Lista2 = (ListaEnlazadaGenerica<Estudiante>) Lista.clonar();
        
        
        Lista.agregarLista(Lista2);   

        Lista.comenzar();

        for(int i = 0; i < Lista.tamanio(); i++)
        {
            System.out.println(Lista.proximo().tusDatos());
        }



    }





}
