/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.projetoPOO.dao;

import br.edu.ifnmg.projetoPOO.Cliente;
import br.edu.ifnmg.projetoPOO.Usuario;
import br.edu.ifnmg.projetoPOO.Vaga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filip
 */
public class VagaDao{
    
    
       /**
     * Recupera a sentença SQL específica para a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    public String getDeclaracaoInsert() {
        return "INSERT INTO vaga (placa, descricao, numero) VALUES (?, ?, ?);";
    }

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM vaga WHERE numero = ?;";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM vaga;";
    }
    
    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public String getDeclaracaoDelete() {
        return "DELETE FROM vaga WHERE numero = ?;";
    }
    
    
    
/**
     * Executa o procedimento de salvamento (inserção ou atualização) do objeto
     * mapeado no banco de dados.
     *
     * @param o Objeto a ser salvo no banco de dados.
     */
    public boolean salvar(Vaga o) {

        Vaga vaga = localizarPorId(o.getNumero());

        // Novo registro
        if (vaga == null) {

            // try-with-resources libera recurso ao final do bloco (PreparedStatement)
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para inserção de registros
                            getDeclaracaoInsert())) {

                // Prepara a declaração com os dados do objeto passado
                pstmt.setString(1, o.getPlaca());
                pstmt.setString(2, o.getDescricao());
                pstmt.setInt(3, o.getNumero());

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Vaga CADASTRADA com sucesso.");
            return true;
        } else {
            System.out.println("Vaga EM USO. Tente outra vaga.");
            return false;
        }
    }

    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    public Boolean excluir(Vaga o) {
        // Recupera a identidade (chave primária composta) 
        // do objeto a ser excluído
        Vaga vaga = localizarPorId(o.getNumero());

        // Se há uma identidade válida...
        if (vaga != null) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            getDeclaracaoDelete())) {

                // Prepara a declaração com os dados do objeto passado
                // TODO Ajustar a declaração preparada
                pstmt.setInt(1, o.getNumero());

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Vaga LIBERADA.");
        } else {
            System.out.println("Vaga já está liberada.");
            return false;
        }

        return true;
    }
    
    public Vaga localizarPorId(int numeroVaga) {
        // Declara referência para reter o objeto a ser recuperado
        Vaga objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getDeclaracaoSelectPorId())) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setInt(1, numeroVaga);

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
    
     public Vaga localizarTodos() {
        // Declara referência para reter o objeto a ser recuperado
        Vaga objeto = null;

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
    public Vaga extrairObjeto(ResultSet resultSet) {
        // Cria referência para montagem do autor-livro
        Vaga vaga = new Vaga();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado do autor-livro a ser mapeado
        try {
            vaga.setPlaca(resultSet.getString("placa"));
            vaga.setDescricao(resultSet.getString("descricao"));
            vaga.setNumero(resultSet.getInt("numero"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve o autor-livro mapeado
        return vaga;
    }
    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public List<Vaga> extrairObjetos(ResultSet resultSet) {

        // Cria referência para inserção das autores-livros a serem mapeados
        ArrayList<Vaga> vagaList = new ArrayList<>();

        // Tenta...
        try {
            // ... enquanto houver registros a serem processados
            while (resultSet.next()) {
                // Cria referência para montagem do autor-livro
                Vaga vaga = new Vaga();

                // Tenta recuperar dados do registro retornado pelo banco 
                // de dados e ajustar o estado do autor-livro a ser mapeado
                vaga.setPlaca(resultSet.getString("placa"));
                vaga.setDescricao(resultSet.getString("descricao"));
                vaga.setNumero(resultSet.getInt("numero"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Devolve a lista de autores-livros reconstituídos
        // dos registros do banco de dados
        return vagaList;
    }





    

}