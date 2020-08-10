package com.wsl.flight.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build();
	}
//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("monkeyzicloud-api")
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//				.paths(PathSelectors.any())
//				.build();
//	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//标题
				.title("Spring Boot 中使用 Swagger2 构建 RESTful APIs")
				//简介
				.description("hello swagger")
				//服务条款
				.termsOfServiceUrl("1. xxx\n2. xxx\n3. xxx")
				//作者个人信息
				.contact(new Contact("admin", "http://www.baidu.com", "571035128@qq.com"))
				//版本
				.version("1.0")
				.build();
	}
}