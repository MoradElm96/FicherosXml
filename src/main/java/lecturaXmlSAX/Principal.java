/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecturaXmlSAX;

import creacionXmlDOM.Alumno;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author alumnotd
 */
public class Principal {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();

            Manejador m = new Manejador();
            File f = new File("alumnos.xml");
           
            sp.parse(f, m);

            ArrayList<Alumno> lista = m.obtnerLista();
            
            for (Alumno alumno : lista) {
                
                System.out.println(alumno.toString());
            }
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException p) {
            System.out.println(p.getMessage());
        } catch (SAXException s) {
            System.out.println(s.getMessage());
        }
    }

}
