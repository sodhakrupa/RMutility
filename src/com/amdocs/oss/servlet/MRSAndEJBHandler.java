package com.amdocs.oss.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MRSAndEJBHandler
 */
@WebServlet("/MRSAndEJBHandler")
public class MRSAndEJBHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MRS_REQUEST ="MRS";
	private static final String QS_REQUEST = "QS";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRSAndEJBHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fieldName = "",requestType="",environment="",mrsRequestString="";
		boolean isFormField;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				isFormField = fileItem.isFormField();
				fieldName = fileItem.getFieldName();
				if (isFormField) {
					if("requestType".equalsIgnoreCase(fieldName)){
						requestType = fileItem.getString();
						System.out.println("requestType:"+requestType);
					}
					if("environment".equalsIgnoreCase(fieldName)){
						environment = fileItem.getString();
						System.out.println("environment:"+environment);
					}	
				} else {
					mrsRequestString = fileItem.getString();
					System.out.println("file form field</td><td>FIELD NAME: " + fileItem.getFieldName() +
							"\nSTRING: " + fileItem.getString() +
							"\nNAME: " + fileItem.getName() +
							"\nCONTENT TYPE: " + fileItem.getContentType() +
							"\nSIZE (BYTES): " + fileItem.getSize() +
							"\nTO STRING: " + fileItem.toString()
							);
					
				}
				
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Response.jsp");
			if(MRS_REQUEST.equalsIgnoreCase(requestType)){
				// call
			}else if(QS_REQUEST.equalsIgnoreCase(requestType)){
				
			}
		
			requestDispatcher.forward(request, response);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
