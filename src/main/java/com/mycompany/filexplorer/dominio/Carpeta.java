package com.mycompany.filexplorer.dominio;

import com.mycompany.filexplorer.estructuras.LinkedListGeneric;

public class Carpeta extends NodoFS {
    private LinkedListGeneric<NodoFS> hijos = new LinkedListGeneric<>();

    public Carpeta(String nombre) { super(nombre); }

    public void addChild(NodoFS n) {
        n.setParent(this);
        hijos.add(n);
    }

    public boolean removeChild(String name) {
        for (int i = 0; i < hijos.size(); i++) {
            NodoFS c = hijos.get(i);
            if (c != null && c.getNombre().equals(name)) {
                hijos.remove(c);
                return true;
            }
        }
        return false;
    }

    public NodoFS findChild(String name) {
        for (int i = 0; i < hijos.size(); i++) {
            NodoFS c = hijos.get(i);
            if (c != null && c.getNombre().equals(name)) return c;
        }
        return null;
    }

    public String listChildren() {
        StringBuilder folders = new StringBuilder();
        StringBuilder files = new StringBuilder();
        for (int i = 0; i < hijos.size(); i++) {
            NodoFS c = hijos.get(i);
            if (c instanceof Carpeta) {
                if (folders.length() > 0) folders.append(", ");
                folders.append(c.getNombre());
            } else {
                if (files.length() > 0) files.append(", ");
                files.append(c.toString());
            }
        }
        StringBuilder out = new StringBuilder();
        out.append("Carpetas: "); out.append(folders.length() > 0 ? folders.toString() : "-");
        out.append("\nArchivos: "); out.append(files.length() > 0 ? files.toString() : "-");
        return out.toString();
    }

    @Override
    public String toString() { return nombre + "/"; }
}
