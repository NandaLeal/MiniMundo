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
public class ClienteDao {

    
    /**
     * Recupera a sentença SQL específica para a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    public String getDeclaracaoInsert() {
        return "INSERT INTO cliente(nome, endereco, email, ddd, fone, cpf) VALUES (?, ?, ?, ?, ?, ?);";
    }

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM cliente WHERE cpf = ?;";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM cliente;";
    }
    
    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public String getDeclaracaoDelete() {
        return "DELETE FROM cliente WHERE cpf = ?;";
    }
    
    /**
     * Executa o procedimento de salvamento (inserção ou atualização) do objeto
     * mapeado no banco de dados.
     *
     * @param o Objeto a ser salvo no banco de dados.
     */
    public void salvar(Cliente o) {

        Cliente cliente = localizarPorId(o.getCpf());

        // Novo registro
        if (cliente == null) {

            // try-with-resources libera recurso ao final do bloco (PreparedStatement)
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para inserção de registros
                            getDeclaracaoInsert())) {

                // Prepara a declaração com os dados do objeto passado
                pstmt.setString(1, o.getNome());
                pstmt.setString(2, o.getEndereco());
                pstmt.setString(3, o.getEmail());
                pstmt.setLong(4, o.getDdd());
                pstmt.setLong(5, o.getFone());
                pstmt.setLong(6, o.getCpf());

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    public Boolean excluir(Cliente o) {
        // Recupera a identidade (chave primária composta) 
        // do objeto a ser excluído
        Long clienteCpf = o.getCpf();

        // Se há uma identidade válida...
        if (clienteCpf != null && clienteCpf != 0) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            getDeclaracaoDelete())) {

                // Prepara a declaração com os dados do objeto passado
                // TODO Ajustar a declaração preparada
                pstmt.setLong(1, o.getCpf());

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return false;
        }

        return true;
    }
    
    public Cliente localizarPorId(Long clienteCpf) {
        // Declara referência para reter o objeto a ser recuperado
        Cliente objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getDeclaracaoSelectPorId())) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setLong(1, clienteCpf);

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... extrai objeto do respectivo registro do banco de dados
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve nulo (objeto não encontrado) ou o objeto recuperado
        return objeto;
    }
    
     public Cliente localizarTodos() {
        // Declara referência para reter o objeto a ser recuperado
        Cliente objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getDeclaracaoSelectTodos())) {

            // Prepara a declaração com os dados do objeto passado

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... extrai objeto do respectivo registro do banco de dados
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve nulo (objeto não encontrado) ou o objeto recuperado
        return objeto;
    }
    
    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    public Cliente extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do autor-livro
        Cliente cliente = new Cliente();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do autor-livro a ser mapeado
        try {
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEndereco(resultSet.getString("endereco"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setDdd(resultSet.getInt("ddd"));
            cliente.setFone(resultSet.getLong("fone"));
            cliente.setCpf(resultSet.getLong("cpf"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve o autor-livro mapeado
        return cliente;
    }
    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public List<Cliente> extrairObjetos(ResultSet resultSet) {

        // Cria referência para inserção das autores-livros a serem mapeados
        ArrayList<Cliente> clienteList = new ArrayList<>();

        // Tenta...
        try {
            // ... enquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do autor-livro
                Cliente cliente = new Cliente();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do autor-livro a ser mapeado
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setDdd(resultSet.getInt("ddd"));
                cliente.setFone(resultSet.getLong("fone"));
                cliente.setCpf(resultSet.getLong("cpf"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de autores-livros reconstituídos
        // dos registros do banco de dados
        return clienteList;
    }
    
    
    
//    
//    
//    @Override
//    public Long salvar(Cliente o) {
//        System.out.println("insert into cliente (nome, email, endereco, cpf, ddd, fone) values "
//                + "('"+o.getNome()+"', '"+o.getEmail()+"', '"+o.getEndereco()+"', '"+o.getCpf()+"', "
//                 + "'"+o.getDdd()+"', '"+o.getFone()+"');");
//        return 0L;           
//    }
//
//    @Override //id do cliente é o cpf
//    public Cliente localizarPorId(Long cpf) { 
//        System.out.println("select * from cliente where cpf = '"+ cpf +"';");       
//        return null;
//    }
//
//    @Override
//    public List<Cliente> localizarTodos() {
//        System.out.println("select * from cliente");        
//        return null;
//    }
//
//    @Override
//    public void excluir(Cliente o) {
//        System.out.println("select * from cliente where cpf = '"+ o.getCpf() +"';");
//    }

    
}
