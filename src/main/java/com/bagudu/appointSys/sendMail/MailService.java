package com.bagudu.appointSys.sendMail;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/*import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;*/

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;


@Service
public class MailService {
	
		private static final Logger logger = LoggerFactory.getLogger(MailService.class);			

		
		public String sendTextEmail(String to, String subject, String body) throws IOException {
			
			Email from = new Email("bagudu@outlook.com");
			Email toEmail = new Email(to);
			Content content = new Content("text/plain", body);
			Mail mail = new Mail(from, subject, toEmail, content);
			
			SendGrid sg = new SendGrid("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"); 
			
			Request request = new Request();
		    try {
		      request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		      Response response = sg.api(request);
		      logger.info(response.getBody());
		      return response.getBody();	     
		    } catch (IOException ex) {
		      throw ex;
		    }	   
		}
		

}
