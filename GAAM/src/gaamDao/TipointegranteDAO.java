package gaamDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gaamModel.Tipointegrante;
import gaamUtil.Conexao;

public class TipointegranteDAO {
	
	private Conexao conexao;

	public TipointegranteDAO()
	{
		this.conexao = Conexao.getConexao();
	}

	public List<Tipointegrante> listar()
	{
		Statement stmt;
		List<Tipointegrante> tipos = new ArrayList<>();
		try
		{
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id,descricao from tipointegrantes;");
			while (rs.next())
			{
				Tipointegrante tipo = new Tipointegrante();
				tipo.setId(rs.getInt("id"));
				tipo.setDescricao(rs.getString("descricao"));
				tipos.add(tipo);
			}
			stmt.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return tipos;
	}

	public void inserir(Tipointegrante tipointegrante)
	{
		try
		{

			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into tipointegrantes (descricao) values (?);");
			ps.setString(1, tipointegrante.getDescricao());
			ps.execute();
			ps.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public void close()
	{
		conexao.closeConnection();
}

}
