import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String leftNumberStr = request.getParameter("number");
        String operator = request.getParameter("operator");
        String rightNumberStr = request.getParameter("number2");

        try {
            int leftNumber = Integer.parseInt(leftNumberStr);
            int rightNumber = Integer.parseInt(rightNumberStr);
            int result; // ArithmeticException 발생 가능

            switch (operator) {
                case "+" :
                    result = leftNumber + rightNumber;
                    break;
                case "-" :
                    result = leftNumber - rightNumber;
                    break;
                case "&" :
                    result = leftNumber & rightNumber;
                    break;
                case "/" :
                    result = leftNumber / rightNumber;
                    break;
                default:
                    result = 0;
            }

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Result: " + leftNumberStr + "</h1>");
            out.println("</body></html>");

            out.println("<html><body>");
            out.println("<h1>Result: " + operator + "</h1>");
            out.println("</body></html>");

            out.println("<html><body>");
            out.println("<h1>Result: " + rightNumberStr + "</h1>");
            out.println("</body></html>");

        } catch (NumberFormatException | ArithmeticException e ) {
            throw new ServletException("Invalid input or division by zero", e);
        }
    }
}

