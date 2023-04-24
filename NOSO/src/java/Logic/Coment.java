/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author santi
 */
public class Coment {
    
    private String coment;
    private String comentado;
    private String comentador;
    private String date;

    public Coment(String coment, String comentado, String comentador, String date) {
        this.coment = coment;
        this.comentado = comentado;
        this.comentador = comentador;
        this.date = date;
    }
    
    public Coment(){
        
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getComentado() {
        return comentado;
    }

    public void setComentado(String comentado) {
        this.comentado = comentado;
    }

    public String getComentador() {
        return comentador;
    }

    public void setComentador(String comentador) {
        this.comentador = comentador;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
