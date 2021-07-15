
package br.edu.ifnmg.projetoPOO;

/**
 *
 * @author Filipi
 * @version 1.0
 */
public class BancoDeDados {
    
    private String tabela;
    
    public String getTabela(){
        tabela = "Mensalistas";
        //tabela = "Vagas";
        //tabela = "Veiculos";
        return "SELECT * FROM "+ tabela +";";
    }
    
    public String GetInadimplentes(){
        return "SELECT * FROM Mensalistas WHERE Inadimplente = 'True';";
    }
}
