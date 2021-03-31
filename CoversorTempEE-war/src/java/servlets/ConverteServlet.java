/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ContaCoversionsBean;
import beans.ConverteBean;
import beans.ListaConversoesBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
@WebServlet(name = "ConverteServlet", urlPatterns = {"/ConverteServlet"})
public class ConverteServlet extends javax.servlet.http.HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private ConverteBean convBean;

    @EJB
    private ListaConversoesBean listaConvBean;

    @EJB
    private ContaCoversionsBean contConvBean;

    Timestamp timestamp;

    /**
     * Default constructor.
     */
    public ConverteServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        double tempIn = Double.parseDouble(request.getParameter("temp"));
        timestamp = new Timestamp(System.currentTimeMillis());
        String msgConv = timestamp + ": " + request.getParameter("temp") + " graus Celsius para " + convBean.cToF(tempIn) + " graus Farenheit";
        listaConvBean.saveConv(msgConv);
        contConvBean.incContagem();
        out.println("<html><h1>Exemplo de uso de EJBs de Sessão</h1>");
        out.println("<h2>Servlet 1: Conversão de Temperatura - de Celsius para Farenheit</h2>");
        out.println("<p>[Stateless] O resultado da conversão de "+ request.getParameter("temp") + " graus Celsius para Farenheit é " + convBean.cToF(tempIn) + "</p>");
        out.println("<p></p>");
        out.println("<p>[Stateful] Histórico de coversões solicitadas nesta sessão:</p>");
        out.println("<ul>");
        List<String> lstConv = listaConvBean.getConvs();
        Iterator<String> convsAsIterator = lstConv.iterator();
        while (convsAsIterator.hasNext()) {
            String msg = convsAsIterator.next();
            out.println("<li>" + msg + "</li>");
        }
        out.println("</ul>");
        out.println("<p></p>");
        out.println("<p>[Singleton] Total de conversões solicitadas é " + contConvBean.getContagem() + "</p>");
        out.println("<p></p>");
        out.println("<p>Nova conversão: <a href=\"./conversor.html\">[Celsius para Farenheit]</a> <a href=\"./conversor-inv.html\">[Farenheit para Celsius]</a></p>");
    }

}
