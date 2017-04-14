package miteke.angular.service;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miteke.angular.model.Hero;

/**
 * Servlet implementation class HeroDelete
 */
@WebServlet("/deleteById")
public class HeroDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(HeroDelete.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HeroDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqid = request.getParameter("id");
		Hero ho = new Hero();
		System.out.println(reqid);
		Integer id_ = reqid != null && !reqid.equals("null") ? Integer.parseInt(reqid) : 0;
		
		logger.info("Receive Client Request  Fo r  Delete");
		HeroInfo.list.spliterator().forEachRemaining((hero) -> {
			if (hero.getId().equals(id_)) {
				ho.setId(hero.getId());
				ho.setName(hero.getName());
			}
		});
		response.getWriter().write("{\"status\":\"200\"}");
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
