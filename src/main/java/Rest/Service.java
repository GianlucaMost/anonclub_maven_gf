/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import logic.Shoutbox;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author gianlucamost
 */
/**
 *
 * @author gianlucamost
 */

@Path("shoutbox")
public class Service {
    private List<Shoutbox> sbList = new LinkedList<Shoutbox>();
    
    @GET
    public String getShoutBoxList() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(sbList);
    }
    
    @PUT
    public void setShoutBox(@QueryParam("datum") String datum, @QueryParam("name") String name, @QueryParam("nachricht") String nachricht) {
        Shoutbox sb = new Shoutbox();
        sb.setDate(datum);
        sb.setName(name);
        sb.setNachricht(nachricht);
        sbList.add(sb);
        System.out.println(nachricht + name + datum);
    }
    
}
