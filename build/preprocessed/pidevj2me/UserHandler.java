/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author maroo
 */
public class UserHandler extends  DefaultHandler{
    private Vector personnes;
    String idTag = "close";
    String nomTag = "close";
    String prenTag = "close";

    public UserHandler() {
        personnes = new Vector();
    }

    public User[] getUser() {
        User[] personness = new User[personnes.size()];
        personnes.copyInto(personness);
        return personness;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private User currentPersonne;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            currentPersonne = new User();
            //2ème methode pour parser les attributs
            currentPersonne.setId(Integer.parseInt(attributes.getValue("id")));
            currentPersonne.setUsername(attributes.getValue("username"));
            currentPersonne.setEmail(attributes.getValue("email"));
            currentPersonne.setBonus(Integer.parseInt(attributes.getValue("bonus")));
            currentPersonne.setImage(attributes.getValue("photo"));
            /****/
            
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("username")) {
            nomTag = "open";
        } else if (qName.equals("email")) {
            prenTag = "open";
        
        } else if (qName.equals("bonus")) {
            prenTag = "open";
        
        } else if (qName.equals("photo")) {
            prenTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("user")) {
            // we are no longer processing a <reg.../> tag
            personnes.addElement(currentPersonne);
            currentPersonne = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("username")) {
            nomTag = "close";
        } else if (qName.equals("email")) {
            prenTag = "close";
        
        } else if (qName.equals("bonus")) {
            prenTag = "close";
        
        } else if (qName.equals("photo")) {
            prenTag = "close";
        }
    } {
    
}}
