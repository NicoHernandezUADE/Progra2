package Logica;


import Interfaces.I_ListaEnlazadaDoblementeVinculada;

public class ListaEnlazadaDoblementeVinculada implements I_ListaEnlazadaDoblementeVinculada{

    public class NodoListaDoblementeVinculada{
        NodoListaDoblementeVinculada previo;
        NodoListaDoblementeVinculada siguiente;
        int contenido;
    }

    NodoListaDoblementeVinculada primero;
    NodoListaDoblementeVinculada ultimo;
    int largo;

    public ListaEnlazadaDoblementeVinculada(){
        this.InicializarLista();
    }

    @Override
    public void InicializarLista() {
        this.primero = null;
        this.ultimo = null;
        this.largo = 0;
        
    }

    @Override
    public void Agregar(int x) {
        // TODO Auto-generated method stub
        NodoListaDoblementeVinculada nuevo = new NodoListaDoblementeVinculada();
        nuevo.contenido = x;
        
        if(this.estaVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }else{
            nuevo.previo = this.ultimo;
            this.ultimo.siguiente = nuevo;
            this.ultimo = nuevo;
        }

        this.largo++;
    }

    @Override
    public void eliminar(int x) {
        // TODO Auto-generated method stub
        NodoListaDoblementeVinculada movil = this.primero;
        while(movil != null){
            if (movil.contenido == x) {
                if(movil == this.primero){ 
                    this.primero = movil.siguiente;
                    if(this.primero != null){
                        this.primero.previo = null;
                    }else{
                        this.ultimo = null;
                    }
                }else if (movil == this.ultimo) {
                            this.ultimo = movil.previo;
                            if(this.ultimo != null){
                                this.ultimo.siguiente = null;
                            }else{
                                this.primero = null;
                            }                    
                }else{
                    movil.previo.siguiente = movil.siguiente;
                    movil.siguiente.previo = movil.previo;
                }
                this.largo--;
                return;
            }

            movil = movil.siguiente;
            
        }
        


    }

    @Override
    public boolean estaVacia() {
        // TODO Auto-generated method stub
        return this.primero == null;
    }

    @Override
    public int largo() {
        // TODO Auto-generated method stub
        return this.largo;
    }

    @Override
    public boolean pertenece(int val) {
        // TODO Auto-generated method stub
        NodoListaDoblementeVinculada movil = this.primero;
        while(movil != null){
            if(movil.contenido == val){
                return true;
            }else{
                movil = movil.siguiente;
            }

        }
        return false;
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        this.InicializarLista();
    }
    
    @Override
    public String toString(){
        String salida = "";
        if (!this.estaVacia()) {
            NodoListaDoblementeVinculada movil = this.primero;
            while(movil != null){
                salida += movil.contenido + " ";
                movil = movil.siguiente;
            }
        }
        return salida;
    }
}
