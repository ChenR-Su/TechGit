

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.databaseUtil;


@WebServlet("/Insertion")
public class Insertion extends HttpServlet implements Info {
	private static final long serialVersionUID = 1L;
       

    public Insertion() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memoName = request.getParameter("memoName").trim();
		String memoDesc = request.getParameter("memoDesc").trim();
		String memoDate = request.getParameter("memoDate").trim();
		String memoTime = request.getParameter("memoTime").trim();
		databaseUtil.createMemo(memoName, memoDesc, memoDate, memoTime);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 String title = "Memo Insertion";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<a href=/" + Info.projectName + "/" + Info.insertWebAddress + ">Memo Insertion Success, Click to Insert Another Memo</a> <br><br>");
	      out.println("<a href=/" + Info.projectName + "/" + Info.searchWebAddress + ">Memo Insertion Success, Click to Search For Memo</a> <br>");
	
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
