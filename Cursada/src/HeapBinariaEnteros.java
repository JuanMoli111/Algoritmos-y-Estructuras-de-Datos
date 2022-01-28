import java.util.Arrays;
import java.util.NoSuchElementException;

/*  ESTA CLASE IMPLEMENTA UNA MAX HEAP BINARIA DE ENTEROS */
public class HeapBinariaEnteros {
    
    private static final int dim = 2;

    private int[] heap;

    private int heapSize;

    public HeapBinariaEnteros(int capacity){
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
       
    }


    public boolean esVacio(){
        return heapSize == 0;
    }

    public boolean esLleno(){
        return heapSize == heap.length;
    }


    //Retorna la posicion del padre del elemento ubicado en la posicion i
    private int parent(int i){
        return(i-1)/dim;
    }

    //Retorna la POSICION del k-ésimo hijo del elemento ubicado en la pos i
    private int kHijo(int i, int k){
        return dim*i + k;
    }
    //EJ:   para el elem ubicado en el indice 2, si tiene dos hijos estos 
    //estan en el indice 4 y 5, para el elem del indice 0, sus hijos estan en
    //0*2 + 1 = 1   y 0 * 2 + 2 = 2

    private int maxChild(int i) { 
        int leftChild = kHijo(i, 1); 
        int rightChild = kHijo(i, 2); 

        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }


    public void insert(int x){
        if(esLleno())
            throw new NoSuchElementException("Heap llena, no puede agregar elementos");

        //Incrementar el tamaño de la heap, insertar el elemento en esta pos
        heap[heapSize++] = x;

        //Percolate up
        heapifyUp(heapSize-1);
    }

    //Eliminar elemento en el indice x
    public int delete(int x){
        if(esVacio())
            throw new NoSuchElementException("Heap vacia, no puede borrar elementos");
        
        //Recupera el elemento a eliminar?
        int key = heap[x];

        //Toma el ultimo elemento y lo almacena en el espacio que quedo vacio
        heap[x] = heap[heapSize - 1];

        //El tamaño de la heap se ve decrementado
        heapSize--;

        //Percolate down
        heapifyDown(x);

        return key;
    
    }

    //Mantiene la propiedad de heap binaria, recibe en i, el tamaño actual de la heap -1
    
    private void heapifyUp(int i){
        
        //Segun, temp estaria almacenando el ultimo elemento de la heap ¿No seria el elemento recien almacenado desde insert?
        
        //Temp es el elemento recien insertado
        int temp = heap[i];

        //Mientras esta pos i, sea mayor a cero, y temp sea mayor al padre de i
        while(i > 0 && temp > heap[parent(i)]){

            //el nodo padre pasa a la pos del hijo 
            heap[i] = heap[parent(i)];

            //actualiza i, es la pos del padre
            i = parent(i);
        }

        //Salva el elemento en la pos correspondiente
        heap[i] = temp;
    }



    //Percolate down, mantiene la propiedad de la heap
    private void heapifyDown(int i){
        int child;

        //Temp es el dato a intercambiar hacia abajo
        int temp = heap[i];

        //Mientras la pos del primer hijo sea menor que el tamaño de la heap
        while(kHijo(i, 1) < heapSize){


            //Salvar el hijo mayor
            child = maxChild(i);

            //Si el dato es menor al hijo
            if(temp < heap[child])

                //Guarda el hijo en la pos del padre, el intercambio
                heap[i] = heap[child]; 

            //Si el dato fue mayor al hijo, break the cycle, ya no deben hacerse intercambios
            else break; 

            //Si siguio iterando, salvar la pos de este hijo, pues ahora habra de comparar y comprobar si debe intercambiarlo con su hijo (nieto)
            i = child; 
        } 
        
        //Finalizada la iteracion, salva el dato en su nueva posicion
        heap[i] = temp; 
    } 
            
    public void printHeap()
        {
            System.out.print("nHeap = ");
            for (int i = 0; i < heapSize; i++)
                System.out.print(heap[i] +" ");
            System.out.println();
        }
    /**
     *  This method returns the max element of the heap.
     *  complexity: O(1)
     */
     public int findMax(){
         if(esVacio())
             throw new NoSuchElementException("Heap is empty.");
         return heap[0];
     }
      
     public static void main(String[] args){
         HeapBinariaEnteros maxHeap = new HeapBinariaEnteros(10);
         maxHeap.insert(10);
         maxHeap.insert(4);
         maxHeap.insert(9);
         maxHeap.insert(1);
         maxHeap.insert(7);
         maxHeap.insert(5);
         maxHeap.insert(3);
          
         maxHeap.printHeap();
         maxHeap.delete(0);
         maxHeap.delete(1);
         maxHeap.delete(2);
         maxHeap.printHeap();
          
    }
}