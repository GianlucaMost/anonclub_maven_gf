<%-- 
    Document   : detail
    Created on : 18.06.2016, 14:39:32
    Author     : gianlucamost
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Servlets.myServlet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" media="screen" title="no title" charset="utf-8">
        <title> anonclub </title>
    </head>
    <body>
        <jsp:useBean id="myMessage" class="logic.Message" scope="request"/>                         
        <nav>
            <a href="index.jsp">
              <img class="brand" src="logo.png" alt="Logo" />
            </a>
            <a href="vorstand.html"> Vorstand </a>
            <a href="new_message.html"> Neue Nachricht</a>
        </nav>

        <h1>
            <jsp:getProperty name="myMessage" property="headline" />
        </h1>
        <p>
            <jsp:getProperty name="myMessage" property="message" />
        </p>
        <p>
            <jsp:getProperty name="myMessage" property="date" />
            <jsp:getProperty name="myMessage" property="name" />
            <jsp:getProperty name="myMessage" property="surname" />
            <jsp:getProperty name="myMessage" property="mail" />
        </p>

        <footer>
          <a href="#"> Rechtliche Hinweise </a>
        </footer>
    </body>
</html>