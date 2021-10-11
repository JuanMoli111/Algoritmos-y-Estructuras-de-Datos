package TP2;

public class ListaDeEnterosConArreglos extends ListaDeEnteros {
	
	private int tamanio;
	private Integer[] datos = new Integer[30];
	private int actual = 0;

	@Override
	public void comenzar() {
		actual = 0;
	}

	@Override
	public Integer proximo() {
		return datos[actual++];
	}

	@Override
	public boolean fin() {
		return actual == tamanio;
	}

	@Override
	public Integer elemento(int pos) {
		return datos[pos - 1];
	}

	@Override
	// Se considera pos 1 al indice 0
	public boolean agregarEn(Integer elem, int pos) {

		//Si la pos es invalida, osea si es menor a uno, o es mayor al length del arreglo
		//o la pos a insertar no es la siguiente al ultimo elem, o si el arreglo esta lleno, NO INSERTAR
		if (pos < 1 || pos > tamanio + 1 || pos > datos.length
				|| tamanio == datos.length)
			return false;

		//Sino inc tamanio,
		tamanio++;

		//Desde el ultimo elem del arreglo hasta el pos indicado ,
		//realizar un corrimiento hacia delante de los elementos que correspondan 
		for (int i = tamanio - 1; i >= pos; i--)
			datos[i] = datos[i - 1];

		
		//guarda el nuevo dato
		datos[pos - 1] = elem;
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		
		return this.agregarEn(elem, 1); 
	}



	@Override
	public boolean eliminar(Integer elem) {
		
		boolean encontre = false;
		int i = 0;
		while (i < tamanio && !encontre) {
			if (datos[i].equals(elem)) {
				eliminarEn(i+1);
				encontre = true;
			}
			i++;
		}
		return encontre;
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > tamanio)
			return false;

		tamanio--;
		for (int i = pos - 1; i < tamanio; i++)
			datos[i] = datos[i + 1];
		return true;
	}

	
	@Override
	public boolean esVacia() {
		
		return (tamanio==0);
	}


	@Override
	public boolean agregarFinal(Integer elem) {
		tamanio++;
		datos[tamanio-1]=elem;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
	
		int i=0;
		while (i<tamanio){
			if (datos[i]==elem){
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public int tamanio() {
		return tamanio;
	}

}
