package io.gitlab.mihajlonesic.springgraphqlmysql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import io.gitlab.mihajlonesic.springgraphqlmysql.resolver.Query;
import io.gitlab.mihajlonesic.springgraphqlmysql.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGraphqlMysqlApplication {

    @Autowired
    private LanguageService languageService;

    public static void main(String[] args) {
        SpringApplication.run(SpringGraphqlMysqlApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean graphQLServlet() {
        return new ServletRegistrationBean(SimpleGraphQLHttpServlet.newBuilder(buildSchema(languageService)).build(),"/graphql");
    }

    private static GraphQLSchema buildSchema(LanguageService languageService) {
        return SchemaParser
                .newParser()
                .file("graphql/schema.graphql")
                .resolvers(new Query(languageService))
                .build()
                .makeExecutableSchema();
    }
}
