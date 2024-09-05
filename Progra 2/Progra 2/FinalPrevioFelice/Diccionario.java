package FinalPrevioFelice;

import Logica.Conjunto;
import Logica.ListaEnlazada;

public class Diccionario {
    Nodo primero;

    public class Nodo {
        public Integer clave;
        public ListaEnlazada valores;
        public Nodo siguiente;
    }

    public Diccionario(){
        this.primero = null;
    }
    

    public void agregarClave(int c){
        if(!existeClave(c)){
            Nodo nuevo = new Nodo();
            nuevo.clave = c;
            nuevo.valores = new ListaEnlazada();
            nuevo.siguiente = this.primero;
            this.primero = nuevo;
        
        }  
    }

    public void agregarValor(int clave, int valor){
        Nodo pivote = this.primero;
        if (existeClave(clave)) {
            while(pivote != null){
                if (pivote.clave == clave) {
                    pivote.valores.Agregar(valor);
                    return;
                }
                pivote = pivote.siguiente;
            }
        }
    }

    public  boolean existeClave(int c){
        Nodo pivote = this.primero;
        while (pivote != null) {
            if (pivote.clave == c) {
                return true;
            }
            pivote = pivote.siguiente;
        }
        return false;
    }

    public boolean existeValor(int c, int v){
        Nodo pivote = this.primero;
        while (pivote != null) {
            if (pivote.clave == c) {
                return pivote.valores.pertenece(v);
            }
            pivote = pivote.siguiente;
        }
        return false;
    }

    public void eliminarClave(int c){
        if(existeClave(c)){
            if(primero.clave == c){
                primero = primero.siguiente;
            }else{
                Nodo pivote = this.primero;
                while (pivote.siguiente != null) {
                    if (pivote.siguiente.clave == c) {
                        pivote.siguiente = pivote.siguiente.siguiente;
                        return;
                    }
                    pivote = pivote.siguiente;
                }
            }
        }
        return;
    }

    public void eliminarUnValorDeClave(int c, int v){
        if (existeClave(c)) {
            Nodo pivote = this.primero;
            while (pivote != null) {
                if(pivote.clave == c){
                    if ((existeValor(c, v))) {
                        pivote.valores.eliminar(v);
                    }
                }
                pivote = pivote.siguiente;                
            }
        }
    }

    public Conjunto claves(){
        Conjunto c = new Conjunto();
        Nodo pivote = this.primero;
        while(pivote != null){
            c.agregar(pivote.clave);
            pivote = pivote.siguiente;
        }
        return c;
    }
    public static void main(String[] args) {
        Diccionario dic = new Diccionario();
        dic.agregarClave(1);
        dic.agregarClave(4);
        dic.agregarClave(5);
        dic.agregarValor(1, 90);
        dic.agregarValor(1, 1000);
        dic.agregarValor(4, 90);
        dic.agregarValor(4, 100);
        dic.eliminarUnValorDeClave(4, 90);
        System.out.println(dic.claves());
    }
}
