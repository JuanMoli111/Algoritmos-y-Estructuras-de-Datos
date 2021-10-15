package TP4;

import TP2.ColaGenerica;
import TP2.ListaEnlazadaGenerica;
import TP2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public void preOrden() {

		System.out.println(this.getDato());

		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();

		lHijos.comenzar();

		while(!lHijos.fin())
			lHijos.proximo().preOrden();
	}


	public void postOrden() {
		
		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();	

		lHijos.comenzar();

		while(!lHijos.fin())
			lHijos.proximo().postOrden();

		System.out.println(this.getDato());

	}

	public void inOrden()
	{
		ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();


		lHijos.comenzar();


		//SI TIENE HIJO IZQ IN ORDEN TO IT

		if(lHijos.tamanio() > 1)
		{
			lHijos.elemento(1).inOrden();

			lHijos.proximo();
		}	

		//Imprimir dato
		System.out.println(this.getDato());


		//In orden al resto de los hijos
		while(!lHijos.fin()){

			lHijos.proximo().inOrden();
		}

	}
	public void recorridoPorNiveles() {


		if(!this.esVacio())
		{

			//Crear una cola
			ColaGenerica<ArbolGeneral<T>> Cola = new ColaGenerica<>();
			//Encolar la raiz y el null que sirve de marca para el fin del nivel
			Cola.encolar(this);
			Cola.encolar(null);

			//Mientras haya elementos 
			while(!Cola.esVacia()){ 

				//Saca un elemento
				ArbolGeneral<T> elem = Cola.desencolar();

				//Comprobar si es un elemento o una marca de fin de nivel
				if(elem != null)
				{
					//Proceso el dato
					System.out.print(elem.getDato() + " ");

					//Encola los hijos si corresponde



					if(elem.getHijos().tamanio() > 0)
					{

						ListaGenerica<ArbolGeneral<T>> lHijos = elem.getHijos();

						lHijos.comenzar();

						while(!lHijos.fin())
							Cola.encolar(lHijos.proximo());

					}
				}
				else
					if(!Cola.esVacia())
					{
						System.out.println();
						Cola.encolar(null);
						
					}
				
			}
		}
	}
	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

	public T getDatoRaiz() {
		return dato;
	}

}