package TP3.EJ5;

import TP2.ColaGenerica;
import TP3.ArbolBinario;

public class ProfundidadDeArbolBinario {
    

    ArbolBinario<Integer> AB = new ArbolBinario<>();
    
    public void setAB(ArbolBinario<Integer> Arbol)
    {
        this.AB = Arbol;
    }
    public ArbolBinario<Integer> getAB()
    {
        return this.AB;
    }

    public int sumaElementosProfundidad(int p)
    {

        int suma = 0;
        int nivel = 1;

		if(!this.AB.esVacio())
		{

			//Crear una cola
			ColaGenerica<ArbolBinario<Integer>> Cola = new ColaGenerica<>();
			//Encolar la raiz y el null que sirve de marca para el fin del nivel
			Cola.encolar(this.AB);
			Cola.encolar(null);

			//Mientras haya elementos 
			while(!Cola.esVacia()){ 

				//Saca un elemento
				ArbolBinario<Integer> elem = Cola.desencolar();

				//Comprobar si es un elemento o una marca de fin de nivel
				if(elem != null)
				{
					//Si el dato esta al nivel solicitado sumarlo al contador
					if(nivel == p)
                        suma += elem.getDato();

					//Encola los hijos si corresponde
					if(elem.tieneHijoIzquierdo())
						Cola.encolar(elem.getHijoIzquierdo());
					if(elem.tieneHijoDerecho())
						Cola.encolar(elem.getHijoDerecho());
				}
				else
					if(!Cola.esVacia())
					{
						Cola.encolar(null);
						nivel++;
					}
				
			}
		}

        return suma;
    }

    public static void main(String[] args) {
        ProfundidadDeArbolBinario Prof = new ProfundidadDeArbolBinario();

        ArbolBinario<Integer> ArB = new ArbolBinario<>();

        //Cargar el arbol
        {
            //SETEAR LA RAIZ
            ArB.setDato(5);
        
            //SETEAR LOS HIJOS INSTANCIANDO NUEVOS ARBOLES BINARIOS
            ArB.agregarHijoDerecho(new ArbolBinario<>(2));
            ArB.agregarHijoIzquierdo(new ArbolBinario<>(33));
            
            
            ArB.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(6));
            ArB.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(4));

            ArB.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(16));
            ArB.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(7));
                  


            ArB.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(1));
            ArB.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(9));

            ArB.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(8));
            ArB.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(5000));
        
        }

        Prof.setAB(ArB);
    
        System.out.println(Prof.sumaElementosProfundidad(1));
        System.out.println(Prof.sumaElementosProfundidad(2));
        System.out.println(Prof.sumaElementosProfundidad(3));
        System.out.println(Prof.sumaElementosProfundidad(4));

    }




}
