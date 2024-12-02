package Controller;

import java.sql.*;
import java.util.*;
import Model.*;


public class BebidaController extends CadastroController {

    public BebidaController() throws Exception {
        super();
    }
    
    @Override
    public void inserir(Cadastro cadastro) throws Exception {
        Bebida bebida = (Bebida) cadastro;
        
        String sql = "INSERT INTO Bebida (NomeBebida, Quantidade, Preco) VALUES (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, bebida.getNomeBebida());
        ps.setDouble(2, bebida.getQuantidade());
        ps.setDouble(3, bebida.getPreco());
        ps.execute();
    }

    @Override
    public void alterar(Cadastro cadastro) throws Exception {
        Bebida bebida = (Bebida) cadastro;
        
        String sql = "update Bebida" + " set NomeBebida = ?, Quantidade = ?, Preco = ?" + " where idBebida = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, bebida.getNomeBebida());
        ps.setDouble(2, bebida.getQuantidade());
        ps.setDouble(3, bebida.getPreco());
        ps.setInt(4, bebida.getIdBebida());
        ps.execute();
    }

    @Override
    public void excluir(Cadastro cadastro) throws Exception {
        Bebida bebida = (Bebida) cadastro;
        
        String sql = "delete from Bebida where idBebida = ?";
        
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, bebida.getIdBebida());
        ps.execute();
    }

    @Override
    public ArrayList<Cadastro> exibirTodos() throws Exception {
        ArrayList<Cadastro> lista = new ArrayList<>();
        
        String sql = "select * from Bebida";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Bebida bebida = new Bebida();
            bebida.setIdBebida(rs.getInt("idBebida"));
            bebida.setNomeBebida(rs.getString("NomeBebida"));
            bebida.setQuantidade(rs.getDouble("Quantidade"));
            bebida.setPreco(rs.getDouble("Preco"));
            
            lista.add(bebida);
        }
        
        return lista;
    }

    @Override
    public Cadastro consultaPorCodigo(int codigo) throws Exception {
        Bebida bebida = null;

        String sql = "SELECT * FROM Bebida WHERE idBebida = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            bebida = new Bebida();
            bebida.setIdBebida(rs.getInt("idBebida"));
            bebida.setNomeBebida(rs.getString("NomeBebida"));
            bebida.setQuantidade(rs.getDouble("Quantidade"));
            bebida.setPreco(rs.getDouble("Preco"));
        } else {
            throw new Exception("Bebida não encontrada para o código: " + codigo);
        }

        return bebida;
    }
       
}