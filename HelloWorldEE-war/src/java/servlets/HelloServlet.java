/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.HelloBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet"})
public class HelloServlet extends javax.servlet.http.HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

    @EJB
    private HelloBeanLocal hello;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        
        String msg = "Olá";
        String turno = hello.getShift();
        
        switch (turno) {
            
            case "madrugada":
            case "manhã":
                msg = "Bom dia";
                break;
            case "tarde":
                msg = "Boa tarde";
                break;
            case "noite":
                msg = "Boa noite";
        }
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World EE</title>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Exemplo de uso de EJBs com diferentes interfaces</h1>");
        out.println("<h2>Interface local</h2>");
        out.println("<p>" + msg + ", " + nome + "!</p>");
        out.println("<p> Hoje é " + hello.getDay() + " de " + hello.getMonth() + " de " + hello.getYear() + ", uma " + hello.getWeekDay() + "...</p>");
        out.println("<p> São " + hello.getHour() + ":" + hello.getMinutes() + "h da " + hello.getShift() + "...</p>");
        out.println("<p></p>");
        out.println("<p>Tente novamente: [<a href=\"./hello.html\">Local</a>] [<a href=\"./hello-remote.html\">Remoto</a>] [<a href=\"./hello-mdb.html\">MDB</a>]</p>");
        out.println("</body>");
        out.println("</html>");
    }

}
