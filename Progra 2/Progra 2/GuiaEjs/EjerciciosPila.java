package GuiaEjs;
import Logica.*;
import Logica.ListaEnlazada.Nodo;
public class EjerciciosPila {
    
    //ej2 ) a-
    public static Pila PasarPilaEnOrdenInverso(Pila p1,Pila p2){
        while(!p1.PilaVacia()){
            p2.Apilar(p1.Tope());
            p1.Desapilar();
        }
        return p2;
    }

    //ej2 ) b-
    public static Pila PasarPilaEnOrden(Pila p1, Pila p2){
        Pila aux = new Pila();
        while(!p1.PilaVacia()){
            aux.Apilar(p1.Tope());
            p1.Desapilar();
        }
        while(!aux.PilaVacia()){
            p2.Apilar(aux.Tope());
            p1.Apilar(aux.Tope());
            aux.Desapilar();
        }
        return p2;
    }

    //ej2 ) c-
    public static Pila InvertirPila(Pila p1){
        Pila aux = new Pila();
        while(!p1.PilaVacia()){
            aux.Apilar(p1.Tope());
            p1.Desapilar();
        }
        while(!aux.PilaVacia()){
            p1.Apilar(aux.Tope());
            aux.Desapilar();
        }
        return p1;
    }

    // ej2 ) d-
    public static int ContarElementos(Pila p1){
        Pila aux = new Pila();
        aux = PasarPilaEnOrden(p1, aux);
        int contador = 0;
        while(!aux.PilaVacia()){
            contador++;
            aux.Desapilar();
        }
        return contador;
    }

    // ej2 ) e-
    public static int SumarElementos(Pila pila1){
        Logica.Pila.Nodo aux = pila1.primero;
        int acumulador = 0;
        while (aux != null) {
            acumulador += aux.contenido;
            aux = aux.siguiente;
        }
        return acumulador;
    }

    //ej2 ) f-
    public static double PromedioElementos(Pila pila1){
        return (double) SumarElementos(pila1) / ContarElementos(pila1);
    }
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        pila1.Apilar(1);
        pila1.Apilar(2);
        pila1.Apilar(3);
        //prueba ejercicio a
        System.out.println("Pila 1: " + pila1.toString());
        Pila pila2 = new Pila();
        pila2 = PasarPilaEnOrdenInverso(pila1,pila2);
        System.out.println("Pila 2: " + pila2.toString());

        //prueba ejercicio b
        pila1.Apilar(1);
        pila1.Apilar(2);
        pila1.Apilar(5);
        Pila pila3 = new Pila();
        pila3 = PasarPilaEnOrden(pila1,pila3);
        System.out.println("Pila 3: " + pila3.toString());
        //prueba ejercicio c invertir pila
        pila1 = InvertirPila(pila1);
        System.out.println("Pila 1: " + pila1.toString());

        //prueba ejercicio d contar elementos, deberia dar 3
        System.out.println("Cantidad de elementos en pila 1: " + ContarElementos(pila1));
        
        //prueba ejercicio e sumar elementos, deberia dar 6
        System.out.println("Suma de elementos en pila 1: " + SumarElementos(pila1));

        //prueba ejercicio f promedio elementos, deberia dar 2
        System.out.println("Promedio de elementos en pila 1: " + PromedioElementos(pila1));
    }
}
