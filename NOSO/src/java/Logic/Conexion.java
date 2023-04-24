/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import com.mysql.cj.protocol.Resultset;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author santi
 */

public class Conexion {
    Connection con;
     Statement st;
    Resultset rs;
   
       public Conexion() {
            try {
                String dbDriver = "com.mysql.jdbc.Driver";
                String dbURL = "jdbc:mysql://localhost:3306/";
                // Database name to access
                String dbName = "Users";
                String dbUsername = "root";
                String dbPassword = "n0m3l0";
                
                Class.forName(dbDriver).newInstance();
                con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
                System.out.println("se conecto");
            } catch (Exception e ) {
                System.err.println("Error"+e);
            }
        
        }
       public Connection getConnection(){
           return con;
       }
       
       public  static Connection iniciar() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "Users"; 
        String dbUsername = "root"; 
        String dbPassword = "n0m3l0"; 
  
        Class.forName(dbDriver).newInstance(); 
        Connection con = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword); 
        System.out.println("se conecto");
        return con; 
        }
       
       public int Login(String usuario,String contra) throws SQLException{
     
        int nivel=0;
        System.out.println("conectado 3");
        System.out.println(usuario);
        System.out.println(contra);
        try{
        String sql="select level from users where nameus='"+usuario+"'and password='"+contra+"'";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            System.out.println(rs);
        while(rs.next()){
            nivel=rs.getInt(1);
            System.out.println(nivel);
        }
            
        }catch(SQLException e){
            System.out.println("error"+e);
        }
        
        System.out.println(nivel);
        return nivel;
    }  
      public int Replogin(String nameus, String mail){
          int nivel=0;
        System.out.println("conectado 3");
        System.out.println(nameus);
        System.out.println(mail);
        try{
        String sql="select level from users where nameus='"+nameus+"'and mail='"+mail+"'";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            System.out.println(rs);
        while(rs.next()){
            nivel=rs.getInt(1);
            System.out.println(nivel);
        }
            
        }catch(SQLException e){
            System.out.println("error"+e);
        }
        
        System.out.println(nivel);
        return nivel;
      }
}
