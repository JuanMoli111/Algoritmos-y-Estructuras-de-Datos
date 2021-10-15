package TP3.EJ4;

import TP3.ArbolBinario;


public class RedBinariaLlena{


    ArbolBinario<Integer> AB = new ArbolBinario<>();
    
    public void setAB(ArbolBinario<Integer> Arbol)
    {
        this.AB = Arbol;
    }
    public ArbolBinario<Integer> getAB()
    {
        return this.AB;
    }


    public int retardoReenviofff(ArbolBinario<Integer> Arbol)
    {


        //int n = 0;


        if(!Arbol.esVacio())
        {

            //Si es una hoja retornar el int del nodo
            if(Arbol.esHoja()) return Arbol.getDato();
            else{
            //SI NO ES UNA HOJA SEGURO TIENE DOS HIJOS, POR SER RED BINARIA LLENA

                //comprobar cual de los hijos es mayor, retornarlo

                if(Arbol.getHijoDerecho().getDato() > Arbol.getHijoIzquierdo().getDato())
                {
                    return Arbol.getDato() + retardoReenvio(Arbol.getHijoDerecho());
                }
                else return Arbol.getDato() + retardoReenvio(Arbol.getHijoIzquierdo());

            }


        }

        return 0;

    }

    public int retardoReenvio(ArbolBinario<Integer> Arbol)
    {


        //int n = 0;


        if(!Arbol.esVacio())
        {

            //Si es una hoja retornar el int del nodo
            if(Arbol.esHoja()) return Arbol.getDato();
            else{
            //SI NO ES UNA HOJA SEGURO TIENE DOS HIJOS, POR SER RED BINARIA LLENA

                //comprobar cual de los hijos es mayor, retornarlo

                int I = retardoReenvio(Arbol.getHijoIzquierdo());
                int D = retardoReenvio(Arbol.getHijoDerecho());


                if(I > D)
                {
                    return Arbol.getDato() + I;
                }
                else return Arbol.getDato() + D;

            }


        }

        return 0;

    }


    public static void main(String[] args) {
                
        RedBinariaLlena Red = new RedBinariaLlena();

        ArbolBinario<Integer> ArB = new ArbolBinario<>();

        //Cargar el arbol
        {
            //SETEAR LA RAIZ
            ArB.setDato(178);
        
            //SETEAR LOS HIJOS INSTANCIANDO NUEVOS ARBOLES BINARIOS
            ArB.agregarHijoDerecho(new ArbolBinario<>(241));
            ArB.agregarHijoIzquierdo(new ArbolBinario<>(515));
            
            ArB.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(262));
            ArB.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(178));

            ArB.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(92));
            ArB.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(512));
                  

            
            /*ArB.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(4412));
            ArB.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(551));

            ArB.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(616));
            ArB.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(6816));
            */
        }

        Red.setAB(ArB);

        Red.getAB().recorridoPorNiveles();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(Red.retardoReenvio(ArB));

    }
}
