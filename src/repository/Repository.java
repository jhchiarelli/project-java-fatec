/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import database.Conexao;
import entities.Comentario;
import entities.Filme;
import entities.Genero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorgehenriquechiarelli
 */
public class Repository {
    private Conexao conexao = new Conexao();
    
    public Genero findGenero(int id) {
        PreparedStatement st;
        ResultSet rs;
        Genero genero = null;
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM genero WHERE idGenero = ?");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setDescricao(rs.getString("descricao"));
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return genero;   
    }
        
    public List listGeneros() {
        PreparedStatement st;
        ResultSet rs;
        List list = new LinkedList();
        Genero genero = null;
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM genero");
            
            rs = st.executeQuery();
            
            while(rs.next()) {
                genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setDescricao(rs.getString("descricao"));
                list.add(genero);
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
        
    }
    
    
    public void addGenero(Genero genero) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("INSERT INTO genero (descricao) values (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, genero.getDescricao());
    
            st.execute();
            rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                genero.setIdGenero(rs.getInt(1));                                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        
    }
    
    
    public void updateGenero(Genero genero) {
        PreparedStatement st;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("UPDATE genero SET descricao=? WHERE idGenero=?",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, genero.getDescricao());
            st.setInt(i++, genero.getIdGenero());
            
            st.execute();
            
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        
    }
    
    // Filmes
    public Filme findFilme(int id) {
        PreparedStatement st;
        ResultSet rs;
        Filme filme = null;
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM filme WHERE idFilme = ?");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                filme = new Filme();
                filme.setIdFilme(rs.getInt("idFilme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setAno(rs.getString("ano"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setPais(rs.getString("pais"));
                filme.setGenero(rs.getInt("genero"));
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return filme;   
    }
        
    public List listFilmes() {
        PreparedStatement st;
        ResultSet rs;
        List list = new LinkedList();
        Filme filme = null;
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM filme");
            
            rs = st.executeQuery();
            
            while(rs.next()) {
                filme = new Filme();
                filme.setIdFilme(rs.getInt("idFilme"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setAno(rs.getString("ano"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setPais(rs.getString("pais"));
                filme.setGenero(rs.getInt("genero"));
                list.add(filme);
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
        
    }
    
    
    public void addFilme(Filme filme) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("INSERT INTO filme (titulo, ano, diretor, pais, genero) values (?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());            
            st.setString(i++, filme.getPais());
            st.setInt(i++, filme.getGenero());
    
            st.execute();
            rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                filme.setIdFilme(rs.getInt(1));                                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        
    }
    
    
    public void updateFilme(Filme filme) {
        PreparedStatement st;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("UPDATE filme SET titulo=?, ano=?, diretor=?, pais=?, genero=? WHERE idFilme=?",
                    PreparedStatement.RETURN_GENERATED_KEYS);            
            st.setString(i++, filme.getTitulo());
            st.setString(i++, filme.getAno());
            st.setString(i++, filme.getDiretor());            
            st.setString(i++, filme.getPais());            
            st.setInt(i++, filme.getGenero());        
            st.setInt(i++, filme.getIdFilme());
            
            st.execute();
            
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        
    }
    
    // Comentario
    public Comentario findComentario(int id) {
        PreparedStatement st;
        ResultSet rs;
        Comentario comentario = null;
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM comentario WHERE idComentario = ?");
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("idComentario"));
                comentario.setComentario(rs.getString("comentario"));
                comentario.setFilme(rs.getInt("filme"));
                comentario.setNota(rs.getDouble("nota"));
                comentario.setUsuario(rs.getString("usuario"));
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return comentario;   
    }
        
    public List listComentarios() {
        PreparedStatement st;
        ResultSet rs;
        List list = new LinkedList();
        Comentario comentario = null;
        
        try {
            st = conexao.getConexao().prepareStatement("SELECT * FROM comentario");
            
            rs = st.executeQuery();
            
            while(rs.next()) {
                comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("idComentario"));
                comentario.setComentario(rs.getString("comentario"));
                comentario.setFilme(rs.getInt("filme"));
                comentario.setNota(rs.getDouble("nota"));
                comentario.setUsuario(rs.getString("usuario"));
                list.add(comentario);
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return list;
        
    }
    
    
    public void addComentario(Comentario comentario) {
        PreparedStatement st;
        ResultSet rs;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("INSERT INTO comentario (filme, comentario, nota, usuario) values (?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(i++, comentario.getFilme());
            st.setString(i++, comentario.getComentario());
            st.setDouble(i++, comentario.getNota());            
            st.setString(i++, comentario.getUsuario());
    
            st.execute();
            rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                comentario.setIdComentario(rs.getInt(1));                                
            }
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        
    }
    
    
    public void updateComentario(Comentario comentario) {
        PreparedStatement st;
        int i = 1;
        
        try {
            st = conexao.getConexao().prepareStatement("UPDATE comentario SET comentario=?, nota=?, usuario=?, filme=?  WHERE idComentario=?",
                    PreparedStatement.RETURN_GENERATED_KEYS);            
            st.setString(i++, comentario.getComentario());
            st.setDouble(i++, comentario.getNota());
            st.setString(i++, comentario.getUsuario());                  
            st.setInt(i++, comentario.getFilme());
            st.setInt(i++, comentario.getIdComentario());            
            
            st.execute();
            
        } catch(SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            
        }        
        
    }
    
    
}
