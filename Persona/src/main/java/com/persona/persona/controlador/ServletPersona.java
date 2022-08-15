package com.persona.persona.controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.persona.persona.modelo.BeanPersona;
import com.persona.persona.modelo.DaoPersona;
import com.persona.persona.persona.ServicePersona;
import com.persona.persona.utils.ResultAction;

import javax.servlet.annotation.*;
import java.sql.SQLException;

@WebServlet(name = "ServletPersona", urlPatterns = {
        "/persona",
        "/add",
        "/update",
        "/update-persona",
        "/guardar-persona",
        "/add-persona"
})
public class ServletPersona extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPersona");
    String action;
    String urlRedirect = "/get-personas";
    DaoPersona daoPersona = new DaoPersona();
    ServicePersona servicePersona = new ServicePersona();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path->"+action);
        switch (action){
            case "/persona":
                request.setAttribute("personas",servicePersona.getAll());
                urlRedirect = "/vistas/persona.jsp";
                break;
            case"/add":
                urlRedirect ="/vistas/añadirPersona.jsp";
                break;
            case "/update":
                urlRedirect ="/vistas/editarPersona.jsp";
                break;
            default:
                request.setAttribute("personas",servicePersona.getAll());
                urlRedirect = "/persona";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch(action){
            case "/persona":
                String id2 = request.getParameter("id");
                daoPersona.delete(Long.parseLong(id2));
                urlRedirect = "/persona";
                break;
            case "/add-persona":
                //add-persona
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String curp = request.getParameter("curp");
                String cumple = request.getParameter("cumple");
                BeanPersona persona = new BeanPersona();
                persona.setName(name);
                persona.setSurname(surname);
                persona.setCurp(curp);
                persona.setCumple(cumple);
                ResultAction result = servicePersona.save(persona);
                urlRedirect = "/persona?result="+
                        result.isResult()+"&message="+result.getMessage() +
                        URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                        +"&status="+result.getStatus();
                break;
            case "/update-persona":
                //editar persona
                String nombre2 = request.getParameter("name");
                String surname2 = request.getParameter("surname");
                String curp2 = request.getParameter("curp");
                String cumple2 = request.getParameter("cumple");
                String id = request.getParameter("id");
                BeanPersona persona2 = new BeanPersona();
                persona2.setId(Long.parseLong(id));
                persona2.setName(nombre2);
                persona2.setSurname(surname2);
                persona2.setCurp(curp2);
                persona2.setCumple(cumple2);
                ResultAction result2 = servicePersona.update(persona2);
                urlRedirect = "/persona?result=" +
                        result2.isResult() + "&message=" +
                        URLEncoder.encode(result2.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result2.getStatus();
                break;
            default:
                urlRedirect = "/persona";
                break;

        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}