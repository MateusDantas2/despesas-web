<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.codandosimples.infra.ConnectionFactory" %>
<%@ page import="br.com.codandosimples.dao.DespesaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.codandosimples.model.Despesa" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <table>
    <tr>
        <th>Descrição</th>
        <th>Data</th>
        <th>Valor</th>
        <th>Categoria</th>
    </tr>
    <%
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO dao = new DespesaDAO(connection);
        List<Despesa> despesas = dao.findAll();

        for (Despesa despesa : despesas) {
    %>
    <tr>
        <td><%= despesa.getDescricao() %></td>
        <td><%= despesa.getData() %></td>
        <td><%= despesa.getValor() %></td>
        <td><%= despesa.getCategoria() %></td>
    </tr>
    <%
    }
    %>
    </table>
</body>
</html>