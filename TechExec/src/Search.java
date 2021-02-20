
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.data;
import util.Info;
import util.databaseUtil;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Search() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword").trim();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Memo Retrieved";
		String docType = "<!DOCTYPE html>";
		out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<ul>");
	      
	      
	      List<data> memoList = null;
	      if(keyword != null && keyword.isEmpty()) 
	    	  memoList = databaseUtil.memoList(keyword);
	      else
	    	  memoList= databaseUtil.memoList();
	      
	      display(memoList,out);
	      out.println("</ul>");
	      out.println("<a href=/" + Info.projectName + "/" + Info.insertWebAddress + ">Insert Memo</a> <br>");
	      out.println("</body></html>");
	}

	void display(List<data> memoList, PrintWriter out) {
		  for (data memoData : memoList) {
		         out.println(String.format("<li> Memo : %s <br><li> Description : %s <br><li> Estimated Date of Completion: %s <br><li>Estimated Time Cost:  %s <br><br><br>", memoData.getMemoName(),
		        		 memoData.getMemoDesc(),memoData.getMemoDate(),memoData.getMemoTime()));
		      }
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
