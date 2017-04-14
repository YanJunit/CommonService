package miteke.angular.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import miteke.angular.model.Hero;

/**
 * Servlet implementation class SingleHero
 */
@WebServlet("/getHeroById")
public class SingleHero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SingleHero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/JSON; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setDateHeader("Expires", 0);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(200);
		List<Hero> list = HeroInfo.list;
		String idstr = request.getParameter("id");
		Integer id;
		Hero her0_ = new Hero();
		if (idstr!=null &&! idstr.equals("null") && !idstr.trim().isEmpty()) {
			id = Integer.valueOf(idstr);
			her0_.setId(id);
			list.forEach((hero) -> {
				if (id.equals(hero.getId()))
					her0_.setName(hero.getName());
			});
		}
		response.getWriter().write(new Gson().toJson(her0_));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
