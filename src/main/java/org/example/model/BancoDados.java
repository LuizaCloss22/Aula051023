package org.example.model;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    private Connection conexao;
    private String mensagemErro;
    private boolean conectado;
    private String usuario;
    private String senha;
    private String nomeBanco;

    public Connection getConexao() {
        return conexao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean isConectado() {
        return conectado;
    }

    public BancoDados(String usuario, String senha, String nomeBanco) {
        this.usuario = usuario;
        this.senha = senha;
        this.nomeBanco = nomeBanco;
        realizaConexao();
    }

    public void realizaConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + nomeBanco, usuario, senha);
            conectado = true;
        } catch (ClassNotFoundException e) {
            conectado = false;
            mensagemErro += "\nErro ao carrear o drive" + e;
        } catch (SQLException e) {
            conectado = false;
            mensagemErro += "\nErro de SQL" + e;
        }
    }
}
