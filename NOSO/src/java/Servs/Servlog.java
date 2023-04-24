/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servs;

import Logic.Conexion;
import Logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author santi
 */
public class Servlog extends HttpServlet {
Usuario us=new Usuario();
private java.sql.Statement st;
Conexion co=new Conexion();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();
            try {
            String name=request.getParameter("name");
            String mail= request.getParameter("mail");
            String nameus= request.getParameter("nameus");
            String password= request.getParameter("password");
            String apellidos=request.getParameter("app");
             if(co.Replogin(nameus,mail)==1 || co.Replogin(nameus,mail )==2){
                 
                }else{
                    System.out.println(name);
                System.out.println(mail);
                System.out.println(password);
                System.out.println(nameus);
                System.out.println(apellidos);
            if(us.valmail(mail)==false || us.valname(name)==false|| us.valapellidos(apellidos)==false ||us.valpass(password)==false||us.valnameus(nameus)==false){
                System.out.println(us.valmail(mail));         
                System.out.println(us.valname(name));
                System.out.println(us.valpass(password));
                System.out.println(us.valapellidos(apellidos));
                System.out.println(us.valnameus(nameus));
                response.sendRedirect("ERROR.jsp");

            }else{ 
               try (Connection con =Conexion.iniciar()) {
               
               st=con.createStatement();
               st.executeUpdate("INSERT INTO users(`name`,`apellidos`,`nameus`,`mail`,`password`,`level`) values('"+name+"','"+apellidos+"','"+nameus+"','"+mail+"','"+password+"','1')");
               System.out.println("se conecto");
               
           } catch (ClassNotFoundException ex) {
                Logger.getLogger(SERV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SERV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(SERV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SERV.class.getName()).log(Level.SEVERE, null, ex);
            }
            st.close();
            response.sendRedirect("Loby.jsp");
            
            }
                    
            
            
            System.out.println("Se registro"); 
                }
                 
        } catch (SQLException ex) {
            Logger.getLogger(SERV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
