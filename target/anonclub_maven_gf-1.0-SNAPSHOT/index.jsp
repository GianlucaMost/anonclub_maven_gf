<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,Servlets.myServlet,logic.Message,logic.ListManager" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" media="screen" title="no title" charset="utf-8">
        <title> anonclub </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script>			
            function countChars(){
                var msg = document.getElementById("message");
                var remaining = document.getElementById("remaining");
                var maxLength = 240;
                if(msg.value.length < maxLength) {
                    remaining.innerHTML = (maxLength-msg.value.length);
                    $("#message").css({borderColor:""});
                }else {
                    remaining.innerHTML = (maxLength-msg.value.length);
                    $("#message").css({borderColor:"red"});
                    alert("Maximale Anzahl an Zeichen wurde erreicht!");
                }
            }
            
            $( document ).ready(function(){		
                $("#senden").click(function(){
                    var datum = new Date();
                    $.ajax({
                        type: "PUT",
                        url: "resources/shoutbox?"
                            + "datum=" + datum.getDate() +"."+ datum.getMonth() +"."+ datum.getFullYear() +" "+ datum.getHours() +":"+ datum.getMinutes() +":"+ datum.getSeconds()
                            + "&name=" + $("#autor").val()
                            + "&nachricht=" + $("#message").val()
                    })		
                });

                var j=0;
                function anzeigen(){
                    $.getJSON("resources/shoutbox", function(array){
                        if(j<array.length){  
                            for(var i=j; i<array.length; i++){
                                var $neuesElement = $("<li>"); 
                                $neuesElement.html("<b>"+ array[i].date +" schrieb "+ array[i].name + "</b><br>" +array[i].message);
                                $("#liste").append($neuesElement);
                                $neuesElement.fadeIn();
                                j++;
                            }
                        }
                    })
                } 

                $("#aktualisieren").click(function(){
                    setInterval(anzeigen, 3000);
                });
            });
        </script>
    </head>
    <body>
        <nav>
          <a href="index.jsp" title="home">
            <img class="brand" src="logo.png" alt="Logo" />
          </a>
          <a href="vorstand.html"> Vorstand </a>
          <a href="new_message.html"> Neue Nachricht</a>
        </nav>
        
        <!-- CONTENT -->
        
        <h1>Vereinsnachrichten</h1>
        <table border="1">
            <thead>
                <tr>
                  <td>Ueberschrift</td>
                  <td>Datum</td>
                </tr>
            </thead>
            <tbody>
                <%int i=0; for(Message msg : ListManager.getInstance().getMessageList()){%>
                  <tr>
                      <td>
                          <a href="myServlet?lesen=<%=i++%>">
                              <%=msg.getHeadline()%> 
                          </a>
                      </td>
                      <td>
                          <%=msg.getDate()%>
                      </td>
                  </tr>
                <%}%>   
            </tbody>
        </table>
            
        <div id="shoutbox">
            <h2>Shoutbox</h2>
            <ul id="liste">
                <li>Welcome!</li>
            </ul>
            <br>
            <label>Autor:</label> 
            <input class="form-control" type="text" id="autor">
            <br>
            <label for="Message">Nachricht: </label>
            <br>
            <textarea name="Message" rows="8" cols="40" id="message" onkeyup="countChars()" autofocus required></textarea>
            <br>
            <span id="remaining"> 240</span>/240 Zeichen übrig.
            <button type="button" id="senden">
                senden
            </button>
            <button id="aktualisieren">
                aktualisieren
            </button>
        </div>
        <footer>
          <a href="#"> Rechtliche Hinweise </a>
        </footer>
    </body>
</html>
