/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uia.is12.data;

import com.uia.is12.domain.Poem;
import com.uia.is12.domain.Verse;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

/**
 *
 * @author Vera
 */
public class PoemDAO {

    private final String DB_URL = "jdbc:mysql://localhost:3307/progra2";
    private final String USER = "root";
    private final String PASS = "root";
    private Connection con = null;
    private CallableStatement cStmt = null;
    private Statement stmt;
    
    
    public Poem getPoem(int id) throws SQLException{
        Poem poem = new Poem();
        ArrayList<Verse> verses= new ArrayList();
        
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "SELECT * FROM verse WHERE poem_id="+id;
        cStmt = con.prepareCall(sql);
        ResultSet res = cStmt.executeQuery(); 
        
        while (res.next()) {
            verses.add(new Verse(res.getString("paragraph"), res.getInt("reading_time")));
          }
      
        cStmt.close();
        con.close();

        poem.setVerse(verses);
        return poem;
    }
    
    public void addVerse(String parragraph, int time, int id) throws SQLException{
        
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = con.createStatement();
        String sql = "INSERT INTO verse (paragraph, reading_time, poem_id) VALUES ('"+parragraph+"', "+time+", "+id+");";
        //String sql = "INSERT INTO verse VALUES ('having fun', 3000)";
        
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS); 
        
        stmt.close();
        con.close();

    }
    
    //Pueden crear un metodo main para probar que todo este funcionando
    //TODO: pasar a prueba de unidad
//    public static void main(String args[]) throws SQLException{
//        //NOTA: instancia de tipo PoemDAO
//        PoemDAO poemDAO = new PoemDAO();
//        ArrayList<Verse> verses= poemDAO.getPoem(1).getVerse();
//        
//        for(Verse v: verses){
//            System.out.println(v.getParagraph());
//        }
//        
//    }
    
}
