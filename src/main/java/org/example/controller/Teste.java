package org.example.controller;

import org.example.model.BancoDados;
import org.example.model.Livro;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {
        BancoDados bancoDados = new BancoDados("root", "", "livraria");
        if (bancoDados.isConectado()) {
            Livro livro = new Livro(bancoDados.getConexao());
            livro.setTitlo("Novo Titulo");
            livro.setAutor("Autor do Livro");
            livro.setIdioma("Pt-Br");
            livro.setClassificacao("Programação");
            livro.setResumo("Resumo do livro");
            try {
                livro.gravar();
                System.out.println("Gravado");
                System.out.println(livro.obterListaLivros());

            } catch (SQLException e ){
                System.out.println("Erro ao gravar");
            }
            /*try {
                livro.deletar(1134521061 );
                System.out.println("Deletado");
                System.out.println(livro.obterListaLivros());
            } catch (SQLException e ){
                System.out.println("Erro ao deletar");
            }*/
            try {
                livro.setTitlo("Novicimo Titulo");
                livro.setAutor("Autor do Livro novo");
                livro.setIdioma("Pt-Br");
                livro.setClassificacao("Programação Java");
                livro.setResumo("Resumo do livro novo");
                livro.atualizar(628580456);
                System.out.println("Atualizado com sucesso");
            } catch (SQLException e ){
                System.out.println("Falha ao atualizar");
            }
        } else {
            System.out.println(bancoDados.getMensagemErro());
        }
    }

}
