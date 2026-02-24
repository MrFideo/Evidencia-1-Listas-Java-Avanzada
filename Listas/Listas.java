package Listas;

public class Listas {
    private static final class Elemento {
       String valor;
       Elemento sig;
       Elemento ant;


       Elemento(String valor) {
           this.valor = valor;
       }
   }
  
   private static final class ListaDoble {
       private Elemento inicio;
       private Elemento fin;


       public boolean estaVacia() {
           return inicio == null;
       }

       public void agregarAlFinal(String texto) {
        Elemento nuevo = new Elemento(texto);

        if(estaVacia()) {
            inicio = fin = nuevo;
            return;
        }

        fin.sig = nuevo;
        nuevo.ant = fin;
        fin = nuevo;
       }

       public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista Vacia");
            return;
        }

        Elemento cursor = inicio;
        while (cursor != null) {
            System.out.println(cursor.valor + " -> ");
            cursor = cursor.sig;
        }
        System.out.println("null");
       }

       public void mostrarInversa() {
        if (estaVacia()) {
            System.out.println("Lista Vacia");
            return;
        }

        Elemento cursor = fin;
        while (cursor != null) {
            System.out.println(cursor.valor + " <-> ");
            cursor = cursor.ant;
        }
        System.out.println("Null");
       }

       public boolean eliminarPorValor(String objetivo) {
        if (estaVacia()) {
            System.out.println("Lista Vacia");
            return false;
        }

        Elemento cursor = inicio;
        while (cursor != null && !cursor.valor.equals(objetivo)) {
            cursor = cursor.sig;
        }

        if (cursor == null) return false;

        if (cursor == inicio && cursor == fin) {
            inicio = fin = null;
            return true;
        }

        if (cursor == inicio) {
            inicio = inicio.sig;
            inicio.ant = null;
            return true;
        }

        if (cursor == fin) {
            fin = fin.ant;
            fin.sig = null;
            return true;
        }

        cursor.ant.sig = cursor.sig;
        cursor.sig.ant = cursor.ant;
        return true;
       }
   }

   public static void main(String[] args) {
       ListaDoble lista = new ListaDoble();

       lista.agregarAlFinal("Escribir");
       lista.agregarAlFinal("Borrar");
       lista.agregarAlFinal("Copiar");
       lista.agregarAlFinal("Pegar");

       lista.mostrar();
       lista.eliminarPorValor("Copiar");
       lista.mostrar();
   }

}
