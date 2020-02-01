package museum.museum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"museum.application","museum.museum.dao",""})
public class MuseumApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumApplication.class, args);
	}

}
