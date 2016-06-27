/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import logic.Message;

/**
 *
 * @author gianlucamost
 */
public class ListManager {
    private static ListManager instance;
    private List<Message> messageList = new ArrayList<>();

    private ListManager() {}
    
    public static synchronized ListManager getInstance () {
    if (ListManager.instance == null) {
      ListManager.instance = new ListManager ();
    }
    return ListManager.instance;
  }

    public List<Message> getMessageList() {
        return this.messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
    
    public void addToList(Message m){
        this.messageList.add(m);
    }
}
