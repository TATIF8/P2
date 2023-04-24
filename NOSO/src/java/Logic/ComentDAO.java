/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class ComentDAO {
    
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Coment p=new Coment();
    Conexion cn= new Conexion();
    //Y coments, son los comentarios que han hecho en tu perfil
    //S coment, son los comentarios que tu has hecho
    //F coment, son los comentarios por fecha
    
    public List Ycoments(String username) {
   
        ArrayList<Coment> list= new ArrayList<>();
        String sql="select comentario, comentador, fecha from coments where comentado='"+username+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Coment com= new Coment();
                com.setComent(rs.getString("comentario"));
                com.setComentador(rs.getString("comentador"));
                com.setDate(rs.getString("fecha"));
                
                list.add(com);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    public List Scoments(String username, String date) {
   
        ArrayList<Coment> list= new ArrayList<>();
        String sql="select comentario, comentado, fecha from coments where comentador='"+username+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Coment com= new Coment();
                com.setComent(rs.getString("comentario"));
                com.setComentado(rs.getString("comentado"));
                com.setDate(rs.getString("fecha"));
                
                list.add(com);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }

    public List FScoments(String username,String date) {
   
        ArrayList<Coment> list= new ArrayList<>();
        String sql="select comentario, comentador, fecha from coments where comentado='"+username+"' and fecha='"+date+"'" ;
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Coment com= new Coment();
                com.setComent(rs.getString("comentario"));
                com.setComentador(rs.getString("comentador"));
                com.setDate(rs.getString("fecha"));
                
                list.add(com);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    public List FYcoments(String username,String date) {
   
        ArrayList<Coment> list= new ArrayList<>();
        String sql="select comentario, comentador, fecha from coments where comentado='"+username+"' and fecha='"+date+"'" ;
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Coment com= new Coment();
                com.setComent(rs.getString("comentario"));
                com.setComentado(rs.getString("comentado"));
                com.setDate(rs.getString("fecha"));
                
                list.add(com);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }


  public void Ec(String coment) {
    String sql = "delete from comentario where comentario ='"+coment+"';";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
    } catch (Exception e) {
        System.err.println("Error: " + e);
    }
    }
    public void Ac(String oldcoment, String newcoment) 
    {
        
        String sql = "update coments set comentario='" +newcoment+ "' where comentario='" +oldcoment+ "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    public boolean registrar(Coment c) {
        String sql="insert into coments(comentario,comentador,comentado,fecha)values('"+c.getComent()+"','"+c.getComentador()+"','"+c.getComentado()+"','"+c.getDate()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }

}

   
    
