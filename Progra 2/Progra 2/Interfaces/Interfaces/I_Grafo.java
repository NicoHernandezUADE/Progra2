package Interfaces;

import Logica.Conjunto;

public interface I_Grafo {
    void InicializarGrafo () ;

    void AgregarVertice( int v);

    void EliminarVertice( int v);

    Conjunto Vertices();

    void AgregarArista( int v1, int v2, int peso);

    void EliminarArista( int v1, int v2);

    boolean ExisteArista( int v1, int v2);

    int PesoArista( int v1, int v2);
}
