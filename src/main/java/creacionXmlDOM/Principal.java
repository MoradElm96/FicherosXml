/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creacionXmlDOM;

import java.io.File;
import java.util.ArrayList;
import javax.xml.crypto.dsig.TransformException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author alumnotd
 */
public class Principal {

    public static void main(String[] args) {

        File f = new File("alumnos.xml");
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        Alumno alumno1 = new Alumno(1, "Morad", 26);
        Alumno alumno2 = new Alumno(2, "Paul", 25);
        Alumno alumno3 = new Alumno(3, "Juanma", 20);
        Alumno alumno4 = new Alumno(4, "Andrew", 31);
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation dom = db.getDOMImplementation();
            //duda si importar con org o javax
            Document document = dom.createDocument(null, "xml", null);
            //se crea el primer nodo
            Element raiz = document.createElement("alumnos");
            document.getDocumentElement().appendChild(raiz);

            //creamos el arbol
            Element nodoAlumno, nodoDatos;
            Text texto;

            for (Alumno listaAlumno : listaAlumnos) {

                nodoAlumno = document.createElement("alumno");
                raiz.appendChild(nodoAlumno);

                nodoDatos = document.createElement("Id");
                nodoAlumno.appendChild(nodoDatos);
                texto = document.createTextNode(String.valueOf(listaAlumno.getId()));
                nodoDatos.appendChild(texto);

                nodoDatos = document.createElement("Nombre");
                nodoAlumno.appendChild(nodoDatos);
                texto = document.createTextNode(listaAlumno.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos = document.createElement("Edad");
                nodoAlumno.appendChild(nodoDatos);
                texto = document.createTextNode(String.valueOf(listaAlumno.getEdad()));
                nodoDatos.appendChild(texto);

                //objetos para escribir en el fichero
                Source source = new DOMSource(document);
                Result result = new StreamResult(f);

                try {
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty("indent", "yes");
                    //ver bien la linea de arriba
                    //escribimos en el fichero
                    transformer.transform(source, result);

                } catch (TransformerException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }

    }

}
