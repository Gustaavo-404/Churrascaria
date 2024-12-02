package Controller;

import java.sql.*;
import java.util.*;
import Model.*;

public class UsuarioController extends CadastroController {

    public UsuarioController() throws Exception {
        super();
    }

    @Override
    public void inserir(Cadastro cadastro) throws Exception {
        
        Usuario usuario = (Usuario) cadastro;
        
        String sql = "insert into Usuario(NomeUsuario, Senha)" + " values (?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
        ps.execute();
    }

    @Override
    public void alterar(Cadastro cadastro) throws Exception {
        
        Usuario usuario = (Usuario) cadastro;
        
        String sql = "update Usuario" + " set NomeUsuario = ?, Senha = ?" + " where idUsuario = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
        ps.setInt(3, usuario.getIdUsuario());
        ps.execute();
        
    }
    
    public Usuario autenticarUsuario(String nomeUsuario, String senha) throws Exception {
        String sql = "SELECT idUsuario, NomeUsuario FROM Usuario WHERE NomeUsuario = ? AND Senha = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, nomeUsuario);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("NomeUsuario"));

            return usuario;
        } else {
            return null;
        }
    }

    @Override
    public void excluir(Cadastro cadastro) throws Exception {
        Usuario usuario = (Usuario) cadastro;
        
        String sql = "delete from Usuario where idUsuario = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, usuario.getIdUsuario());
        ps.execute();
    }

    @Override
    public ArrayList<Cadastro> exibirTodos() throws Exception {
        ArrayList<Cadastro> lista = new ArrayList<>();
        
        String sql = "select * from Usuario";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("NomeUsuario"));
            usuario.setSenha(rs.getString("Senha"));
            
            lista.add(usuario);
        }
        
        return lista;
    }

    @Override
    public Cadastro consultaPorCodigo(int codigo) throws Exception {
        Usuario usuario = null;
        
        String sql = "select * from Usuario where idUsuario = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("NomeUsuario"));
            usuario.setSenha(rs.getString("Senha"));
        }
        
        return usuario;
    }

}