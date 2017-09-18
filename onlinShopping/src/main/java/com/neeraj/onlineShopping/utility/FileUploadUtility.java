package com.neeraj.onlineShopping.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String  ABS_PATH="C:\\Users\\a610641\\git\\online-shopping\\onlinShopping\\src\\main\\webapp\\assets\\images\\";
	private static  String  REAL_PATH="";
	public static void upload(HttpServletRequest request, MultipartFile file, String code) {
		 REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		 System.out.println("******************* "+REAL_PATH);
		 
		 if(!new File(ABS_PATH).exists()){
			 new File(ABS_PATH).mkdirs();
		 }
		 
		 if(!new File(REAL_PATH).exists()){
			 new File(REAL_PATH).mkdirs();
		 }
		 
		 try{
			 file.transferTo(new File(REAL_PATH + code+".JPG"));
			// file.transferTo(new File(ABS_PATH + code+".JPG"));
		 }
		 catch(IOException ex){
			 
		 }
		 
		
	}
	
}
