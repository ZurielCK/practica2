package com.example.persona;


import com.example.persona.Servicio.modelo.BeanPersona;
import com.example.persona.Servicio.persona.DaoPersona;

import javax.servlet.*;
import javax.servlet.http.*;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPersona", urlPatterns = "/ServletPersona")
public class ServletPersona extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    String urlRedirect  = "";

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";
        String clase = "";
        RequestDispatcher rd = null;
        String peticion = request.getParameter("accion");
        RequestDispatcher dispatcher = null;
        HttpSession sesionLogin;

        switch (peticion) {

            case "registrar":
                String nombre = request.getParameter("nombre");
                String surname = request.getParameter("surname");
                String curp = request.getParameter("curp");
                String cumple = request.getParameter("cumple");

                BeanPersona persona = new BeanPersona();
                List<BeanPersona> list  = DaoPersona.getTodosPersonas();
                request.setAttribute("persona", list);
                System.out.println("persona :" + persona);
                if (new DaoPersona().registrarPersona(persona)) {
                    mensaje = "Usuario registrado correctamente.";
                    clase = "alert alert-success";
                    System.out.println("El usuario ha sido registrado");
                    DaoPersona.getTodosPersonas();
                    urlRedirect = "/index.jsp";

                    request.getRequestDispatcher(mensaje);
                } else {
                    request.setAttribute("mensaje", "Error al registrar el usuario!");
                    System.out.println("El usuario no se sido registrado");
                    mensaje = "Error al registrar el usuario.";
                    clase = "alert alert-danger";
                    dispatcher = request.getRequestDispatcher("listDispo");
                    request.getRequestDispatcher(mensaje);
                }
                doGet(request, response);
                break;


        }
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("clase", clase);
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }

}