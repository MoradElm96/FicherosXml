/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecturaXmlSAX;

import creacionXmlDOM.Alumno;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author alumnotd
 */
public class Manejador extends DefaultHandler {

    ArrayList<Alumno> listaAlumnos = new ArrayList();
    Alumno alumno;

    StringBuilder sb = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch(qName){
            
            case"Id":
                alumno.setId(Integer.parseInt(sb.toString()));
                
                break;
            case "Nombre":
                alumno.setNombre(sb.toString());
                break;
            case "Edad":
                alumno.setEdad(Integer.parseInt(sb.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "Alumno":
                alumno = new Alumno();
                listaAlumnos.add(alumno);
                //si queremos poner el id
                //alumno.setId(attributes.getValue("id");
                
                break;
                
            case "Id":
                
            case "Nombre":
                
                
                
                
            case "Edad":
                
                //en el ultimo borramos
                sb.delete(0, sb.length());
                break;
        }
    }
    
    //metodo que devuelve el arrayList
    
    public ArrayList<Alumno> obtnerLista(){
        return listaAlumnos;
    }

}
