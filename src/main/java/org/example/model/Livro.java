package org.example.model;

import java.sql.*;
import java.util.Random;

public class Livro {
    private int idLivro;
    private String titlo;
    private String idioma;
    private String autor;
    private String classificacao;
    private String resumo;
    private Connection conexao;

    public Livro() {

    }

    public Livro(Connection conexao) {
        this.conexao = conexao;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitlo() {
        return titlo;
    }

    public void setTitlo(String titlo) {
        this.titlo = titlo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public boolean gravar() throws SQLException {
        String sql = "insert into livro (id_livro, titulo, idioma, autor, classificacao, resumo) values ( ? , ? , ? , ? , ? , ? )";
        PreparedStatement requisicao = conexao.prepareStatement(sql);
        requisicao.setInt(1, new Random().nextInt());
        requisicao.setString(2, titlo);
        requisicao.setString(3, idioma);
        requisicao.setString(4, autor);
        requisicao.setString(5, classificacao);
        requisicao.setString(6, resumo);
        requisicao.executeUpdate();
        return true;
    }
    public boolean deletar( int idLivro ) throws SQLException{
        String sql = "delete from livro where id_livro = "+idLivro;
        PreparedStatement requisicao = conexao.prepareStatement(sql);
        requisicao.executeUpdate();
        return true;
    }
    public boolean atualizar( int idLivro ) throws SQLException {
        String sql = "update livro set titulo = ? , idioma = ?, autor = ? , classificacao = ? , resumo = ? where id_livro = "+idLivro;
        PreparedStatement requisicao = conexao.prepareStatement(sql);
        requisicao.setString(1, titlo);
        requisicao.setString(2, idioma);
        requisicao.setString(3, autor);
        requisicao.setString(4, classificacao);
        requisicao.setString(5, resumo);
        requisicao.executeUpdate();
        return true;

    }
    public ResultSet obterListaLivros() throws SQLException {
        String sql = "select * from livro";
        Statement requisicao = conexao.createStatement();
        return requisicao.executeQuery(sql);
    }
}
