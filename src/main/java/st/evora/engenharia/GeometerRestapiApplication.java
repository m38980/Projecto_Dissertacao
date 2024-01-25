package st.evora.engenharia;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import st.evora.engenharia.controller.GeorreferenciaController;


@SpringBootApplication
public class GeometerRestapiApplication {

	public static void main(String[] args) {
		
		new File(GeorreferenciaController.uploadDirectory).mkdir();
		
		SpringApplication.run(GeometerRestapiApplication.class, args);
	}
}
