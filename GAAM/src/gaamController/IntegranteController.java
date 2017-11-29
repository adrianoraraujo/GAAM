package gaamController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gaamDao.IntegrantesDAO;
import gaamDao.TipointegranteDAO;
import gaamModel.Integrante;
import gaamModel.Tipointegrante;



@WebServlet("/integrantes")
public class IntegranteController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			TipointegranteDAO dao = new TipointegranteDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("integform.jsp").forward(request, response);
		}else {
			IntegrantesDAO dao = new IntegrantesDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("integlist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		String idade = request.getParameter("idade");
		String nome_resp = request.getParameter("nomeresp");
		String email = request.getParameter("email");
		int Tipo_in_ID = Integer.parseInt(request.getParameter("tipo"));
		
		
		Integrante i = new Integrante();
		i.setNome(nome);
		i.setCpf(cpf);
		i.setEndereco(endereco);
		i.setTelefone(telefone);
		i.setEmail(email);
		int ida = Integer.parseInt(idade);
		i.setIdade(ida);
		i.setNome_resp(nome_resp);
		Tipointegrante ti = new Tipointegrante();
		ti.setId(Tipo_in_ID);
		i.setTipointegrante(ti);
		
		
		
		IntegrantesDAO dao = new IntegrantesDAO();
		dao.inserir(i);
		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("integlist.jsp").forward(request, response);

		
		
	}


}
