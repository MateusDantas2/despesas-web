package br.com.codandosimples.actions;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mateus Nascimento
 */
public class AddExpense implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String descriptionStr = request.getParameter("description");
        String dateStr = request.getParameter("date");
        String valueStr = request.getParameter("value");
        String categoryStr = request.getParameter("category");

        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        double valor = Double.parseDouble(valueStr);
        Categoria categoria = Categoria.valueOf(categoryStr);

        Despesa despesa = new Despesa(descriptionStr, date, valor, categoria);
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao = new DespesaDAO(connection);
        dao.save(despesa);

        return "/WEB-INF/added-expense.jsp";
    }
}
