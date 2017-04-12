package org.raescott.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.LinkedList;
import java.util.Properties;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean() {
		ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManagerFactoryBean.setFavorPathExtension(false);
		contentNegotiationManagerFactoryBean.setFavorParameter(false);
		Properties mediaTypeProperties = new Properties();
		mediaTypeProperties.setProperty("html", TEXT_HTML_VALUE);
		mediaTypeProperties.setProperty("json", APPLICATION_JSON_VALUE);
		contentNegotiationManagerFactoryBean.setMediaTypes(mediaTypeProperties);
		return contentNegotiationManagerFactoryBean;
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(99);
		internalResourceViewResolver.setPrefix("WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Bean
	public MappingJackson2JsonView mappingJackson2JsonView() {
		MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
		mappingJackson2JsonView.setPrefixJson(true);
		return mappingJackson2JsonView;
	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver.setOrder(1);
		contentNegotiatingViewResolver.setContentNegotiationManager(contentNegotiationManagerFactoryBean().getObject());
		LinkedList<ViewResolver> viewResolvers = new LinkedList<>();
		viewResolvers.add(jspViewResolver());
		contentNegotiatingViewResolver.setViewResolvers(viewResolvers);
		LinkedList<View> defaultViewResolvers = new LinkedList<>();
		defaultViewResolvers.add(mappingJackson2JsonView());
		contentNegotiatingViewResolver.setDefaultViews(defaultViewResolvers);
		return contentNegotiatingViewResolver;
	}

}
