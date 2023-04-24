/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santi
 */
public class Usuario {
    private String name;
    private String mail;
    private String password;
    private String apellidos;
    private String nameus;
    Pattern passRegex= Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*\\(\\)]).{8,19}$");
    Pattern nameRegex= Pattern.compile("^[a-zA-Z]{8,20}$");
    Pattern apellidosRegex= Pattern.compile("^[a-zA-Z\\s]{8,30}$");
    Pattern correoRegex= Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,40}$");

    public Usuario(String name,String apellidos,String nameus, String mail,String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.apellidos=apellidos;
        this.nameus=nameus;
     
        
    }
    public Usuario(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNameus() {
        return nameus;
    }

    public void setNameus(String nameus) {
        this.nameus = nameus;
    }

    public Pattern getNameRegex() {
        return nameRegex;
    }

    public void setNameRegex(Pattern nameRegex) {
        this.nameRegex = nameRegex;
    }

    
     public boolean valname(String nombre){
        Matcher n= nameRegex.matcher(nombre);
        return n.find();

        
    }
    public boolean valnameus(String nameus){
        Matcher n= nameRegex.matcher(nameus);
        return n.find();

        
    }
    public boolean valapellidos(String apellidos){
        Matcher a = apellidosRegex.matcher(apellidos);
        return a.find();
    }
   
   
      public boolean valmail(String correo){
        Matcher c =correoRegex.matcher(correo);
        return c.find();


        
    }
      public boolean valpass(String password){
          Matcher p= passRegex.matcher(password);
          return p.find();

      }
   
}
