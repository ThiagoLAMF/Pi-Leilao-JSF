/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Leilao.Lance;
import Leilao.Leilao;
import Usuario.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LeilaoDAO {
    
    public static boolean insereLeilao(Leilao leilao)
    {
        String query = "INSERT INTO TbLeilao(Ds_Leilao,Status_Leilao,Lance_Minimo,Valor_Lance) VALUES('" + leilao.getDescricao() + "'," + leilao.getStatus() + "," +
                        leilao.getLanceMinino() + "," + leilao.getValorLance() + ")";
        
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
    
    public static ArrayList<Leilao> getLeilao()
    {
        String query1 = "SELECT * FROM TbLeilao";
        
        try
        {
            ArrayList<Leilao> listaLeilao = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(query1);  
            while(rs.next())
            {
                Leilao l = new Leilao();
                l.setId(rs.getInt(1));
                l.setDescricao(rs.getString(2));
                l.setStatus(rs.getInt(3));
                l.setLanceMinino(rs.getFloat(4));
                l.setValorLance(rs.getFloat(5));
                listaLeilao.add(l);
            }
            con.close();
            
            for(Leilao l : listaLeilao)
            {
                l.setLances(LeilaoDAO.getLances(l.getId()));
            }
            
            return listaLeilao;
        }
        catch(Exception e)
        { 
            System.out.println(e);
            return null;
        }  
    }
    
    public static ArrayList<Lance> getLances(int idLeilao)
    {
        String query1 = "SELECT * FROM TbLance WHERE Fk_Id_Leilao = '" + idLeilao + "'";
        
        try
        {
            ArrayList<Lance> listaLance = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(query1);  
            while(rs.next())
            {
                Lance l = new Lance();
                Usuario u = new Usuario();
                
                String query2 = "SELECT * FROM TbUsuario WHERE Pk_Id_Usuario = '" + rs.getInt("Fk_Id_Usuario") + "'";
                Statement stmt2=con.createStatement();  
                ResultSet rs2=stmt2.executeQuery(query2);
                rs2.next();
                u.setNome(rs2.getString("Nome_Usuario"));
                u.setId(rs2.getInt("Pk_Id_Usuario"));
                
                l.setId(rs.getInt("Pk_Id_Lance"));
                l.setPrecolance(rs.getFloat("Lance_Leilao"));
                l.setUsuario(u);
                listaLance.add(l);
            }
            con.close();
            return listaLance;
        }
        catch(Exception e)
        { 
            System.out.println(e);
            return null;
        }  
    }
    
    public static boolean addLance(Lance l)
    {   
        String queryUpdate = "UPDATE TbLeilao SET Valor_Lance = Valor_Lance + " + l.getPrecolance() +
                             " WHERE Pk_Id_Leilao = " + l.getLeilao().getId();
       
        String querySelect = "SELECT Valor_Lance FROM TbLeilao " + 
                             "WHERE Pk_Id_Leilao = " + l.getLeilao().getId();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            // Update tbLeilao
            Statement stmt=con.createStatement();  
            stmt.executeUpdate(queryUpdate);
            
            //Seleciona valor atual do leilao
            Statement stmt2=con.createStatement();  
            ResultSet rs2=stmt2.executeQuery(querySelect);
            rs2.next();
            float valorLeilao = rs2.getFloat("Valor_Lance");
            
            
            String query = "INSERT INTO TbLance(Lance_Leilao,Fk_Id_Usuario,Fk_Id_Leilao) VALUES(" + valorLeilao + "," + l.getUsuario().getId() 
                        + "," + l.getLeilao().getId() + ")";
            stmt.executeUpdate(query);  
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
     public static boolean encerraLeilao(int idLeilao)
    {
        String queryUpdate = "UPDATE TbLeilao SET Status_Leilao = 2" + 
                             " WHERE Pk_Id_Leilao = " + idLeilao;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            Statement stmt=con.createStatement();  
            stmt.executeUpdate(queryUpdate);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
     
      public static boolean iniciaLeilao(int idLeilao)
    {
        String queryUpdate = "UPDATE TbLeilao SET Status_Leilao = 1" + 
                             " WHERE Pk_Id_Leilao = " + idLeilao;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao","root","");  
  
            Statement stmt=con.createStatement();  
            stmt.executeUpdate(queryUpdate);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
}
