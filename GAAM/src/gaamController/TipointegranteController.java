package gaamController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gaamDao.TipointegranteDAO;
import gaamModel.Tipointegrante;

@WebServlet("/tipointegrantes")

public class TipointegranteController extends HttpServlet{


		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{

			String q = request.getParameter("q");
			if (q != null && q.equals("new"))
			{
				request.getRequestDispatcher("tipoform.jsp").forward(request, response);
			} else
			{
				TipointegranteDAO dao = new TipointegranteDAO();
				request.setAttribute("lista", dao.listar());
				request.getRequestDispatcher("tipolist.jsp").forward(request, response);
				//criar o tipolist
			}
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{

			String descricao = request.getParameter("descricao");
			Tipointegrante tipo = new Tipointegrante(descricao);
			TipointegranteDAO dao = new TipointegranteDAO();
			dao.inserir(tipo);

			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("tipolist.jsp").forward(request, response);

	}
}
