/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorgehenriquechiarelli
 */
public class Comentario {
    private int idComentario;
    private String comentario;
    private Double nota;
    private String usuario;
    private int filme;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getFilme() {
        return filme;
    }

    public void setFilme(int filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return idComentario + "-" + comentario.substring(0, comentario.length());
    }

    
    
}
