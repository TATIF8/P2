<%-- 
    Document   : Signin
    Created on : 7 abr. 2023, 10:36:53
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <link rel="stylesheet" href="bootstrap.min.css" />
    <style>.bg{background-image: url(Dull.jpg);font-family: 'Cascadia Code', monospace;}</style>
    </head>
    <body class="bg">
        <div class="container">
        
  <div class=" position-absolute top-50 start-50 translate-middle bg-opacity-50">
      <form action="Signserv" method="POST" id="LOG">
          <div class="form-label fs-2">
              <label for="username">Nombre de usuarios</label>
          </div>
          <div class="input-group bg-opacity-25 ">
                <input type="text" id="nameus" name="nameus" required="" >
          </div>
          <div class="form-label fs-2">
              <label for="password">Contraseña:</label>
          </div> 
          <div class="input-group bg-opacity-25">
                        <input type="password" id="password" name="password" required="">
          </div>

              <div class="btn-group">
                <input type="submit" value="Enviar">
              </div>
            </form>
      <% if(request.getAttribute("u")!=null){
            if(request.getAttribute("u")=="a"){
            HttpSession ses=request.getSession();
            ses.setAttribute("s1", request.getAttribute("log"));
            response.sendRedirect("Loby.jsp");
            }else{
            out.println("Usuario y contraseña no coinciden");
            }
          }
      %>
</div>
        </div>

    </body>
</html>
