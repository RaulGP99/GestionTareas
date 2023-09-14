package org.zabalburu.GestionTareas.dao.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GestionTareasSrv
 */
@WebServlet (name="GT2", value = "/GT2")
public class GestionTareasSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionTareasSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mostrarLogin(request,response);
	}

	
	
	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n"
				+ "    <link\r\n"
				+ "      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\"\r\n"
				+ "      rel=\"stylesheet\"\r\n"
				+ "      integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\"\r\n"
				+ "      crossorigin=\"anonymous\"\r\n"
				+ "    />\r\n"
				+ "    <title>Gestion Tareas</title>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "        <div class=\"col-3\"></div>\r\n"
				+ "        <div class=\"col-6 text-center\"><h1>Introduzca sus Datos</h1></div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "        <div class=\"col-3\"></div>\r\n"
				+ "        <div class=\"col-6 text-center\">\r\n"
				+ "            <form action=\"GT\" method=post>\r\n"
				+ "            <div class=\"mb-3\">\r\n"
				+ "                <label for=\"exampleInputEmail1\">Email address</label>\r\n"
				+ "                <input\r\n"
				+ "                type=\"email\"\r\n"
				+ "                name=\"usuario\"\r\n"
				+ "                class=\"form-control\"\r\n"
				+ "                id=\"exampleInputEmail1\"\r\n"
				+ "                aria-describedby=\"emailHelp\"\r\n"
				+ "                placeholder=\"Enter email\"\r\n"
				+ "                />\r\n"
				+ "                <small id=\"emailHelp\" class=\"form-text text-muted\"\r\n"
				+ "                >We'll never share your email with anyone else.</small\r\n"
				+ "                >\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"mb-3\">\r\n"
				+ "                <label for=\"exampleInputPassword1\">Password</label>\r\n"
				+ "                <input\r\n"
				+ "                type=\"password\"\r\n"
				+ "                name=\"password\"\r\n"
				+ "                class=\"form-control\"\r\n"
				+ "                id=\"exampleInputPassword1\"\r\n"
				+ "                placeholder=\"Password\"\r\n"
				+ "                />\r\n"
				+ "            </div>\r\n"
				+ "            <button type=\"submit\" class=\"btn btn-primary\">Entrar</button>\r\n"
				+ "            </form>\r\n"
				+ "        </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "    <script\r\n"
				+ "      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "      integrity=\"sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm\"\r\n"
				+ "      crossorigin=\"anonymous\"\r\n"
				+ "    ></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>\r\n"
				+ "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
