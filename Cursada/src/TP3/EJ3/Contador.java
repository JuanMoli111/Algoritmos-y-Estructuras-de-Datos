package TP3.EJ3;


import TP2.ListaEnlazadaGenerica;
import TP3.ArbolBinario;

public class Contador {
     

    ArbolBinario<Integer> AB = new ArbolBinario<>();


    public void setAB(ArbolBinario<Integer> Arbol)
    {
        this.AB = Arbol;
    }
    public ArbolBinario<Integer> getAB()
    {
        return this.AB;
    }



    public ListaEnlazadaGenerica<Integer> numerosParesInorden(ArbolBinario<Integer> Arbol)
    {
        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();


            if(!Arbol.esVacio())
            {
                Integer dato = Arbol.getDato();

                
                //Aqui agregamos un dato a la lista un INTEGER en las invocaciones recursivas agregmoas una LISTA DE INTEGERS y mediante métodos, no confundir
                if(Arbol.tieneHijoIzquierdo())
                {
                    Lista.agregarLista(numerosParesInorden(Arbol.getHijoIzquierdo()));
                }

                if(dato % 2 == 0) Lista.agregarFinal(dato);

                if(Arbol.tieneHijoDerecho())
                {
                    Lista.agregarLista(numerosParesInorden(Arbol.getHijoDerecho()));
                }
                

            }   

        return Lista;

        
    }

    public ListaEnlazadaGenerica<Integer> numerosParesPostorden(ArbolBinario<Integer> Arbol)
    {
        ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();


            if(!Arbol.esVacio())
            {

                Integer dato = Arbol.getDato();

                //Aqui agregamos un dato a la lista un INTEGER en las invocaciones recursivas agregmoas una LISTA DE INTEGERS y mediante métodos, no confundir

                if(Arbol.tieneHijoIzquierdo())
                {
                    Lista.agregarLista(numerosParesPostorden(Arbol.getHijoIzquierdo()));
                }
                if(Arbol.tieneHijoDerecho())
                {
                    Lista.agregarLista(numerosParesPostorden(Arbol.getHijoDerecho()));
                }

                if(dato % 2 == 0) Lista.agregarFinal(dato);
                

            }   

        return Lista;

        
    }




    public static void main(String[] args) {
        
        Contador Cont = new Contador();

        ArbolBinario<Integer> ArB = new ArbolBinario<>();

        //Cargar el arbol
        {
            //SETEAR LA RAIZ
            ArB.setDato(5);
        
            //SETEAR LOS HIJOS INSTANCIANDO NUEVOS ARBOLES BINARIOS
            ArB.agregarHijoDerecho(new ArbolBinario<>(2));
            ArB.agregarHijoIzquierdo(new ArbolBinario<>(617));
            
            
            ArB.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(44));
            ArB.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(51));

            ArB.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(61));
            ArB.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(681));
                  


            ArB.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(4412));
            ArB.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(551));

            ArB.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(616));
            ArB.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(6816));
        
        }

        Cont.setAB(ArB);


        ListaEnlazadaGenerica<Integer> ListaPares = new ListaEnlazadaGenerica<>();



        ListaPares = Cont.numerosParesInorden(Cont.getAB());

        ListaPares.comenzar();

        while(!ListaPares.fin()) System.out.println(ListaPares.proximo());

        
        System.out.println();
        System.out.println();
        System.out.println();


        ListaPares = Cont.numerosParesPostorden(Cont.getAB());

        ListaPares.comenzar();

        while(!ListaPares.fin()) System.out.println(ListaPares.proximo());
    }
}
