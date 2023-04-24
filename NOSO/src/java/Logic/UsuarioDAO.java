/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class UsuarioDAO {
    
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Usuario p=new Usuario();
    Conexion cn= new Conexion();
    
   
    
    public List consultar() {
   
        ArrayList<Usuario> list= new ArrayList<>();
        String sql="select * from users";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Usuario us= new Usuario();
                us.setName(rs.getString("nombre"));
                us.setApellidos(rs.getNString("apellidos"));
                us.setNameus(rs.getNString("nameus"));
                us.setPassword(rs.getNString("password"));
                us.setMail(rs.getNString("mail"));
                list.add(us);
                System.out.println("Id");
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }

    
    public Usuario list(String nameus) {
        
        String sql="select * from persona where nameus="+nameus;
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                p.setName(rs.getNString("name"));
                p.setApellidos(rs.getNString("apellidos"));
                p.setMail(rs.getNString("mail"));
                p.setNameus(rs.getNString("nameus"));
                p.setPassword(rs.getNString("password"));
            }
                       
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
            
        return p;         
    }
    

    public boolean registrar(Usuario us) {
        String sql="insert into users(name,apellidos,nameus,mail,password)values('"+us.getName()+"','"+us.getApellidos()+"','"+us.getMail()+"','"+us.getPassword()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }

    public boolean editar(Usuario us) {
    String sql="update persona set name='"+us.getName()+"',and apellidos='"+us.getApellidos()+"',and nameus='"+us.getNameus()+"', and mail='"+us.getMail()+"', and password='"+us.getPassword()+"' where name='"+us.getName()+"'and apellidos='"+us.getApellidos()+"'and nameus='"+us.getNameus()+"' and mail='"+us.getMail()+"'and password='"+us.getPassword()+"'";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
            
 
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
                }

    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
