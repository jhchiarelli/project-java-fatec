package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author jorgehenriquechiarelli
 */
public class Conexao {
    private Connection conexao;

    public Conexao() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhoPoo", "root", "");
        } catch(SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexao() {
        return conexao;
    }
}
