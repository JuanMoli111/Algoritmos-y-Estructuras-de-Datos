package TP2.EJ4;

import java.util.Scanner;

import TP2.PilaGenerica;

public class TestBalanceo {
    

    public static void main(String[] args) {

        //Declarar una Pila Generica de tipos Character
        PilaGenerica<Character> Pila = new PilaGenerica<>();


        //Declarar un scanner para el input de la cadena 
        Scanner s = new Scanner(System.in);

        //Input de la cadena de texto
        System.out.println("Ingrese una cadena que solo use caracteres: ( { [ ] } )");
        String Cadena = s.nextLine();

        //Cerrar el scanner
        s.close();

        //Declarar variable booleana que indica si la cadena es balanceada o no
        Boolean esBal = true;

        //Declarar dos variables para el manejo y comparacion de los caracteres de la cadena y de la pila
        char primerChar, desapilado;

        //Mientras la cadena tenga caracteres y no se haya demostrado que no es balanceada..
        while ((Cadena != "") & (esBal == true))
        {

            //Tomar el primer caracter del string ingresado
            primerChar = Cadena.charAt(0);

            //System.out.println(primerChar);

            //Si es un caracter de apertura apilarlo
            if((primerChar == '{') || (primerChar == '(') || (primerChar == '['))
            {
                Pila.apilar(primerChar);
            }
            //Si es un caracter de cierre...
            else if((primerChar == '}') || (primerChar == ')') || (primerChar == ']'))
            {

                //Desapilar un elemento de la pila, si la pila esta vacia es xq esta cadena no apilo un caracter 
                //de apertura para este caracter de cierre, entonces no es balanceada (clausula else)
                if(!Pila.esVacia())
                {
                    desapilado = Pila.desapilar();

                    //Switch case, para cada char de cierre, verifica si el char desapilado es su char de apertura
                    switch (primerChar) {
                        case '}':

                            if(desapilado != '{')
                            {
                                esBal = false;
                            } 

                            break;
                    
                        case ')':

                            if(desapilado != '(')
                            {
                                esBal = false;
                            } 
                            break;
                        
                        case ']':
                            if(desapilado != '[')
                            {
                                esBal = false;
                            }

                            break;
                    }
                }
                else
                {
                    esBal = false;
                }
            }
            else
            {
                System.out.println("Caracter invalido " + primerChar + " error");
                esBal = false;
            }


            //Eliminar el primer caracter de la cadena
            Cadena = Cadena.substring(1, Cadena.length());

        }

        //Si la pila aun tiene elementos entonces no era balanceada
        if(!Pila.esVacia())
        {
            esBal = false;
        }


        if(esBal)
        {
            System.out.println("El string es balanceado");
        }
        else
        {
            System.out.println("El string NO es balanceado");
        }



    }
}