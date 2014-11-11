package org.cdac;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/error").setViewName("error");
	}

	// @Bean
	// public ThymeleafTilesConfigurer tilesConfigurer() {
	// final ThymeleafTilesConfigurer tilesConfigurer = new
	// ThymeleafTilesConfigurer();
	// tilesConfigurer.setDefinitions("classpath:tiles/tiles.def.xml");
	// return tilesConfigurer;
	// }

	// @Override
	// public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/static/**")
	// .addResourceLocations("classpath:/static/")
	// .setCachePeriod(31556926);
	// registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	// }

}
