/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecturaXmlDOM;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

        File f = new File("alumnos.xml");
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(f);
//importar con org
            NodeList alumnos = document.getElementsByTagName("alumno");
            Node nodoAlumno;
            Element nodoDatos;
            
            for (int i = 0; i < alumnos.getLength(); i++) {
                nodoAlumno = alumnos.item(i);
                nodoDatos =(Element) nodoAlumno;
                //imprimir los valores
                System.out.println("Id: "+ nodoDatos.getElementsByTagName("Id").item(0).getTextContent());
                System.out.println("Nombre: "+ nodoDatos.getElementsByTagName("Nombre").item(0).getTextContent());
                System.out.println("Edad: "+ nodoDatos.getElementsByTagName("Edad").item(0).getTextContent());
            }
            
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException s) {
            System.out.println(s.getMessage());
        }catch (IOException io) {
            System.out.println(io.getMessage());
        } 
    }
}