<%-- 
    Document   : index
    Created on : 2 abr. 2023, 15:17:58
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
       
  <div class="position-absolute top-50 start-50 translate-middle">
      <form action="Servlog" method="POST" id="LOG" class="position-absolute top-50 start-50 translate-middle">
              <label for="nombre">Nombre:</label>
              <input type="text" id="name" name="name" required="" pattern="^[a-zA-Z]{8,20}$">

              <label for="apellidos">Apellidos:</label>
              <input type="text" id="app" name="app" required="" pattern="^[a-zA-Z\s]{8,30}$">

              <label for="username">Nombre de usuario:</label>
              <input type="text" id="nameus" name="nameus" required="" pattern="^[a-zA-Z]{8,20}$">

              <label for="password">Contraseña:</label>
              <input type="password" id="password" name="password" required="" pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%\^&\*\(\)]).{8,19}$">

              <label for="email">Correo electrónico:</label>
              <input type="email" id="mail" name="mail" required="" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,40}$">

              <div class="boton-container">
                <input class="boton-container" type="submit" value="Registrarse">
              </div>
            </form>
      
</div>
        </div>
<script> 
 window.addEventListener('load', function() {
  var formulario = document.getElementById("LOG");

  formulario.addEventListener('submit', function(evento) {
    evento.preventDefault();
    var nombre = document.getElementById("name").value;
    var correo = document.getElementById("mail").value;
    var nameus = document.getElementById("nameus").value;
    var appellidos=document.getElementById("app").value;
    var pass = document.getElementById("password").value;
const nameRegex = /^[a-zA-Z]{8,20}$/;
  if (!nameRegex.test(nombre)) {
    alert('Por favor, introduce un nombre valido (Nombre)');
    document.getElementById("name").focus();
    return;
  }
  if (!nameRegex.test(nameus)) {
    alert('Por favor, introduce un nombre de usuario valido (MAX:20 digitos)');
    document.getElementById("nameus").focus();
    return;
  }
const passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%\^&\*\(\)]).{8,19}$/;
  if (!passwordRegex.test(pass)) {
    alert('Por favor, introduce una contraseña válida (8 caracteres, al menos una letra mayuscula y una minuscula, un numero y algun simbolo !@#$%^&*)');
    document.getElementById("password").focus();
    return;
  }

  // Validación de los apellidos
  const appellidosRegex = /^[a-zA-Z\s]{8,30}$/;
  if (!appellidosRegex.test(appellidos)) {
    alert('Por favor, introduce apellidos (30 dígitos)');
    document.getElementById("app").focus();
    return;
  }

  // Validación del correo
  const correoRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,40}$/;
  if (!correoRegex.test(correo)) {
    alert('Por favor, introduce un correo electrónico válido');
    document.getElementById("mail").focus();
    return;
  }
  
  // Si todos los campos son válidos, se envía el formulario
  formulario.submit();
  alert('Formulario enviado correctamente');
  });
});
</script> 
    </body>
    
</html>
