package org.catolicasc.eurocopa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/team")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Action action = ActionFactory.getAction(request, "ActionTeams");

		try {
			String view = action.execute(request, response);
			request.getRequestDispatcher(view).forward(request, response);
		} catch (ServletException | IOException e) {
			throw new ServletException("Falha na execu��o da action.", e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
