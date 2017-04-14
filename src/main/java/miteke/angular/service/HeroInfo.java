package miteke.angular.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import miteke.angular.model.Hero;

/**
 * Servlet implementation class HeroInfo
 */
@WebServlet("/getHeros")
public class HeroInfo extends HttpServlet {
	private static  Logger logger = Logger.getLogger(HeroInfo.class.getName());
	private static final long serialVersionUID = 1L;
    public static  List<Hero> list=new ArrayList<>();
    static{
    	list.add(new Hero(11, "Mr. Nice"));
		list.add(new Hero(12, "Narco"));
		list.add(new Hero(13, "Bombasto"));
		list.add(new Hero(14, "Celeritas"));
		list.add(new Hero(15, "Magneta"));
		list.add(new Hero(16, "RubberMan"));
		list.add(new Hero(17, "Dynama"));
		list.add(new Hero(18, "Dr. IQ"));
		list.add(new Hero(19, "Magma"));
		list.add(new Hero(20, "Tornado"));
		list.add(new Hero(21, "Stone Heaven"));
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeroInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/JSON; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setDateHeader("Expires", 0);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(200);
		Gson gson = new Gson();
		list.toArray().toString();
		logger.info("Array String : \t"+list.toArray().toString());
		logger.info("List String : \t"+list.toString());
		response.getWriter().write(gson.toJson(list));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
