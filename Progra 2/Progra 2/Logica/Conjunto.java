package Logica;
import java.util.Random;
public class Conjunto implements Interfaces.I_Conjunto {

    Nodo primero;
    public int largo;

    public Conjunto(){
        this.inicialzarConjunto();
    }
    public class  Nodo {
        int contenido;
        Nodo siguiente;
        
    }

    public void inicialzarConjunto(){
        this.primero = null;
        this.largo = 0;
    }
    public int elegir(){
        Random rand = new Random();
        int posicion = rand.nextInt(0,this.largo);
        Nodo movil = this.primero;
        for(int i=0;i<this.largo;i++){
            if(i == posicion){
                return movil.contenido;
            }
            movil = movil.siguiente;
        }
        throw new IllegalStateException("No se pudo encontrar la posición");
    }

    public void agregar(int x){
        if (!this.pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.contenido = x;
            nuevo.siguiente = this.primero;
            this.primero = nuevo;
            this.largo++;
            return;
        }else{
            System.out.println("Este elemento ya está en el conjunto");
            return;
        }

    }

    public boolean pertenece(int x){
        Nodo movil = this.primero;
        while (movil != null) {
            if (movil.contenido == x) {
                return true;
            }
            movil = movil.siguiente;
        }
        return false;
    }

    public void eliminar(int x) {
        if (this.primero == null) {
            System.out.println("El conjunto está vacío");
            return;
        }
    
        // Si el nodo a eliminar es el primero
        if (this.primero.contenido == x) {
            this.primero = this.primero.siguiente; // Avanzar al siguiente nodo
            this.largo--; // Decrementar el tamaño del conjunto
            return;
        }
    
        // Recorrer la lista para encontrar el nodo a eliminar
        Nodo movil = this.primero;
        while (movil.siguiente != null && movil.siguiente.contenido != x) {
            movil = movil.siguiente;
        }
    
        // Si encontramos el nodo a eliminar
        if (movil.siguiente != null) {
            movil.siguiente = movil.siguiente.siguiente; // Saltar el nodo eliminado
            this.largo--; // Decrementar el tamaño del conjunto
        } else {
            System.out.println("El elemento no pertenece al conjunto");
        }
    }
    @Override
    public String toString(){
        String salida = "";
        Nodo movil = this.primero;
        while (movil != null) {
            salida += movil.contenido + " ";
            movil = movil.siguiente;
        }
        return salida;
    }
    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        this.primero = null;
        this.largo = 0;
    }
    @Override
    public boolean estavacio() {
        // TODO Auto-generated method stub
        return this.primero == null;
    }
    @Override
    public int largo() {
        // TODO Auto-generated method stub
        return this.largo;
    } 
}
