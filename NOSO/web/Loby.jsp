<%-- 
    Document   : Loby
    Created on : 7 abr. 2023, 09:18:41
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

        <%
            HttpSession ses=request.getSession();
            if(ses.getAttribute("s1")!=null){
            
            }else{
            response.sendRedirect("Login.jsp");
            }
            out.print("Bienvenido <a href=Loby.jsp?c=1>Cerrar</a>");
            if(request.getParameter("c")!=null){
            ses.invalidate();
            response.sendRedirect("Login.jsp");
            }

        %>
        <div class="row justify-content-around">
            <div class="card m-3"> 
                        <div class="card-body">
                            <p class="card-title fs-3"><a href="selfcoments.jsp">TUS COMENTARIOS</a></p>
                        </div>
                    </div>
        </div>
        
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-6 col-lg-10 col-xl-10">
                    <div class="card m-3"> 
                        <div class="card-body">
                            <p class="card-title fs-3"> NOMBRE DEL USUARIO</p>
                            <p class="card-text fs-6"> COMENTARIOS DEL USUARIO</p>
                        </div>
                    </div>
                    <div class="card m-3"> 
                        <div class="card-body">
                            <p class="card-title fs-3"> NOMBRE DEL USUARIO</p>
                            <p class="card-text fs-6"> COMENTARIOS DEL USUARIO</p>
                        </div>
                    </div>
                    <div class="card m-3"> 
                        <div class="card-body">
                            <p class="card-title fs-3"> NOMBRE DEL USUARIO</p>
                            <p class="card-text fs-6"> COMENTARIOS DEL USUARIO</p>
                        </div>
                    </div>
                </div>
                
            </div>
            
        </div>
    </body>
</html>
