/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.RegistryBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet(name = "RegistryServlet", urlPatterns = {"/RegistryServlet"})
public class RegistryServlet extends HttpServlet {

    @EJB
    private RegistryBean reg;

    public RegistryServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World EE</title>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Exemplo de uso de EJBs com diferentes interfaces</h1>");
        out.println("<h2>Message-driven Bean - Mensagens recebidas</h2>");
        out.println("<p>As seguintes mensagens foram recebidas:</p>");
        out.println("<ul>");
        List<String> lstMsgs = reg.getMsgs();
        Iterator<String> msgsAsIterator = lstMsgs.iterator();
        while (msgsAsIterator.hasNext()) {
            String msg = msgsAsIterator.next();
            out.println("<li>" + msg + "</li>");
        }
        out.println("</ul>");
        out.println("<p></p>");
        out.println("<p>Tente novamente: [<a href=\"./hello.html\">Local</a>] [<a href=\"./hello-remote.html\">Remoto</a>] [<a href=\"./hello-mdb.html\">MDB</a>]</p>");
    }

}
