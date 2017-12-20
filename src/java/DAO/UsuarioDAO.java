/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Usuario.Usuario;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UsuarioDAO {
    
    Connection con;
    
    public UsuarioDAO()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root",""); 
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void fechaConexao()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean insereUsuario(Usuario user)
    {
        String query = "INSERT INTO TbUsuario(Nome_Usuario,Login_Usuario,Senha_Usuario,Fg_Admin) VALUES('" + user.getNome() + "','" +
                        user.getLogin() + "','" + user.getSenha() + "'," + user.isAdmin() + ")";
        
        try
        {
            
  
            Statement stmt=con.createStatement();  
            stmt.executeUpdate(query);  
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean deleteUsuario(Usuario user)
    {
        String query = "DELETE FROM TbUsuario WHERE Pk_Id_Usuario = " + user.getId();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            Statement stmt=con.createStatement();  
            stmt.executeUpdate(query);  
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public Usuario getUsuario(String login)
    {
        try
        {
            Usuario usu = null;
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT * FROM TbUsuario WHERE Login_Usuario = '" + login +"'");  
            while(rs.next())
            {
                usu = new Usuario();
                usu.setId(rs.getInt(1));
                usu.setNome(rs.getString(2));
                usu.setLogin(rs.getString(3));
                usu.setSenha(rs.getString(4));
                usu.setAdmin(rs.getBoolean(5));
            }
            con.close();
            return usu;
        }
        catch(Exception e)
        { 
            System.out.println(e);
            return null;
        }  
    }  
}
