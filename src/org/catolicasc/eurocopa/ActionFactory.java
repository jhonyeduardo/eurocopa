package org.catolicasc.eurocopa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	public static Action getAction(HttpServletRequest request, String defaultAction) throws ServletException {
		String parameter = request.getParameter("action") != null ? request.getParameter("action") : defaultAction;
		String className = "org.catolicasc.eurocopa." + parameter;

		try {
			Class<?> clazz = Class.forName(className);
			Action action = (Action) clazz.newInstance();

			return action;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException("A ActionFactory causou uma exce��o", e);
		}
	}
}