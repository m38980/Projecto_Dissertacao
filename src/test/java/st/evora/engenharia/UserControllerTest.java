package st.evora.engenharia;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import st.evora.engenharia.controller.UserController;
import st.evora.engenharia.model.Role;
import st.evora.engenharia.model.User;
import st.evora.engenharia.repository.RoleRepository;
import st.evora.engenharia.repository.UserRepository;
import st.evora.engenharia.service.UserService;
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;
	@MockBean
	private RoleRepository roleRepository;
	@MockBean
	private UserRepository userRepository;
	@Test
	public void testExportPdf() throws Exception {
		List<User>listUsers = new ArrayList<>();
		Set<Role> roles = new HashSet<>();
		roles.add(new Role("Admin"));
		listUsers.add(new User((long) 1, "fp@gmail.com", "fp", "$2a$10$SqysacxgrksQj8r3S3cre.0ZMxs1Qh4KtpsI21Yd0fAeAjOhfADOq", 
										  true, roles));
		listUsers.add(new User((long) 2, "alz@gmail.com", "alz", "$2a$10$6I9qvgn7VmCVOw/u.H5dleaiYpjMBV2gfjuHlke9RvIPmSR406MT.",
									      true, roles));
		listUsers.add(new User((long) 3, "lis@gmail.com","lis", "$2a$10$uFlwSUrseY6aHqikwKatg./bN2FpUfrifXHu8Q4mHmwfT9ETJOh6a",
										  true, roles));
		listUsers.add(new User((long) 4, "lav@gmail.com","lav", "$2a$10$arFt38Q7Jl1Tk2IQdI/bxONPhs0R.01PUOrZcY3pq.DZRikDlKw9e",
										  true, roles));
		
		Mockito.when(userService.listPdfUser()).thenReturn(listUsers);
		String url = "/users/users/export/pdf";	
		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
		byte[] bytes =  mvcResult.getResponse().getContentAsByteArray();
		Path path = Paths.get("users.pdf");
		Files.write(path, bytes);
	}
}
