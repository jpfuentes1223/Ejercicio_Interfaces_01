
package ejercicio1_interfaces;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerarLibros {

    String type = "";
    String filename = "libros";
    String titulo_libro = "";
    String autor_libro = "";
    String categoria_libro = "";
    
    ArrayList<String[]> libros = new ArrayList<>();
    public void generarArchivo(){
        switch (type) {
            case ".xml":
                generarArchivoXML();
                break;
            case ".txt":
                generarArchivoTxt();
                break;
            default:
                System.out.println("Error en tipo de archivo");
                break;
        }
    }
    public void generarArchivoXML(){
        try {
            FileWriter fw = new FileWriter(filename+type);
            fw.write(generarTextoXML());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GenerarLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String generarTextoXML(){
        String texto = "<Libros>";
            texto += generarLibroXML();
        texto += "</Libros>";
        return texto;
    }
    
    public String generarLibroXML(){
        return "<Libro>"
                + "<Titulo>"+this.titulo_libro+"</Titulo>"
                + "<Autor>"+this.autor_libro+"</Autor>"
                + "<Categoria>"+this.categoria_libro+"</Categoria>"
             + "</Libro>";
    }
    
    public void generarArchivoTxt(){
        try {
            FileWriter fw = new FileWriter(filename+type);
            fw.write(generarTextoTxt(1));
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GenerarLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String generarTextoTxt(int num_libros){
        String texto = "Lista de libros: \n";
        texto+= generarLibroTxt();
        return texto;
    }
    public String generarLibroTxt(){
        return "Titulo del libro: "+this.titulo_libro+"\n"
                + "Autor del libro: "+this.autor_libro+"\n"
                + "Categoria del libro: "+this.categoria_libro+"\n";
    }
    
}
