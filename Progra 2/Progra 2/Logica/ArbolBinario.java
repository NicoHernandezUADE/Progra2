package Logica;

import Logica.ListaEnlazadaPrioridad.Nodo;

public class ArbolBinario implements Interfaces.I_ArbolBinario{

    
    class NodoABB{
        public int contenido;
        public ArbolBinario hijoIzq;
        public ArbolBinario hijoDer;
    }

    NodoABB raiz;

    public ArbolBinario(){
        this.inicializarArbol();
    }

    @Override
    public boolean estaVacio() {
        // TODO Auto-generated method stub
        return raiz == null;
    }

    @Override
    public void inicializarArbol() {
        // TODO Auto-generated method stub
        raiz = null;
    }

    @Override
    public int raiz(){
        return raiz.contenido;
    }
    @Override
    public ArbolBinario hijoIzquierdo() {
        // TODO Auto-generated method stub
        return raiz.hijoIzq;
    }

    @Override
    public ArbolBinario hijoDerecho() {
        // TODO Auto-generated method stub
        return raiz.hijoDer;
    }

    @Override
    public void agregar(int valor) {
        if(raiz == null){
            raiz = new NodoABB();
            raiz.contenido = valor;
            raiz.hijoIzq = new ArbolBinario();
            raiz.hijoDer = new ArbolBinario();
        }else if (raiz.contenido > valor){
            raiz.hijoIzq.agregar(valor);        
        }else if (raiz.contenido < valor){
            raiz.hijoDer.agregar(valor);
        }
    }


    public void eliminar(int valor) {
        if(raiz != null){
            if (raiz.contenido == valor && raiz.hijoIzq.estaVacio() && raiz.hijoDer.estaVacio()){
                raiz = null;
            }else if (raiz.contenido == valor && !raiz.hijoIzq.estaVacio()){
                raiz.contenido = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.eliminar(raiz.contenido);
            }else if (raiz.contenido == valor && raiz.hijoIzq.estaVacio()){
                raiz.contenido = this.menor(raiz.hijoDer);
                raiz.hijoDer.eliminar(raiz.contenido);
            }else if (raiz.contenido < valor) {
                raiz.hijoDer.eliminar(valor);
            }else{
                raiz.hijoIzq.eliminar(valor);
            }
        }
    }

    private int mayor(ArbolBinario arbol){
        if(arbol.hijoDerecho().estaVacio()){
            return arbol.raiz();
        }else{
            return mayor(arbol.hijoDerecho());
        }
    }

    private int menor(ArbolBinario arbol){
        if(arbol.hijoIzquierdo().estaVacio()){
            return arbol.raiz();
        }else{
            return menor(arbol.hijoIzquierdo());
        }
    }
    public int Suma(ArbolBinario arbol) {
        if (arbol.estaVacio()) {
            return 0;
        } else {
            return arbol.raiz() + Suma(arbol.hijoIzquierdo()) + Suma(arbol.hijoDerecho());
        }
    }

    // Recorridos
    public void preOrder(ArbolBinario arbol){
        if(!arbol.estaVacio()){
            System.out.println(arbol.raiz());
            preOrder(arbol.hijoIzquierdo());
            preOrder(arbol.hijoDerecho());
        }
    }

    public void inOrder(ArbolBinario arbol){
        if(!arbol.estaVacio()){
            inOrder(arbol.hijoIzquierdo());
            System.out.println(arbol.raiz());
            inOrder(arbol.hijoDerecho());
        }
    }

    public void postOrder(ArbolBinario arbol){
        if(!arbol.estaVacio()){
            postOrder(arbol.hijoIzquierdo());
            postOrder(arbol.hijoDerecho());
            System.out.println(arbol.raiz());
        }
    }

    // ejercicios extra
    // a determinar si existe un valor en el arbol
    public boolean existe(int valor){
        if(raiz != null){
            if(raiz.contenido == valor){
                return true;
            }else if(raiz.contenido > valor){
                return raiz.hijoIzq.existe(valor);
            }else if (raiz.contenido < valor){
                return raiz.hijoDer.existe(valor);
            }
        }   
        return false;
    }

    // b determinar si es hoja
    public boolean esHoja(int valor){
        if (raiz != null) {
            if(raiz.contenido == valor && raiz.hijoIzq.estaVacio() && raiz.hijoDer.estaVacio()){
                return true;
            }else if (raiz.contenido > valor){
                return raiz.hijoIzq.esHoja(valor);
            }else if (raiz.contenido < valor){
                return raiz.hijoDer.esHoja(valor);
            }
        }
        return false;
    }

    // c determinar profundidad de un elemento
    public int profundidad(int valor){
        if (this.existe(valor)) {
            int profundidad = 0;
            while (raiz != null) {
                if(raiz.contenido == valor){
                    return profundidad;
                }else if (raiz.contenido > valor){
                    raiz = raiz.hijoIzq.raiz;
                }else if (raiz.contenido < valor){
                    raiz = raiz.hijoDer.raiz;
                }
                profundidad++;  
            }
            return profundidad;
        }
        return -1;
    }

    //d menor elemento
    public int MenorValor(){
        if (raiz == null) {
            System.out.println("El arbol está vacío");
            return -1;
        }
        NodoABB movil = raiz;
        while(movil.hijoIzq != null){
            movil = movil.hijoIzq.raiz;
        }
        return movil.contenido;
    }
    //e cantidad de elementos
    /*public int cantidadElementos(ArbolBinario hijoIzq) {
        return cantidadElementos(raiz);
    }
    
    private int cantidadElementos(NodoABB nodo) {
        if (nodo == null) {
            return 0;
        }
        int contadorIzq = cantidadElementos(nodo.hijoIzq);
        int contadorDer = cantidadElementos(nodo.hijoDer);
        return 1 + contadorIzq + contadorDer;
    }*/
    //m mayores que x
    public int mayoresQueX(int x) {
        return mayoresQueX(raiz, x);
    }
    
    private int mayoresQueX(NodoABB nodo, int x) {
        if (nodo == null) {
            return 0;
        }
        int contador = 0;
        if (nodo.contenido > x) {
            contador = 1;
        }
        return contador + mayoresQueX(nodo.hijoIzq, x) + mayoresQueX(nodo.hijoDer, x);
    }
    public static void main(String[] args) {
        ArbolBinario arbol1 = new ArbolBinario();
        arbol1.agregar(5);
        arbol1.agregar(3);
        arbol1.agregar(7);
        arbol1.agregar(2);
        arbol1.agregar(4);
        arbol1.agregar(1);
        //test existe
        System.out.println("Existe el valor 5 : " + arbol1.existe(5)); //expected true
        System.out.println("Existe el valor 58: " + arbol1.existe(58)); //expected false
        //test esHoja
        System.out.println("Es hoja el valor 2 : " + arbol1.esHoja(2)); //expected true
        System.out.println("Es hoja el valor 3 : " + arbol1.esHoja(3)); //expected false
        //test profundidad
        System.out.println("Profundidad del valor 2 : " + arbol1.profundidad(2)); //expected 2
        System.out.println("Profundidad del valor 50 : " + arbol1.profundidad(50)); //expected -1
        //test menor
        //System.out.println("Menor valor del arbol: " + arbol1.MenorValor()); //expected 1
        //test cantidadElementos
        //System.out.println("Cantidad de elementos del arbol: " + arbol1.cantidadElementos()); //expected 6
    }
}
