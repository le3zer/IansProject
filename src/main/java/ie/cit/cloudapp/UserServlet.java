package ie.cit.cloudapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class UserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserRepository repo = getRepo(req);
		req.setAttribute("users", repo.getUsers());
		doForward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserRepository repo = getRepo(req);
		User user = new User();
		user.setFirstName(req.getParameter("firstName"));
		user.setSurname(req.getParameter("surname"));
		user.setEmail(req.getParameter("email"));
		repo.addUser(user);
		req.setAttribute("users", repo.getUsers());
		doForward(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer index = Integer.valueOf(req.getParameter("userId"));
		UserRepository repo = getRepo(req);
		User user = repo.getUsers().get(index - 1);
		user.setDone(!user.isDone());
		req.setAttribute("users", repo.getUsers());
		doForward(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer index = Integer.valueOf(req.getParameter("userId"));
		UserRepository repo = getRepo(req);
		repo.getUsers().remove(index - 1);
		req.setAttribute("users", repo.getUsers());
		doForward(req, resp);
	}

	private UserRepository getRepo(HttpServletRequest req) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		return ctx.getBean("repo", UserRepository.class);
	}
	
	private void doForward(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/user_list.jsp");
		rd.forward(req, resp);
	}

}
