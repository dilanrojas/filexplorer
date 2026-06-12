package com.mycompany.filexplorer.dominio;

public class SistemaArchivos {
    private Carpeta root;
    private Carpeta current;

    public SistemaArchivos() {
        root = new Carpeta("raiz");
        current = root;
    }

    public Carpeta getRoot() { return root; }
    public Carpeta getCurrent() { return current; }

    public boolean mkdir(String name) {
        if (current.findChild(name) != null) return false;
        Carpeta c = new Carpeta(name);
        current.addChild(c);
        return true;
    }

    public boolean touch(String name, String ext, int tamKB) {
        if (current.findChild(name) != null) return false;
        Archivo a = new Archivo(name, ext, tamKB, "contenido_simulado");
        current.addChild(a);
        return true;
    }

    public boolean cd(String name) {
        if ("..".equals(name)) {
            if (current.getParent() != null) { current = current.getParent(); return true; }
            else return false;
        }
        NodoFS found = current.findChild(name);
        if (found != null && found instanceof Carpeta) { current = (Carpeta) found; return true; }
        return false;
    }

    public String ls() { return current.listChildren(); }
}
