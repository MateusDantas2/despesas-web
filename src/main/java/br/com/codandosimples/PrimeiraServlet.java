package br.com.codandosimples;

import br.com.codandosimples.infra.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mateus Nascimento
 */
@WebServlet(urlPatterns = {"/primeiraServlet", "/xpto"})
public class PrimeiraServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Primeira página através da nossa Primeira Servlet!</h1>");
        writer.println("</body>");
        writer.println("</html>");

        ConnectionFactory.getConnection();
    }
}
