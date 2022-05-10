package ui;

import model.data_structures.Edge;
import model.data_structures.Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Graph g;
    private static Scanner sc;


    public static void main(String[] args) {

        sc = new Scanner(System.in);
        graphSize();

        int option;

        do {
            option = printMenu();

            switch (option) {
                case 1:
                    addEdge();
                    break;
                case 2:
                    BFS();
                    break;

            }

        } while (option != 3 && option > 0);


    }

    private static int printMenu() {
        System.out.println("********************************************************\n" +
                "*              Grafo de numeros enteros                *\n" +
                "1. Agreagar conexiones" + "\n" +
                "2. Algoritmo de BFS" + "\n" +
                "3. Salir");

            try {
                return sc.nextInt();

            }catch (Exception e){
                System.out.println("*. El tamaño debe ser un numero entero");
                printMenu();
            }
        System.out.println("********************************************************\n" );
        return 0;
    }

    private static void addEdge() {
        System.out.println("*. Digite el nodo inicial: ");
        int init = sc.nextInt();
        System.out.println("*. Digite el nodo final: ");
        int end = sc.nextInt();
        System.out.println("1. Conexion A-B\n" + "2. Conexion circular  " );

        int option = sc.nextInt();

        switch (option) {
            case 1:
                g.addEdge(init, end);
                break;
            case 2:
                g.addEdge(init, end);
                g.addEdge(end, init);
                break;
        }

    }

    private static void graphSize() {
        System.out.println("*. Digite el tamaño del grafo: ");

        try {
            g = new Graph(sc.nextInt());

        }catch (Exception e){
            System.out.println("*. El tamaño debe ser un numero entero");
            graphSize();
        }


    }

    private static void BFS() {
        LinkedList<Edge>[] vertex = g.getAdj();
        boolean result = true;

        for(LinkedList<Edge> e : vertex){
            if (e.size() != 0 && g.BFS(e.getFirst().getS()).size() != g.getSize()){
                result = false;
                break;
            }else{
                System.out.println(g.BFS(e.getFirst().getS()).toString());
            }

        }

        if (result){
            System.out.println("*. Es un grafo fuertemente conexo");
        }else{
            System.out.println("*. No es un grafo fuertemente conexo");
        }

    }


}
