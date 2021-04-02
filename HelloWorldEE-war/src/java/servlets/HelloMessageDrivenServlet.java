/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet(name = "HelloMessageDrivenServlet", urlPatterns = {"/HelloMessageDrivenServlet"})
public class HelloMessageDrivenServlet extends javax.servlet.http.HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public HelloMessageDrivenServlet() {
        // TODO Auto-generated constructor stub
    }

    @Resource
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "java:app/helloQueue")
    private Queue queue;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");

        String msg = "Olá, " + request.getParameter("nome") + "!";

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setText(msg);
            messageProducer.send(message);
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World EE</title>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Exemplo de uso de EJBs com diferentes interfaces</h1>");
        out.println("<h2>Message-driven Bean</h2>");
        out.println("<p> Enviada a seguite mensagem: " + msg + " </p>");
        out.println("<p></p>");
        out.println("<p> Veja as mensagens recebidas [<a href=\"./RegistryServlet\">link</a>]</p>");
        out.println("<p></p>");
        out.println("<p>Tente novamente: [<a href=\"./hello.html\">Local</a>] [<a href=\"./hello-remote.html\">Remoto</a>] [<a href=\"./hello-mdb.html\">MDB</a>]</p>");
        out.println("</body>");
        out.println("</html>");
    }

}
