package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.CalcInterface;
import calc.Calculator;

public class CalcServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Calculator servlet works!!!!!!!!!!!!!!!!");
		CalcInterface calc = new Calculator();
		Integer par1 = Integer.valueOf(req.getParameter("firstnumber"));
		Integer par2 = Integer.valueOf(req.getParameter("secondnumber"));
		int result = 0;

		if (req.getParameter("sum") != null) {
			// update button is clicked
			// Do the update action or forward the request to the servlet to do
			// update action

			result = calc.sum(par1.intValue(), par2.intValue());

		} else if (req.getParameter("multiply") != null) {
			// delete button is clicked
			result = calc.multiply(par1.intValue(), par2.intValue());
			// Do the delete action or forward the request to the servlet to do
			// delete action
		} else if (req.getParameter("minus") != null) {
			// delete button is clicked
			result = calc.minus(par1.intValue(), par2.intValue());
			// Do the delete action or forward the request to the servlet to do
			// delete action
		} else if (req.getParameter("sqr") != null) {
			// delete button is clicked
			result = calc.sqr();
			// Do the delete action or forward the request to the servlet to do
			// delete action
		}

		ResultBean resultBean = new ResultBean();
		resultBean.setResult(result);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher(
				"/index.jsp");
		req.setAttribute("result", Integer.toString(result));
		disp.forward(req, resp);
	}

	public static class ResultBean {
		int result;

		public int getResult() {
			return result;
		}

		public void setResult(int result) {
			this.result = result;
		}

	}
}
