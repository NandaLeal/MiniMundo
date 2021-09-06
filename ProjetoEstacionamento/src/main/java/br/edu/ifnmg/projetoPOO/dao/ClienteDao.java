/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Cliente;
import br.edu.ifnmg.projetoPOO.Usuario;
import java.util.List;
import br.edu.ifnmg.projetoPOO.gui.CadastroCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filipi
 * @version 1.2
 */
public class ClienteDao extends AbstractDao<Cliente, Long>{

    @Override
    public String getDeclaracaoInsert() {
         return "INSERT INTO cliente (nome, endereco, email, ddd, fone, cpf) VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getDeclaracaoSelectPorId() {
         return "SELECT * FROM cliente WHERE cpf = ?;";
    }

    @Override
    public String getDeclaracaoSelectTodos() {
         return "SELECT * FROM cliente;";
    }

    @Override
    public String getDeclaracaoUpdate() {
         return "UPDATE cliente SET nome = ?, endereco = ?, email = ?, ddd = ?, fone = ?, cpf = ? WHERE cpf = ?;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "DELETE FROM cliente WHERE id = ?;";
    }
    

    /**
     * Insere os valores do objeto na senteça SQL específica para inserção ou
     * atualização de registros no banco de dados.
     *
     * @param pstmt Declaração previamente preparada.
     * @param cliente
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Cliente cliente) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
            // INSERT
            if (cliente.getId() == null || cliente.getId() == 0) {
                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getEndereco());
                pstmt.setString(3, cliente.getEmail());
                pstmt.setLong(4, cliente.getDdd());
                pstmt.setLong(5, cliente.getFone());
                pstmt.setLong(6, cliente.getCpf());
            } else {
//          // UPDATE
                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getEndereco());
                pstmt.setString(3, cliente.getEmail());
                pstmt.setLong(4, cliente.getDdd());
                pstmt.setLong(5, cliente.getFone());
                pstmt.setLong(6, cliente.getCpf());
                pstmt.setLong(7, cliente.getId());
//                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do livro
        Cliente cliente = new Cliente();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do livro a ser mapeado
        try {
//            livro.set...(resultSet.get...("???"));
            cliente.setId(resultSet.getLong("id"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEndereco(resultSet.getString("endereco"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setDdd(resultSet.getLong("ddd"));
            cliente.setFone(resultSet.getLong("fone"));
            cliente.setCpf(resultSet.getLong("cpf"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve o livro mapeado
        return cliente;
    }

    @Override
    public List<Cliente> extrairObjetos(ResultSet resultSet) {
        // Cria referência para inserção dos livros a serem mapeados
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Tenta...
        try {
            // ... enquanto houver registros a serem processados
            while (resultSet.next()) {
                
                // Cria referência para montagem do livro
                Cliente cliente = new Cliente();

                // Cria referência para montagem do livro
                cliente.setId(resultSet.getLong("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setDdd(resultSet.getLong("ddd"));
                cliente.setFone(resultSet.getLong("fone"));
                cliente.setCpf(resultSet.getLong("cpf"));
                
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de livros reconstituídos dos registros do banco 
        // de dados
        return clientes;
    }

    
}

    