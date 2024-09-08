package GuiaEjs;
import Logica.*;
import Logica.ListaEnlazadaPrioridad.Nodo;
public class EjerciciosColaPrioridad {
    // ej 6) a-
    public static ListaEnlazadaPrioridad CombinarDosColas(ListaEnlazadaPrioridad c1, ListaEnlazadaPrioridad c2){
        Nodo movil1 = c1.primero;
        Nodo movil2 = c2.primero;
        ListaEnlazadaPrioridad res = new ListaEnlazadaPrioridad();

        while (movil1 != null && movil2 != null) {
            if (movil1.prioridad >= movil2.prioridad) {
                res.Agregar(movil1.contenido, movil1.prioridad);
                movil1 = movil1.siguiente;
            }
            else{
                res.Agregar(movil2.contenido, movil2.prioridad);
                movil2 = movil2.siguiente;
            }
        }

            // Agregar los elementos restantes de c1, si los hay
        while (movil1 != null) {
            res.Agregar(movil1.contenido, movil1.prioridad);
            movil1 = movil1.siguiente;
        }

        // Agregar los elementos restantes de c2, si los hay
        while (movil2 != null) {
            res.Agregar(movil2.contenido, movil2.prioridad);
            movil2 = movil2.siguiente;
        }
        return res;
    }

    // ej 6) b-
    public static boolean SonIguales(ListaEnlazadaPrioridad c1, ListaEnlazadaPrioridad c2){
        if (c1.largo != c2.largo) {
            return false;
        }
        Nodo movil1 = c1.primero;
        Nodo movil2 = c2.primero;
        while (movil1 != null){
            if(movil1.prioridad != movil2.prioridad){
                return false;
            }
            movil1 = movil1.siguiente;
            movil2 = movil2.siguiente;
        }
        return true;
    }
    public static void main(String[] args) {
        ListaEnlazadaPrioridad c1 = new ListaEnlazadaPrioridad();
        c1.Agregar(11, 1);
        c1.Agregar(20, 2);
        c1.Agregar(30, 6);
        c1.Agregar(40, 2);
        c1.Agregar(50, 3);

        ListaEnlazadaPrioridad c2 = new ListaEnlazadaPrioridad();
        c2.Agregar(70, 3);
        c2.Agregar(80, 5);
        c2.Agregar(90, 2);
        c2.Agregar(100, 1);
        System.out.println("Cola 1: " + c1.toString());
        System.out.println("Cola 2: " + c2.toString());
        ListaEnlazadaPrioridad res = CombinarDosColas(c1, c2);
        System.out.println("Cola resultante: " + res.toString());

        //test ej 6)b
        System.out.println("Son iguales? " + SonIguales(c1, c2)); // expected: false
        c2.vaciar();
        c2.Agregar(11, 1);
        c2.Agregar(20, 2);
        c2.Agregar(30, 6);
        c2.Agregar(40, 2);
        c2.Agregar(50, 3);
        System.out.println("Son iguales? " + SonIguales(c1, c2)); // expected: true
    }
}
