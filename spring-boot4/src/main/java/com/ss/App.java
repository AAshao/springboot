package com.ss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.ss.config.MyImportSelector;
import com.ss.mail.MailUtil;

@SpringBootApplication(exclude=ErrorMvcAutoConfiguration.class)

@Import(value=MyImportSelector.class)  //引入一个类
public class App {
		public static final String  basic_url="http://localhost:8080";
		public static void main(String[] args) throws  Exception {
			ConfigurableApplicationContext  context= SpringApplication.run(App.class, args);
//			context.getBean(MailUtil.class).getTempalte();
			context.getBean(MailUtil.class).sendMailFile();
//			RestTemplate restTemplate=new RestTemplate();
//			String infos=  restTemplate.getForObject(basic_url+"/user/queryStuList", String.class);
//			List<StudentInfo> infos2=JSONArray.parseArray(infos,StudentInfo.class);
//			System.out.println(infos2);
//			StudentInfo si= restTemplate.getForObject(basic_url+"/user/queryDetails/13", StudentInfo.class);
//			context.close();
		}
}
