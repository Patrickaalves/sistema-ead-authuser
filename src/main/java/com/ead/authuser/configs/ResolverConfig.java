package com.ead.authuser.configs;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ResolverConfig implements WebMvcConfigurer {

    // Configuracoes de paginacao global
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        /*
         * O spring vai prescisar fazer toda verificação sempre que uma requisição for solicitada pelo client
         * Entao vai ter que ser interceptado essas solicitações, obter esses parametros(filtros especificos) e passar
         * para o spring data para realizar essas consultas
         * Simplificando argumentResolvers.add(new SpecificationArgumentResolver()); vai fazer a conversao desses parametros
         * para objetos do tipo java
         * */
        argumentResolvers.add(new SpecificationArgumentResolver());
        var pageableResolver = new PageableHandlerMethodArgumentResolver();
        pageableResolver.setFallbackPageable(PageRequest.of(0, 5));
        argumentResolvers.add(pageableResolver);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // adicionando para cada controller
        // No caso do user controller ele tera todas origens permitidas
        //registry.addMapping("/users/**").allowedOrigins("*");
        registry.addMapping("/**").allowedOrigins("*"); // para todos endpoints terao origem permitida
    }
}
