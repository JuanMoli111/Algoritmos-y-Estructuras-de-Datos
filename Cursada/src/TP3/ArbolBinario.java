package TP3;

import TP2.ColaGenerica;
import TP2.ListaEnlazadaGenerica;
import TP2.ListaGenerica;

public class ArbolBinario<T> {
	
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}


	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public boolean esLleno() {
		return false;
	}

	 boolean esCompleto() {
		return false;
	}

	
	// imprime el árbol en preorden  
	public void printPreorden() {
		System.out.println(this.getDato() + " ");
	
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPreorden();
	
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPreorden();
		
	}

	// imprime el arbol en inorden
	public void printInorden() {
	
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printInorden();
			
		System.out.println(this.getDato() + " ");

		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printInorden();

	}

	// imprime el arbol en postorden
	public void printPostorden() {
	
		if(this.tieneHijoIzquierdo())
			this.getHijoIzquierdo().printPostorden();
	
		if(this.tieneHijoDerecho())
			this.getHijoDerecho().printPostorden();

		System.out.println(this.getDato() + " ");

	}

	public void recorridoPorNiveles() {


		if(!this.esVacio())
		{

			//Crear una cola
			ColaGenerica<ArbolBinario<T>> Cola = new ColaGenerica<>();
			//Encolar la raiz y el null que sirve de marca para el fin del nivel
			Cola.encolar(this);
			Cola.encolar(null);

			//Mientras haya elementos 
			while(!Cola.esVacia()){ 

				//Saca un elemento
				ArbolBinario<T> elem = Cola.desencolar();

				//Comprobar si es un elemento o una marca de fin de nivel
				if(elem != null)
				{
					//Proceso el dato
					System.out.print(elem.getDato() + " ");

					//Encola los hijos si corresponde
					if(elem.tieneHijoIzquierdo())
						Cola.encolar(elem.getHijoIzquierdo());
					if(elem.tieneHijoDerecho())
						Cola.encolar(elem.getHijoDerecho());
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
	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}

	
	
	
	public int contarHojas() {


		//Si es vacio retornar cero
		if(this.esVacio()) return 0;
		//Si es arbol hoja, retornar uno
		else if(this.esHoja())	return 1;
		else
		{
			int n = 0;

			if(tieneHijoDerecho())
			{
				n += this.getHijoDerecho().contarHojas(); 
			}

			if(tieneHijoIzquierdo())
			{
				n += this.getHijoIzquierdo().contarHojas(); 
			}
			
			return n;
		}

	}



	public ArbolBinario<T> espejo()
	{

		ArbolBinario<T> ArbolEspejo = new ArbolBinario<>(this.getDato());

		//Caso base si es una hoja retornar la misma hoja
		if(this.esVacio() || this.esHoja())	return ArbolEspejo;
		else
		{
			//Procesar los hijos, si hay hijo izq, agregar al arbol espejo como hijo derecho, el hijo izq invocando el metodo espejo (recursion) y viceversa.
			if(this.tieneHijoIzquierdo()) ArbolEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());

			if(this.tieneHijoDerecho())  ArbolEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			
			//Retornar el arbol espejado
		}
	
		return ArbolEspejo;

	}



}
