package br.com.codandosimples.servlets;

import br.com.codandosimples.actions.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mateus Nascimento
 */
@WebServlet("/controller")
public class ServletController extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String actionName = request.getParameter("action");
            String pacote = "br.com.codandosimples.actions.";

            System.out.println("A ação executada foi: " + actionName);

            Class classe = Class.forName(pacote + actionName);
            Action action = (Action) classe.newInstance();

            String result = action.execute(request, response);

            RequestDispatcher dispatcher = request.getRequestDispatcher(result);
            dispatcher.forward(request, response);
        } catch (Exception e) {

        }


    }
}
