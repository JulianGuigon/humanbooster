package com.tptopaidi.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topaidi.dao.IdeaJpaDao;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

import javassist.NotFoundException;

/**
 * Servlet implementation class IdeaController
 */
@WebServlet("/IdeaController")
public class IdeaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IdeaJpaDao ideaDao = new IdeaJpaDao();
	private int id = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdeaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Idea idea = null;

		switch (action) {
		case "menu":
			request.getRequestDispatcher("Pages/Menu.jsp").forward(request, response);
			break;
		case "list":
			List<Idea> listIdea = ideaDao.findAll();
			request.setAttribute("listIdea", listIdea);
			request.getRequestDispatcher("Pages/Idea/IdeaFormList.jsp").forward(request, response);
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			try {
				ideaDao.delete(id);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("IdeaController?action=list");
			break;
		case "new":
			idea = new Idea();
			request.setAttribute("ideaObject", idea);
			request.getRequestDispatcher("Pages/Idea/IdeaFormAdd.jsp").forward(request, response);
			break;
		case "edit":
			id = Integer.parseInt(request.getParameter("id"));
			try {
				idea = ideaDao.findByKey(id);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ideaObject", idea);
			request.getRequestDispatcher("Pages/Idea/IdeaFormAdd.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idForm"));
		String nameIdea = request.getParameter("nameIdeaForm");
		String descIdea = request.getParameter("descIdeaForm");
		String categoryName = request.getParameter("selectedCategoryForm");
		String urlImage = request.getParameter("imageIdeaForm");

		User user = new User("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a",true,true);
		
		if(id == 0) {
			Category category = new Category(categoryName ,LocalDate.now(),new Admin("Jean Guy","a.g@gmail.com","aaaa",new Address("France","Lyon",69130,"chemin Louis Chirpaz",8),"0477265898","a?","a"),null);
			ideaDao.insert(new Idea(nameIdea, descIdea, urlImage, LocalDate.now(), category, user));
		}else {
			try {
				Idea ideaUpdate =  ideaDao.findByKey(id);
				ideaUpdate.setTitle(nameIdea);
				ideaUpdate.setDescription(descIdea);
				ideaUpdate.getCategory().setName(categoryName);
				ideaUpdate.setPicture(urlImage);
				
				ideaDao.update(ideaUpdate);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("Pages/Menu.jsp").forward(request, response);
	}

}
