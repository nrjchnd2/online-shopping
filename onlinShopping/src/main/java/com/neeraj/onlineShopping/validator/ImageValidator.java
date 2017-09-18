package com.neeraj.onlineShopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neeraj.shoppingbackend.dto.Product;

public class ImageValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Product.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Product p=(Product)arg0;
		if(p.getFile()==null || p.getFile().getOriginalFilename().equals("")){
			arg1.rejectValue("file",null,"Please upload an image");
			return;
		}
		
		if(!(p.getFile().getContentType().equals("image/jpeg")||
				p.getFile().getContentType().equals("image/png")||
				p.getFile().getContentType().equals("image/gif")
				)){
			
			arg1.rejectValue("file",null,"Please upload only an image file");
			return;
			
		}
			

	}

}
