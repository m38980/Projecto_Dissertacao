package st.evora.engenharia;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
		String  rawPassword8 = "password";
		String encodedPassword8 = encoder.encode(rawPassword8); 		
		System.out.println(encodedPassword8);
		
	}

}
















