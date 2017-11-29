package gaamDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gaamModel.Integrante;
import gaamModel.Tipointegrante;
import gaamUtil.Conexao;



public class IntegrantesDAO {


	private Conexao conexao;

	public IntegrantesDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Integrante> listarLazy() {
		Statement stmt;
		List<Integrante> integrantes = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id,nome, cpf, endereco, telefone, email, idade, tipo_in_id, nome_resp from integrantes, tipointegrantes");
			while(rs.next()) {
				
				Integrante i = new Integrante();
				i.setId(Integer.parseInt(rs.getString("id")));
				i.setNome(rs.getString("nome"));
				i.setCpf(rs.getString("cpf"));
				i.setEndereco(rs.getString("endereco"));
				i.setTelefone(rs.getString("telefone"));
				i.setEmail(rs.getString("email"));
				int ida = Integer.parseInt(rs.getString("idade"));
				i.setIdade(ida);
				i.setNome_resp(rs.getString("nome_resp"));

				Tipointegrante t = new Tipointegrante();
				t.setId(rs.getInt("tipo_in_id"));
				i.setTipointegrante(t);
				
				
				integrantes.add(i);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return integrantes;
	}
	
	
	public List<Integrante> listar() {
		Statement stmt;
		List<Integrante> integrantes = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select integrantes.id,nome, cpf, endereco, telefone, email, idade, tipo_in_id, nome_resp from integrantes, tipointegrantes where integrantes.tipo_in_id=tipointegrantes.id;");
			while(rs.next()) {
				Integrante i = new Integrante();
				i.setId(rs.getInt("id"));
				i.setNome(rs.getString("nome"));
				i.setCpf(rs.getString("cpf"));
				i.setEndereco(rs.getString("endereco"));
				i.setTelefone(rs.getString("telefone"));
				i.setEmail(rs.getString("email"));
				int ida = Integer.parseInt(rs.getString("idade"));
				i.setIdade(ida);
				i.setNome_resp(rs.getString("nome_resp"));

				Tipointegrante t = new Tipointegrante();
				t.setId(rs.getInt("tipo_in_id"));
				i.setTipointegrante(t);
				
				
				integrantes.add(i);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return integrantes;
	}


	public void inserir(Integrante integrantes) {
		try {

			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into integrantes (nome, cpf, endereco, telefone, email, idade, tipo_in_id, nome_resp) values (?,?,?,?,?,?,?,?);");
			ps.setString(1, integrantes.getNome());
			ps.setString(2, integrantes.getCpf());
			ps.setString(3, integrantes.getEndereco());
			ps.setString(4, integrantes.getTelefone());
			ps.setString(5, integrantes.getEmail());
			ps.setInt(6, integrantes.getIdade());
			ps.setInt(7, integrantes.getTipointegrante().getId());
			ps.setString(8, integrantes.getNome_resp());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integrante getByID(int id) {
		Integrante i = null;
		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("select id,nome, cpf, endereco, telefone, email, idade, nome_resp from integrantes where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = new Integrante();
				i.setId(rs.getInt("id"));
				i.setNome(rs.getString("nome"));
				i.setCpf(rs.getString("cpf"));
				i.setEndereco(rs.getString("endereco"));
				i.setTelefone(rs.getString("telefone"));
				i.setEmail(rs.getString("email"));
				int ida = Integer.parseInt(rs.getString("idade"));
				i.setIdade(ida);
				i.setNome_resp(rs.getString("nome_resp"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
