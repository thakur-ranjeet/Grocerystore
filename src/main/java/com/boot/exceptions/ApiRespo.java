package com.boot.exceptions;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public class ApiRespo {
	 
	
		private String message;
		private boolean status;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "ApiResponse [message=" + message + ", status=" + status + "]";
		}
		public ApiRespo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public void addResourceHandlers(ResourceHandlerRegistry registry)
	      {
	        //enabling swagger-ui part for visual documentation
	        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	      }

	}



