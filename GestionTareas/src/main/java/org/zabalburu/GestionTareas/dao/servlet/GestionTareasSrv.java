package org.zabalburu.GestionTareas.dao.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.zabalburu.GestionTareas.dao.modelo.Empleado;
import org.zabalburu.GestionTareas.dao.servicio.TareasServicio;

/**
 * Servlet implementation class GestionTareasSrv
 */
@WebServlet(name = "GT2", value = "/GT2")
public class GestionTareasSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TareasServicio servicio = new TareasServicio();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionTareasSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		mostrarLogin(request, response, null);
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response, String error)
			throws IOException {
		// TODO Auto-generated method stub
		String html = """
				<!DOCTYPE html>
				<html lang="en">
				  <head>
				    <meta charset="utf-8" />
				    <meta name="viewport" content="width=device-width, initial-scale=1" />
				    <link
				      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
				      rel="stylesheet"
				      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
				      crossorigin="anonymous"
				    />
				    <title>Gestion Tareas</title>
				  </head>
				  <body>
				    <div class="container">
				        <div class="row">
				        <div class="col-3"></div>
				        <div class="col-6 text-center"><h1>Introduzca sus Datos</h1></div>
				        </div>
				        <div class="row">
				        <div class="col-3"></div>
				        <div class="col-6 text-center">
				            <form action="GT" method="POST">
				            <div class="mb-3">
				                <label for="exampleInputEmail1">Email address</label>
				                <input
				                type="email"
				                name="usuario"
				                class="form-control"
				                id="exampleInputEmail1"
				                aria-describedby="emailHelp"
				                placeholder="Enter email"
				                />
				                <small id="emailHelp" class="form-text text-muted"
				                >We'll never share your email with anyone else.</small
				                >
				            </div>
				            <div class="mb-3">
				                <label for="exampleInputPassword1">Password</label>
				                <input
				                type="password"
				                name="password"
				                class="form-control"
				                id="exampleInputPassword1"
				                placeholder="Password"
				                />
				            </div>
				            <button type="submit" class="btn btn-primary">Entrar</button>
				            </form>
				        </div>
				        </div>
				        """;

		if (error != null) {
			html += """
					<div class="mt-3 row">
						<div class="col-3"></div>
						<div class="col-6">
							<div class="alert alert-danger" role="alert">
								""" + error + """
							</div>
						</div>
					</div>""";
		}

		html += """
				    </div>
				    <script
				      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
				      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
				      crossorigin="anonymous"
				    ></script>
				  </body>
				</html> """;
		response.getWriter().println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String error = null;
		Empleado emp = null;
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Todos los campos son obligatorios";
		} else {
			emp = servicio.login(usuario, password);
			if (emp==null) {
				error = "Usuario / contraseña erroneos";
			}
		}

		if (error != null) {
			mostrarLogin(request, response, error);
		} else {
			mostrarTareas(emp,request,response);
		}
	}
	
	private void mostrarTareas(Empleado emp, HttpServletRequest request, HttpServletResponse response) {
		String html = """
				<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

    <title>Hello, world!</title>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-3"></div>
        <div class="col-6 text-center">
          <h1>Tareas de</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Tarea</th>
                <th scope="col">Fecha Inicio</th>
                <th scope="col">Fecha Final</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              
            </tbody>
          </table>

          <table class="table">
            <thead class="thead-light">
              <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
  </body>
</html>

				""";
	}

}
