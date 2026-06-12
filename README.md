**Resumen del Avance 1**

- **Restricciones cumplidas:** 
  - Todas las estructuras se implementaron desde cero usando nodos enlazados.
  - Se utilizaron genéricos `<T>` en todas las estructuras para reutilización y seguridad de tipos.
- **Estructuras implementadas y probadas de forma aislada:**
  1. **Lista Enlazada Genérica** (`LinkedListGeneric<T>`)
  2. **Pila Genérica** (`StackGeneric<T>`)
  3. **Cola Genérica** (`QueueGeneric<T>`)
  4. **Árbol N-ario** (nodos `Carpeta` y `Archivo`)

**Responsabilidades por Paquete y Métodos Solicitados**
- **`estructuras` :** Implementaciones genéricas de estructuras lineales con nodos enlazados propios
  
  - **[src/estructuras/LinkedListGeneric.java](src/estructuras/LinkedListGeneric.java) — Lista Enlazada Genérica**
    - `add(T data)` — Añade un elemento al final de la lista.
    - `remove(T data)` — Elimina el primer elemento que coincida con el dato proporcionado.
    - `get(int index)` — Retorna el elemento en el índice especificado.
    - `size()` — Retorna la cantidad de elementos en la lista.
    - `isEmpty()` — Verifica si la lista está vacía.
    - `toString()` — Retorna representación en cadena de todos los elementos.
  
  - **[src/estructuras/StackGeneric.java](src/estructuras/StackGeneric.java) — Pila Genérica (LIFO: Último en entrar, primero en salir)**
    - `push(T data)` — Inserta un elemento al tope de la pila.
    - `pop()` — Retira y retorna el elemento del tope de la pila.
    - `peek()` — Retorna el elemento del tope sin retirarlo.
    - `isEmpty()` — Verifica si la pila está vacía.
    - `size()` — Retorna la cantidad de elementos en la pila.
    - `toString()` — Retorna representación en cadena desde el tope.
  
  - **[src/estructuras/QueueGeneric.java](src/estructuras/QueueGeneric.java) — Cola Genérica (FIFO: Primero en entrar, primero en salir)**
    - `enqueue(T data)` — Añade un elemento al final de la cola.
    - `dequeue()` — Retira y retorna el elemento del inicio de la cola.
    - `peek()` — Retorna el elemento del inicio sin retirarlo.
    - `isEmpty()` — Verifica si la cola está vacía.
    - `size()` — Retorna la cantidad de elementos en la cola.
    - `toString()` — Retorna representación en cadena desde el inicio.
  
  - **Nodos separados (implementación package-private):**
    - [src/estructuras/ListNode.java](src/estructuras/ListNode.java) — Nodo genérico para LinkedListGeneric.
    - [src/estructuras/StackNode.java](src/estructuras/StackNode.java) — Nodo genérico para StackGeneric.
    - [src/estructuras/QueueNode.java](src/estructuras/QueueNode.java) — Nodo genérico para QueueGeneric.

- **`dominio` :** Árbol N-ario que modela estructura de archivos usando LinkedListGeneric para hijos
  
  - **[src/dominio/NodoFS.java](src/dominio/NodoFS.java) — Clase abstracta base**
    - Define estructura común: `nombre`, `fechaCreacion`, referencia a `parent` (Carpeta padre).
    - Métodos: `getNombre()`, `getParent()`, `setParent(Carpeta)`, `toString()`.
  
  - **[src/dominio/Carpeta.java](src/dominio/Carpeta.java) — Nodo interno del árbol**
    - Mantiene `LinkedListGeneric<NodoFS> hijos` para almacenar subcarpetas y archivos.
    - `addChild(NodoFS)` — Añade un hijo (carpeta o archivo) a esta carpeta.
    - `removeChild(String name)` — Elimina un hijo por nombre.
    - `findChild(String name)` — Busca un hijo por nombre.
    - `listChildren()` — Retorna descripción de hijos (separa carpetas de archivos).
  
  - **[src/dominio/Archivo.java](src/dominio/Archivo.java) — Hoja del árbol**
    - Metadatos: `extension`, `sizeInKB` (tamaño), `contenido` (simulado).
    - Métodos: `getExtension()`, `getTamKB()`, `getContenido()`, `toString()`.
  
  - **[src/dominio/SistemaArchivos.java](src/dominio/SistemaArchivos.java) — Gestor raíz del árbol**
    - Mantiene referencia a `root` (raíz del árbol).
    - `mkdir(String name)` — Crea una subcarpeta en el directorio actual.
    - `touch(String name, String ext, int tamKB)` — Crea un archivo en el directorio actual.
    - `cd(String name)` — Navega a una subcarpeta o `.` al padre.
    - `ls()` — Lista contenido del directorio actual.

- **Raíz / Ejecutable de Prueba**
  - [src/Main.java](src/Main.java) — Programa de consola pequeño que prueba de forma aislada las estructuras y la creación/navegación básica en el árbol.

**Cumplimiento de Requisitos del Avance 1**
✓ **Estructuras lineales probadas de forma aislada:**
  - LinkedListGeneric: Prueba de `add`, `remove`, `get`, visualización con `toString`.
  - StackGeneric: Prueba de `push`, `pop`, `peek`, demostración LIFO.
  - QueueGeneric: Prueba de `enqueue`, `dequeue`, `peek`, demostración FIFO.

✓ **Árbol N-ario implementado:**
  - Carpeta como nodo interno con lista enlazada de hijos.
  - Archivo como nodo hoja.
  - Navegación básica (crear carpetas, crear archivos, cambiar directorio).

✓ **Restricción java.util cumplida:**
  - Cero uso de ArrayList, LinkedList, Stack, Queue o TreeSet.
  - Todas las implementaciones desde cero con nodos enlazados.

✓ **Genéricos utilizados:**
  - LinkedListGeneric<T>, StackGeneric<T>, QueueGeneric<T> con parámetro de tipo.
  - ListNode<T>, StackNode<T>, QueueNode<T> como nodos genéricos.

✓ **Buena práctica de encapsulación:**
  - Nodos (ListNode, StackNode, QueueNode) son package-private.
  - Variables renombradas a descriptivos (`newNode`, `currentNode`, `dataToReturn`, etc.).

**Cómo ejecutar las pruebas del Avance 1**
1. Compilar:

```bash
javac -d bin src/estructuras/*.java src/dominio/*.java src/Main.java
```

2. Ejecutar:

```bash
java -cp bin Main
```

La salida mostrará pruebas de `LinkedListGeneric`, `StackGeneric`, `QueueGeneric` y una pequeña demostración de `SistemaArchivos` (creación de carpetas y archivos, `ls`, `cd ..`).

**Qué se entregó para este Avance (entregable puntual)**
- Código fuente de las estructuras genéricas y del árbol N-ario (paquetes `estructuras` y `dominio`).
- `Main` de pruebas que demuestra la funcionalidad de forma aislada.
- Breve verificación local: compilación y ejecución exitosa en entorno Linux.

**Siguientes pasos recomendados**
- Implementar el menú interactivo por consola (Avance 2): exponer los comandos `mkdir`, `touch`, `ls`, `cd`, `rm`, `rmdir`.
- Añadir pruebas unitarias y un escenario con ≥30 nodos para el análisis empírico (rúbrica).

Fin del README del Avance 1.
