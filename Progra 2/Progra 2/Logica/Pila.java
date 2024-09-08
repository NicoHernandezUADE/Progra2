package Logica;

public class Pila implements Interfaces.I_Pila{
    public Nodo primero;
    public int largo;

    public class Nodo{
        public Nodo siguiente;
        public int contenido;    
    }

    public Pila(){
        this.InicializarPila();
    }

    @Override
    public void Apilar(int x){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.contenido = x;
        nuevoNodo.siguiente = this.primero;
        primero = nuevoNodo;
        /*if (this.largo == 0) {
            this.primero = nuevoNodo;
        }else{
            Nodo movil = this.primero;
            while (movil.siguiente != null) {
                movil = movil.siguiente;
            }
            movil = nuevoNodo;
        }*/
        this.largo++;
    }

    @Override
    public String toString() {
        if (this.PilaVacia()) {
            return "La pila está vacía";
        }

        StringBuilder sb = new StringBuilder();
        Nodo actual = this.primero;

        while (actual != null) {
            sb.append(actual.contenido).append(" -> ");
            actual = actual.siguiente;
        }

        // Eliminar el último " -> " innecesario
        sb.setLength(sb.length() - 4);

        return sb.toString();
    }


    @Override
    public void Desapilar() {
        // TODO Auto-generated method stub
        if(this.PilaVacia()){
            System.out.println("La pila esta vacia");
            return;
        }
        this.primero = this.primero.siguiente;
        this.largo--;
    }

    @Override
    public boolean PilaVacia() {
        // TODO Auto-generated method stub
        return this.largo == 0;
    }

    @Override
    public void Vaciar() {
        // TODO Auto-generated method stub
        this.primero.siguiente = null;
        this.largo = 0;
    }

    @Override
    public int Largo() {
        // TODO Auto-generated method stub
        return this.largo;
    }

    @Override
    public void InicializarPila() {
        // TODO Auto-generated method stub
        this.largo = 0;
        this.primero = null;
    }

    @Override
    public int Tope() {
        return this.primero.contenido; 
    }
    
}
