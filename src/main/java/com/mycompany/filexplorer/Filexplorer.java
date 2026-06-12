/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filexplorer;

import com.mycompany.filexplorer.dominio.SistemaArchivos;
import com.mycompany.filexplorer.estructuras.LinkedListGeneric;
import com.mycompany.filexplorer.estructuras.QueueGeneric;
import com.mycompany.filexplorer.estructuras.StackGeneric;


/**
 *
 * @author jwd
 */
public class Filexplorer {

    public static void main(String[] args) {
        System.out.println("-- Probando estructuras lineales --");
        LinkedListGeneric<String> list = new LinkedListGeneric<>();
        list.add("uno"); list.add("dos"); list.add("tres");
        System.out.println("Lista: " + list.toString() + " tamaño=" + list.size());

        StackGeneric<Integer> stack = new StackGeneric<>();
        stack.push(1); stack.push(2); stack.push(3);
        System.out.println("Pila antes: " + stack.toString());
        System.out.println("pop: " + stack.pop());
        System.out.println("Pila después: " + stack.toString());

        QueueGeneric<String> queue = new QueueGeneric<>();
        queue.enqueue("a"); queue.enqueue("b"); queue.enqueue("c");
        System.out.println("Cola: " + queue.toString());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("Cola después: " + queue.toString());

        System.out.println("\n-- Probando árbol N-ario (Carpeta/Archivo) --");
        SistemaArchivos fs = new SistemaArchivos();
        fs.mkdir("docs"); fs.mkdir("imagenes"); fs.touch("readme", "txt", 5);
        System.out.println("Contenido root:\n" + fs.ls());
        fs.cd("docs"); fs.touch("doc1","pdf", 120); fs.touch("doc2","pdf", 80);
        fs.cd(".."); System.out.println("Contenido root after adding in docs:\n" + fs.ls());
    }
}
