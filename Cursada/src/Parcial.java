import TP2.ColaGenerica;
import TP2.ListaEnlazadaGenerica;
import TP2.ListaGenerica;
import TP4.ArbolGeneral;

public class Parcial {
    

    //Retorna el nivel del arbol general cuya suma de los valores de los nodos es menor, si el arbol es vacio retorna -1
    //Devuelve una lista con los valores de los nodos del nivel minimo
    public static Integer resolver(ArbolGeneral<Integer> Arbol, ListaEnlazadaGenerica<Integer> ListaValores)
    {
    
        int nivel = 0;
        int nivelMin= -1;
        
        int minSuma = 99999; 

        int totalNivel = 0;

                //Lista auxiliar para procesar cada nivel
                ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
        if(!Arbol.esVacio())
        { 




			//Crear una cola, para realizar un recorrido por niveles
			ColaGenerica<ArbolGeneral<Integer>> Cola = new ColaGenerica<>();

			//Encolar la raiz y el null que sirve de marca para el fin del nivel
			Cola.encolar(Arbol);
			Cola.encolar(null);

			//Mientras haya elementos 
			while(!Cola.esVacia()){ 

				//Saca un elemento
				ArbolGeneral<Integer> elem = Cola.desencolar();

                
				//Comprobar si es un elemento o una marca de fin de nivel
				if(elem != null)
				{

					//Procesa los hijos si corresponde
					if(elem.getHijos().tamanio() > 0)
					{
                        
                        //Lista para recorrer los hijos
						ListaGenerica<ArbolGeneral<Integer>> lHijos = elem.getHijos();

						lHijos.comenzar();

						while(!lHijos.fin())
                        {
                            ArbolGeneral<Integer> Hijo = lHijos.proximo();

                            Cola.encolar(Hijo);
                            totalNivel += Hijo.getDato();

                            Lista.agregarFinal(Hijo.getDato());
                        }
					}
				} 
				else 
                    if(!Cola.esVacia())
                    {
                        ListaValores = Lista;

                        //Encolar marca de corte
                        System.out.println("Cambio de nivel");
                        Cola.encolar(null);

                        //Si el total calculado es un nuevo MINIMO
                        if(totalNivel < minSuma)
                        {
                            //Actualizar el minimo
                            minSuma = totalNivel;
                                
                            //Actualizar el nivel a retornar
                            nivelMin = nivel;


                        }

                        Lista = new ListaEnlazadaGenerica<Integer>();

                        //Incrementar el nivel y resetear el contador por nivel
                        nivel++;
                        totalNivel = 0;
                    }

			}
		}
        return nivelMin;
	}

    //ta dificil
    public static void main(String[] args) {
        
        ArbolGeneral<Integer> AG = new ArbolGeneral<>(615);

        ListaEnlazadaGenerica<Integer> ListaValores = new ListaEnlazadaGenerica<>();



        AG.agregarHijo(new ArbolGeneral<Integer>(70));
        AG.agregarHijo(new ArbolGeneral<Integer>(40));

        AG.agregarHijo(new ArbolGeneral<Integer>(15));
        AG.agregarHijo(new ArbolGeneral<Integer>(71));

        AG.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
        AG.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(2));
        AG.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(7));
        AG.getHijos().elemento(3).agregarHijo(new ArbolGeneral<Integer>(4));

        AG.getHijos().elemento(1).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
        AG.getHijos().elemento(1).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(2));
        AG.getHijos().elemento(2).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(7));
        AG.getHijos().elemento(3).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(1));
        AG.preOrden();

        System.out.println("");
        System.out.println("");

        AG.recorridoPorNiveles();

        System.out.println("");
        System.out.println("");
        ListaValores.comenzar();

        System.out.println("El nivel con menor suma: " + resolver(AG,ListaValores));
        ListaValores.comenzar();


        while(!ListaValores.fin())
            System.out.println(ListaValores.proximo());

    }
}

