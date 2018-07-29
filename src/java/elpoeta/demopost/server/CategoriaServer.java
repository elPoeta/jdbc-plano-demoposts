/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elpoeta.demopost.server;

import com.google.gson.Gson;
import elpoeta.demopost.domain.Categoria;
import elpoeta.demopost.repository.impl.CategoriaRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elpoeta
 */
@WebServlet(name = "CategoriaServer", urlPatterns = {"/api/categoriaServer"})
public class CategoriaServer extends HttpServlet {
    
  final static Gson CONVERTIR = new Gson();
 
	     @Override
	     protected void doGet(HttpServletRequest request, HttpServletResponse response)
	             throws ServletException, IOException {
	         response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         try {
	             List<Categoria> listado =  CategoriaRepositoryImpl.getInstance().buscarTodos();
	             String resultado = CONVERTIR.toJson(listado);
	             out.println("" + resultado);

	         } catch (ClassNotFoundException ex) {
	             out.println("Verificar:" + ex.getMessage());
	         } catch (SQLException ex) {
	             out.println("Verificar:" + ex.getMessage());
	         } catch (Exception ex) {
	             out.println("Verificar:" + ex.getMessage());
	         } finally {
	             out.close();
	         }
	     }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
