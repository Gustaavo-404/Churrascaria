package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;
import Model.Cadastro;

public abstract class CadastroController 
{
    
    private Connection conexao;
    
    public CadastroController() throws Exception{
        String url = "jdbc:mysql://localhost:3306/bdChurrascaria";
        String usuario = "root";
        String senha = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
    public abstract void inserir(Cadastro cadastro) throws Exception;
    public abstract void alterar(Cadastro cadastro) throws Exception;
    public abstract void excluir(Cadastro cadastro) throws Exception;
    public abstract ArrayList<Cadastro> exibirTodos() throws Exception;
    public abstract Cadastro consultaPorCodigo(int codigo) throws Exception;
    
}