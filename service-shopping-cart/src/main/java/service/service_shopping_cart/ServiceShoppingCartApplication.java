package service.service_shopping_cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // habilitar feigns
public class ServiceShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShoppingCartApplication.class, args);
	}

}
