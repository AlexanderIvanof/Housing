/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.servletcontroller;

import java.util.List;

import java.util.Map;

import java.util.Set;

import java.util.Map.Entry;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Призрак
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // processRequest(request, response);
         System.out.println(" getReguestURL: "+request.getRequestURL());

		System.out.println(" getReguestURI: "+request.getRequestURI());

		String url = request.getRequestURI(); 

		String saveWorkTypeUrl = "saveWork.do" ;
                
                String addWork = "addWork.do" ; 
                
                String finishWork= "finishWork.do";

		if(url.endsWith(saveWorkTypeUrl)){

			System.out.println(" execute authentification ...... ");

			String theName = request.getParameter("txtUserName");

			System.out.println("!!!! name: " + theName);

			String thePass = request.getParameter("txtUsrPwd");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Controller talk");

			System.out.println("!!!! password: " + thePass);
                        
		} if(url.endsWith(addWork)){
                    
                    String theWorkType = request.getParameter("workType");
                    
                    String theWorkDate = request.getParameter("currentDate");
                    
                    String theWorkShare = request.getParameter("workScope");
                    
                    System.out.println("Controller talk" + theWorkType + theWorkDate + theWorkShare);
                    
                    
                }   if(url.endsWith(finishWork)){ 
                    
                }
		System.out.println(" getContextPath: " + request.getContextPath());



		Map<String, String[]> params = request.getParameterMap();



		for (Entry<String, String[]> param : params.entrySet() ){

			System.out.println("param name= " + param.getKey());

			for(String  str : param.getValue()){

				System.out.println(" param value = "+str);

			}
             }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		System.out.println(" POST getReguestURL: "+request.getRequestURL());

		System.out.println(" POST getReguestURI: "+request.getRequestURI());

		String url = request.getRequestURI(); 


		this.doGet(request, response);

	} 
	
	public void destroy() {

		super.destroy();

	}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
