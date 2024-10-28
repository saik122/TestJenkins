package ApplicationDemo.demo.repo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class config {
    @Bean
        public DataSource dataSource() {
            return DataSourceBuilder.create()
                    .url("jdbc:mysql://localhost:3306/application")
                    .username("root")
                    .password("0valEdge!")
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .build();
        }

    }
