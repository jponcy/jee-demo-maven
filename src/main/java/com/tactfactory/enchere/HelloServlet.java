package com.tactfactory.enchere;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final String TPL_PATH = "/WEB-INF/hello.jsp";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("msg", "Salut tout le monde !");
		req.setAttribute("entity", new MaDao().getOne(1L));

		getServletContext().getRequestDispatcher(TPL_PATH).forward(req, resp);
	}
}
