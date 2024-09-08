package GuiaEjs;
import Logica.*;
import Logica.ListaEnlazada.Nodo;
//Voy a usar Listas que es lo mismo
public class EjerciciosCola {

    //ej 4) a-
    public static void PasarColaAOtra(ListaEnlazada c1, ListaEnlazada c2){
        Nodo movil = c1.primero;
        c2.vaciar();
        while(movil != null){
            c2.Agregar(movil.contenido);
            movil = movil.siguiente;
        }
        return;
    }

    //ej 4) b-
    public static void InvertirCola(ListaEnlazada c1) {
        ListaEnlazada aux = new ListaEnlazada();
        Nodo movil = c1.primero;
        
        // Recorrer la lista original y agregar cada nodo al principio de la lista auxiliar
        while (movil != null) {
            aux.AgregarAlInicio(movil.contenido);
            movil = movil.siguiente;
        }
        
        // Vaciar la lista original
        c1.vaciar();
        
        // Pasar los elementos de la lista auxiliar de vuelta a la lista original
        PasarColaAOtra(aux, c1);
    }

    //ej 4) c-
    public static void InvertirColaSinAux(ListaEnlazada c1){
        Nodo movil = c1.primero;
        Nodo previo = null;
        Nodo siguiente = null;
        while(movil != null){
            siguiente = movil.siguiente;
            movil.siguiente = previo;
            previo = movil;
            movil = siguiente;
        }
        c1.primero = previo;
    }

    public static boolean ColasTerminanIgual(ListaEnlazada c1, ListaEnlazada c2){
        Nodo movil1 =  c1.primero;
        Nodo movil2 =  c2.primero;
        while(movil1.siguiente != null){
            movil1 = movil1.siguiente;
        }
        while(movil2.siguiente != null){
            movil2 = movil2.siguiente;
        }

        return movil1.contenido == movil2.contenido;
    }

    public static boolean EsCapicua(ListaEnlazada c1){
        Nodo movil = c1.primero;
        Pila aux = new Pila();
        while (movil != null) {
            aux.Apilar(movil.contenido);
            movil = movil.siguiente;            
        }
        movil = c1.primero;
        while(movil != null){
            if(movil.contenido != aux.Tope()){
                return false;
            }
            aux.Desapilar();
            movil = movil.siguiente;
        }
        return true;
    }

    public static boolean SonInversas(ListaEnlazada c1, ListaEnlazada c2){
        if (c1.largo != c2.largo) {
            return false;
        }
        Nodo movil1 = c1.primero;
        Pila aux = new Pila();
        while (movil1 != null) {
            aux.Apilar(movil1.contenido);
            movil1 = movil1.siguiente;
        }
        Nodo movil2 = c2.primero;
        while (movil2 != null) {
            if (movil2.contenido != aux.Tope()) {
                return false;
            }
            movil2 = movil2.siguiente;
            aux.Desapilar();
        }
        return true;
    }
    //ej 2.1
    public static void EliminarDuplicados(ListaEnlazada c1){
        Nodo movil = c1.primero;
        ListaEnlazada aux = new ListaEnlazada();
        while(movil != null){
            if (!aux.pertenece(movil.contenido)){
                aux.Agregar(movil.contenido);
            }
            movil = movil.siguiente;
        }
        c1.vaciar();
        PasarColaAOtra(aux, c1);
        return;
    }

    //ej 2.2
    public static ListaEnlazada[] RepartirCola(ListaEnlazada c1){
        ListaEnlazada c2 = new ListaEnlazada();
        ListaEnlazada c3 = new ListaEnlazada();
        boolean turno = true;
        Nodo movil = c1.primero;
        while (movil != null) {
            if (turno) {
                c2.Agregar(movil.contenido);
            } else {
                c3.Agregar(movil.contenido);
            }
            turno = !turno;
            movil = movil.siguiente;
        }
        return new ListaEnlazada[] {c2, c3};
    }

    // ej 2.3
    public static Conjunto ConjuntoDeRepetidos(ListaEnlazada l1){
        Conjunto res = new Conjunto();
        ListaEnlazada aux = new ListaEnlazada();
        Nodo movil = l1.primero;
        while(movil != null){
            if (!aux.pertenece(movil.contenido)){
                aux.Agregar(movil.contenido);
            }else{
                res.agregar(movil.contenido);
            }
            movil = movil.siguiente;
        }
        return res;
    }
    public static void main(String[] args) {
        //test ej 4)a
        ListaEnlazada c1 = new ListaEnlazada();
        c1.Agregar(10);
        c1.Agregar(20);
        c1.Agregar(30);
        ListaEnlazada c2 = new ListaEnlazada();
        PasarColaAOtra(c1, c2);
        System.out.println("Cola 1: " + c1.toString());
        System.out.println("Cola 2: " + c2.toString());
        //test ej 4)b
        InvertirCola(c1);
        System.out.println("Cola 1 invertida: " + c1.toString());
        InvertirCola(c1);
        System.out.println("Cola 1 de vuelta en orden: " + c1.toString());
        //test ej 4)c
        InvertirColaSinAux(c1);
        System.out.println("Cola 1 invertida sin aux: " + c1.toString());
        //test ej 4)d
        System.out.println("Terminan igual: " + ColasTerminanIgual(c1, c2));
        InvertirCola(c1); // pongo de nuevo en orden para que de true 
        System.out.println("Terminan igual: " + ColasTerminanIgual(c1, c2)); // deberia dar true
        //test ej 4)e
        System.out.println("Es capicua: " + EsCapicua(c1)); // deberia dar false
        c1.Agregar(20);
        c1.Agregar(10);
        System.out.println("Es capicua: " + EsCapicua(c1)); // deberia dar true
        //test ej 4)f
        System.out.println("Son inversas: " + SonInversas(c1, c2));// deberia dar false
        c1.vaciar();
        PasarColaAOtra(c2, c1);
        InvertirCola(c1);
        System.out.println("Cola 1: " + c1.toString());
        System.out.println("Cola 2: " + c2.toString());
        System.out.println("Son inversas: " + SonInversas(c1, c2));// deberia dar true

        //test ej 2.1
        ListaEnlazada c10 = new ListaEnlazada();
        c10.Agregar(10);
        c10.Agregar(20);
        c10.Agregar(10);
        c10.Agregar(30);
        c10.Agregar(20);
        c10.Agregar(40);
        System.out.println("Cola 10 con duplicados: " + c10.toString());
        EliminarDuplicados(c10);
        System.out.println("Cola 10 sin duplicados: " + c10.toString());

        //test ej 2.2
        ListaEnlazada[] resultado = RepartirCola(c10);
        for(ListaEnlazada i : resultado){
            System.out.println(i);
        }

        // test ej 2.3
        ListaEnlazada c11 = new ListaEnlazada();
        c11.Agregar(10);
        c11.Agregar(20);
        c11.Agregar(10);
        c11.Agregar(30);
        c11.Agregar(20);
        Conjunto resConjunto = ConjuntoDeRepetidos(c11);
        System.out.println("Conjunto de repetidos: " + resConjunto.toString());
    }

}
