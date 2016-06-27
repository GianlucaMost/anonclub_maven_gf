/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;

/**
 *
 * @author gianlucamost
 */
public class Message implements Serializable{
    private String name, surname, mail, date, category, headline, message;
    
    public Message() {}
    public Message(String name, String surname, String mail, String date, String category, String headline, String message) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.date = date;
        this.category = category;
        this.headline = headline;
        this.message = message;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return 
                this.name + " // " +
                this.surname +  " // " +
                this.mail +  " // " +
                this.date +  " // " +
                this.category +  " // " +
                this.headline +  " // " +
                this.message;
    }
}
