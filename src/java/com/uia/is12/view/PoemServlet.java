/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uia.is12.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vera
 */
public class PoemServlet extends HttpServlet{
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
    
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>hello Vera</h1>");
        out.println("</body>");
        out.println("</html>");
    
    }
    
}
