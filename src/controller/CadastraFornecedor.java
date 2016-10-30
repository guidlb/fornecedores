/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javafx.application.Application.launch;

/**
 *
 * @author Vorb
 */
public class CadastraFornecedor {

    public void cadastra(int cnpj, String nome, int telefone, String email, String endereco) throws SQLException {

        Connection conexao;
        conexao = ConnectionDB.getConnection();

        PreparedStatement stmt = null;

        stmt = conexao.prepareStatement("INSERT INTO tb_fornecedores (cnpj, nome,telefone,email,endereco) VALUES(?,?,?,?,?)");

        stmt.setInt(1, cnpj);
        stmt.setString(2, nome);
        stmt.setInt(3, telefone);
        stmt.setString(4, email);
        stmt.setString(5, endereco);

        stmt.executeUpdate();

        ConnectionDB.closeConnection(conexao, stmt);
        System.out.println("salvo");
    }
}
