/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.persistence.ElementCollection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gianlucamost
 */
@XmlRootElement
public class Shoutbox {
    private String date, name, message;

    public Shoutbox() {}

    public Shoutbox(String date, String name, String message) {
        this.date = date;
        this.name = name;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setNachricht(String message) {
        this.message = message;
    }
}
