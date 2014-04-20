/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uia.is12.view;

import com.uia.is12.business.PoemBusiness;
import com.uia.is12.domain.Verse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vera
 */
public class VerseServlet extends HttpServlet{
  
    private PoemBusiness poemBusiness;

    public VerseServlet() {
        this.poemBusiness = new PoemBusiness();
    }
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ArrayList<Verse> verses;
            verses = poemBusiness.getPoem(1).getVerse();
            for(Verse v: verses){
                out.println("<p>"+v.getParagraph()+"</p>");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("<p>test</p>");    
        out.println("</body>");
        out.println("</html>");
    
    }
    
}
