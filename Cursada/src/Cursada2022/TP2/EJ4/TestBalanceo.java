package Cursada2022.TP2.EJ4;

import Cursada2022.TP2.ListasGenericas.PilaGenerica;
import java.util.Scanner;


public class TestBalanceo {
    
    public static boolean esApertura(char c){
        if((c == '{') || (c == '[') || (c == '(')) return true;
        else return false;
    }

    public static boolean esCierre(char c){
        if((c == '}') || (c == ']') || (c == ')')) return true;
        else return false;
    }

    public static void main(String[] args) {
        //declarar pila de caracteres
        PilaGenerica<Character> Pila = new PilaGenerica<Character>();

        //bal indica si el string es balanceado 
        boolean bal = true;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese una cadena de caracteres conformada por ({,[,(,},],) se procesara para saber si es balanceada");
        String str = new String(teclado.next());
        teclado.close();

        //Mientras el str tenga caracteres y no haya demostrado ser desbalanceado
        while((str.length() > 0) && (bal)){
            
            //Salvar el primer char
            char c = str.charAt(0);

            //Eliminarlo del string
            str = str.substring(1);

            //Si es un caracter de apertura apilarlo
            if(esApertura(c)){
                Pila.apilar(c);
            }
            //Si es un char de cierre
            else if(esCierre(c)){
                
                //Desapilar el ultimo caracter de apertura apilado
                char item = Pila.desapilar();

                //Si el caracter de apertura desapilado no corresponde al de cierre, el string no es balanceado --> bal = false
                switch (c) {
                    case '}':
                        if(item != '{') bal = false;            
                        break;

                    case ')':
                        if(item != '(') bal = false;
                        break;

                    case ']':
                        if(item != '[') bal = false;
                        break;
                }
            }
            //Si no es de cierre ni de apertura devolver falso
            else bal = false;



        }

        //Si bal es true, y la pila quedo vacia (no sobró ningun caracter), entonces demostro ser balanceado
        if((bal) && (Pila.esVacia())){
            System.out.println("El string es balanceado");
        }
        else{
            System.out.println("El string no es balanceado");
        }


        
          
    }
}
