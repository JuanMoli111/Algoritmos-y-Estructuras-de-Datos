package Cursada2022.TP3.EJ5;

import Cursada2022.TP2.ListasGenericas.ColaGenerica;
import Cursada2022.TP3.ArbolBinario.ArbolBinario;

public class P3E5 {
    private ArbolBinario<Integer> ab;


    public P3E5(ArbolBinario<Integer> ab) {
        this.ab = ab;
    }


    public ArbolBinario<Integer> getAb() {
        return ab;
    }


    public void setAb(ArbolBinario<Integer> ab) {
        this.ab = ab;
    }

    //Recibe un int y retorna la suma de los elementos de ese nivel del arbol. recorre el arbol por niveles
    public int sumaElementosProfundidad(int p){

        //Declarar obj arbol binario de INTEGERS, declarar un Queue de Arboles Binarios de INTEGER
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> Queue = new ColaGenerica<ArbolBinario<Integer>>();

        
		int suma = 0;
        int nivel = 0;

		//Encolar la raiz, encolar null
		Queue.encolar(this.getAb());
		Queue.encolar(null);
		
		//Mientras el queue no este vacio
		while(!Queue.esVacia()){

			//Desencolar un nodo
			arbol = Queue.desencolar();

			//Si el nodo no es nulo
			if(arbol != null){

				//Si el dato esta en el nivel solicitado, sumarlo
				if(nivel == p) suma += arbol.getDato();

				//Si tiene hijos encolarlos
				if(arbol.tieneHijoIzquierdo())
					Queue.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					Queue.encolar(arbol.getHijoDerecho());

			}//Si el nodo era nulo y la cola esta vacia, paso al sig nivel
			else if(!Queue.esVacia()){

				nivel++;
				Queue.encolar(null);
			}

		}

        //Retornar la suma de los datos solicitados
        return suma;
    }




}
