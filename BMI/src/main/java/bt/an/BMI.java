package bt.an;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BMI
 */
@WebServlet("/BMI")
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter print = response.getWriter();
		print.append("BMI Calculator");
		String inputName = "<form method = POST action=\"/BMI/BMI\">"
				+ "<lable> Cân nặng: </lable>"
				+ "<input type = \"text\" name =\"weight\">"
				+ "<lable> Chiều cao: </lable>"
				+ "<input type = \"text\" name =\"height\">"
				+ "<input type = \"submit\" value =\"Send\">"
				+ "</form>";
		print.append(inputName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String valueHeight = request.getParameter("height");
		String valueWeight = request.getParameter("weight");
		float height = Float.parseFloat(valueHeight);
		float weight = Float.parseFloat(valueWeight);
		float BMI = weight / (height * height);
		PrintWriter print = response.getWriter();
		print.append("Bạn đang "
				+ checkBMI(BMI));
	}
	
	private String checkBMI(float BMI) {
		if(BMI >= 30) return "Béo phì";
		else if (BMI >= 25) return "Thừa cân";
		else if (BMI >= 18.5f) return "Bình thường";
		else return "Gầy";
	}

}
