package co.com.jeferson.productsproject.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;


//Mongo auditing configuration for @CreatedDate and @LastModifiedDate
@Configuration
@EnableReactiveMongoAuditing
public class MongoConfig {
}
