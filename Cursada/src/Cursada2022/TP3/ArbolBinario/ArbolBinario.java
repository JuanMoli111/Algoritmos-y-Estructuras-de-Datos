package Cursada2022.TP3.ArbolBinario;

import Cursada2022.TP2.ListasGenericas.ColaGenerica;


//No llamar metodos con arboles vacios.
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
		return this.hijoIzquierdo != null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public void preOrden(){

		System.out.println(this.getDato());

		if(this.tieneHijoIzquierdo()){
			this.getHijoIzquierdo().preOrden();
		}

		if(this.tieneHijoDerecho()){
			this.getHijoDerecho().preOrden();
		}
	}

	public int contarHojas() {

		//Si el arbol es vacio retornar cero, (no tiene nodos)
		if(this.esVacio()) return 0;

		//Si este arbol es una hoja retornar 1
		if(this.esHoja()) return 1;

		//Si no es hoja seguro tiene algun hijo, incializar un contador de hojas en cero
		int cont = 0;

		//Si tiene hijo izq, sumar en cont la cantidad de hojas en este subarbol izq, llamando recursivamente a contarHojas para ese hijo
		if(this.tieneHijoIzquierdo()) cont += this.getHijoIzquierdo().contarHojas();

		//Si tiene hijo der, contabilizar en cont la cantidad de hojas en este subarbol der, llamando recursivamente a contarHojas para ese hijo
		if(this.tieneHijoDerecho()) cont += this.getHijoDerecho().contarHojas();

		//Retornar cont
		return cont;
	}
	

    public ArbolBinario<T> espejo() {
		
		//Si es arbol vacio retornar null
		if (this.esVacio()) return null;

		//Si es una hoja retornarla (caso base)
		if(this.esHoja()) return this;


		//Si no, crear un arbol para este nodo actual, salvar su dato
		ArbolBinario<T> arbol = new ArbolBinario<T>(this.getDato());

		//Si tiene hijo izq, guardar este subarbol izquierdo, espejado, en el subarbol derecho
		if(this.tieneHijoIzquierdo())
			arbol.agregarHijoDerecho(this.getHijoIzquierdo().espejo());

		//Si tiene hijo der, guardar este subarbol derecho, espejado, en el subarbol izquierdo
		if(this.tieneHijoDerecho())
			arbol.agregarHijoIzquierdo(this.getHijoDerecho().espejo());

		//retornar el arbol espejado
		return arbol;
	}


	public void porNiveles(){

		ArbolBinario<T> arbol = null;

		ColaGenerica<ArbolBinario<T>> Queue = new ColaGenerica<ArbolBinario<T>>();

		//Encolar la raiz, encolar null
		Queue.encolar(this);
		Queue.encolar(null);
		
		//Mientras el queue no este vacio
		while(!Queue.esVacia()){

			//Desencolar un nodo
			arbol = Queue.desencolar();

			//Si el nodo no es nulo
			if(arbol != null){
				System.out.print(arbol.getDato() + " ");

				//Si tiene hijos encolarlos
				if(arbol.tieneHijoIzquierdo())
					Queue.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					Queue.encolar(arbol.getHijoDerecho());

			}//Si el nodo era nulo y la cola esta vacia, paso al sig nivel
			else if(!Queue.esVacia()){
				System.out.println();
				Queue.encolar(null);
			}

		}
	}


	public void entreNiveles(int n, int m){

		ArbolBinario<T> arbol = null;

		ColaGenerica<ArbolBinario<T>> Queue = new ColaGenerica<ArbolBinario<T>>();

		int nivel = 0;

		//Encolar la raiz, encolar null
		Queue.encolar(this);
		Queue.encolar(null);
		
		//Mientras el queue no este vacio
		while(!Queue.esVacia()){

			//Desencolar un nodo
			arbol = Queue.desencolar();

			//Si el nodo no es nulo
			if(arbol != null){

				//Si el dato esta entre los niveles n y m inclusive, imprimirlo
				if((nivel >= n) && (nivel<= m)) System.out.print(arbol.getDato() + " ");

				//Si tiene hijos encolarlos
				if(arbol.tieneHijoIzquierdo())
					Queue.encolar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					Queue.encolar(arbol.getHijoDerecho());

			}//Si el nodo era nulo y la cola esta vacia, paso al sig nivel
			else if(!Queue.esVacia()){
				//Si el nivel es mayor a m, no imprimir mas saltos de linea al recorrer el arbol
				if(nivel <= m) System.out.println();
				nivel++;
				Queue.encolar(null);
			}

		}
	}

	

}
