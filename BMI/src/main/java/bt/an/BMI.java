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
		String styles = "<style>"
	            + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }"
	            + "form { background: white; padding: 20px; border-radius: 10px; width: 300px; margin: 50px auto; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); }"
	            + "label { font-weight: bold; display: block; margin-top: 10px; }"
	            + "input[type='text'] { width: 100%; padding: 8px; margin: 5px 0; border: 1px solid #ccc; border-radius: 5px; }"
	            + "input[type='submit'] { background: #28a745; color: white; padding: 10px; border: none; border-radius: 5px; cursor: pointer; width: 100%; }"
	            + "input[type='submit']:hover { background: #218838; }"
	            + "</style>";

	    print.append("<html><head><title>BMI Calculator</title>" + styles + "</head><body>");
	    print.append("<h2>BMI Calculator</h2>");
	    print.append("<form method='POST' action='/BMI/BMI'>"
	            + "<label>Cân nặng (kg):</label>"
	            + "<input type='text' name='weight' placeholder='Nhập cân nặng'>"
	            + "<label>Chiều cao (m):</label>"
	            + "<input type='text' name='height' placeholder='Nhập chiều cao'>"
	            + "<input type='submit' value='Tính BMI'>"
	            + "</form>");
	    print.append("</body></html>");
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
