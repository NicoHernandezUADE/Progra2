package Logica;

public class ListaEnlazadaPrioridad{

    public Nodo primero;
    public int largo;

    public class Nodo{
        public Nodo siguiente;
        public int contenido;
        public int prioridad;    
    }

    public ListaEnlazadaPrioridad(){
        this.InicializarLista();
    }


    public void InicializarLista() {
        // TODO Auto-generated method stub
        this.primero = null;
        this.largo = 0;
    }

    public void Agregar(int  x, int prioridad) {
        // TODO Auto-generated method stub
        Nodo nuevNodo = new Nodo();
        nuevNodo.contenido = x;
        nuevNodo.prioridad = prioridad;
        nuevNodo.siguiente = null;

       if(this.largo == 0 || this.primero.prioridad < prioridad){
            nuevNodo.siguiente = this.primero;
            this.primero= nuevNodo;
        }else{
            Nodo movil = this.primero;
            while (movil.siguiente != null && movil.siguiente.prioridad >= prioridad) {
                movil = movil.siguiente;            
            }
            nuevNodo.siguiente = movil.siguiente;
            movil.siguiente = nuevNodo;
       }
       this.largo++;
    }


    public boolean estaVacia() {
        // TODO Auto-generated method stub
        return this.largo == 0;
    }



    public void vaciar() {
        // TODO Auto-generated method stub
        this.primero = null;
        this.largo = 0;

    }



    public int largo() {
        // TODO Auto-generated method stub
        return this.largo;
    }



    public boolean pertenece(int val) {
        // TODO Auto-generated method stub
        Nodo movil = this.primero;

        if(!this.estaVacia()){  
            while (movil != null) {
                if(movil.contenido == val){
                    return true;
                }
                movil = movil.siguiente;
            }
            return false;
        }
        System.out.println("La lista está vacia");
        return false;
    }


    public void eliminar() {
        // TODO Auto-generated method stub
        if(!this.estaVacia()){
            this.primero = this.primero.siguiente;
            this.largo--;
            return;
        }
        else{ 
            System.out.println("La lista esta vacia");
        }
    }


    /*public void EliminarTodasLasOcurrencias(int val){
        if(this.estaVacia()){
            System.out.println("La lista está vacía");
            return;
        }

        while(this.primero != null && this.primero.contenido == val) {
            this.primero = this.primero.siguiente;
            this.largo--;
        }

        Nodo movil = this.primero;
        while(movil != null && movil.siguiente != null){
            if(movil.siguiente.contenido == val){
                movil.siguiente = movil.siguiente.siguiente;
                this.largo--;
            }else
                movil = movil.siguiente;
        }

    }*/

    @Override
    public String toString(){
        if(!this.estaVacia()){ 
            StringBuilder salida = new StringBuilder();

            Nodo movil = this.primero;
            while(movil != null){
                String sentencia = "(" + movil.contenido + " -  " + movil.prioridad + ")" + " ";
                salida.append(sentencia);
                movil = movil.siguiente;
            }

            return salida.toString().trim();
        }

        return "La lista está vacia";
        
    }

    /*public void insertarEnPosicion(int x, int posicion) { no sirve este metodo
        if (posicion < 0 || posicion > largo) {
            System.out.println("Posición inválida");
            return;
        }
    
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.contenido = x;
    
        if (posicion == 0) {
            // Insertar al principio
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
        } else {
            Nodo actual = primero;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            // Insertar en la posición dada
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    
        largo++;
    }*/

}
