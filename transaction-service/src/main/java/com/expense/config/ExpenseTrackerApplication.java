package com.expense.config;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(scanBasePackages = "com.expense, com.nci")
@EntityScan(basePackages = { "com.expense" })
@EnableJpaRepositories("com.expense")
public class ExpenseTrackerApplication {

	public static void main(String[] args) throws InvalidPasswordException,
			IOException {
		ApplicationContext ctx = SpringApplication.run(
				ExpenseTrackerApplication.class, args);
		DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx
				.getBean("dispatcherServlet");
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

	}
}
